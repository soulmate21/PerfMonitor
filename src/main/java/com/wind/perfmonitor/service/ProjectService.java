package com.wind.perfmonitor.service;

import com.wind.perfmonitor.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    public List<ProjectDTO> findProjectsByUser(Integer userId);
}
