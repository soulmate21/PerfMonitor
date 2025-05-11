package com.wind.perfmonitor.Repository;

import com.wind.perfmonitor.entity.Project;
import com.wind.perfmonitor.entity.ProjectMember;
import com.wind.perfmonitor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer> {

    List<ProjectMember> findByUserId(Integer userId);


    List<ProjectMember> findByUser(User user);

    List<ProjectMember> findByProject(Project project);
}

