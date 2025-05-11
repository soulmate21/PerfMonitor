package com.wind.perfmonitor.Repository;

import com.wind.perfmonitor.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}

