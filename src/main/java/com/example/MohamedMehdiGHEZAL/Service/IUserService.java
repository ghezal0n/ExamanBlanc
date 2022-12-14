package com.example.MohamedMehdiGHEZAL.Service;

import com.example.MohamedMehdiGHEZAL.Entities.Project;
import com.example.MohamedMehdiGHEZAL.Entities.User;

import java.util.List;

public interface IUserService {
    List<User> retrieveAll();
    User addUser(User u);
//    void delete(int id);
//    User update(User u);
//    User retrieve(int id);
    void assignProjectToUser(int projectId, int userId);
    void assignProjectToClient(int projectId, String firstName, String lastName);
    List<Project> getProjectsByScrumMaster(String fName, String lName);

}
