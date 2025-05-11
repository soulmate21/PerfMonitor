package com.wind.perfmonitor.controller.home;

import com.wind.perfmonitor.dto.ProjectDTO;
import com.wind.perfmonitor.entity.User;
import com.wind.perfmonitor.service.ProjectService;
import context.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/myprojects")
    public List<ProjectDTO> myProjects() {
        User currentUser = UserContext.getUser();   //使用拦截器配置请求用户
        return projectService.findProjectsByUser(currentUser.getId());
    }
}
