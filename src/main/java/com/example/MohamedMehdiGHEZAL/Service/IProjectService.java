package com.example.MohamedMehdiGHEZAL.Service;

import com.example.MohamedMehdiGHEZAL.Entities.Project;
import com.example.MohamedMehdiGHEZAL.Entities.User;

import java.util.List;

public interface IProjectService {
    List<Project> retrieveAll();
    Project addProject(Project u);
    void delete(int id);
    Project update(Project u);
    Project retrieve(int id);
    List<Project> getAllCurrentProject();
}
