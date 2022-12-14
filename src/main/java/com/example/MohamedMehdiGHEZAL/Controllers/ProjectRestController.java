package com.example.MohamedMehdiGHEZAL.Controllers;

import com.example.MohamedMehdiGHEZAL.Entities.Project;
import com.example.MohamedMehdiGHEZAL.Entities.User;
import com.example.MohamedMehdiGHEZAL.Service.IProjectService;
import com.example.MohamedMehdiGHEZAL.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProjectRestController {
    @Autowired
    IUserService userService;
    IProjectService projectService;

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    @PostMapping("/project")
    public Project addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }
}
