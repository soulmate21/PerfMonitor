package com.wind.perfmonitor.service.impl;

import com.wind.perfmonitor.Repository.ProjectMemberRepository;
import com.wind.perfmonitor.dto.ProjectDTO;
import com.wind.perfmonitor.entity.Project;
import com.wind.perfmonitor.entity.ProjectMember;
import com.wind.perfmonitor.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    @Transactional
    @Override
    public List<ProjectDTO> findProjectsByUser(Integer userId) {
        List<ProjectMember> members = projectMemberRepository.findByUserId(userId);

        return members.stream().
                map(ProjectMember::getProject)
                .map(this::convertToDTO)
                .toList();

//        User user = new User();
//        user.setId(userId);
//        List<ProjectMember> memberships = projectMemberRepository.findByUser(user);
//        return memberships.stream()
//                .map(ProjectMember::getProject)
//                .collect(Collectors.toList());
    }
    private ProjectDTO convertToDTO(Project project) {

        return new ProjectDTO(
                project.getId(),
                project.getName(),
                project.getDescription()
        );
    }

}
