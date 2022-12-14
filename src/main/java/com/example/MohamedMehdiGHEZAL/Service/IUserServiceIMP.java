package com.example.MohamedMehdiGHEZAL.Service;

import com.example.MohamedMehdiGHEZAL.Entities.Project;
import com.example.MohamedMehdiGHEZAL.Entities.User;
import com.example.MohamedMehdiGHEZAL.Repositories.ProjectRepository;
import com.example.MohamedMehdiGHEZAL.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class IUserServiceIMP implements IUserService{
    @Autowired
    UserRepository userRepository;
    ProjectRepository projectRepository;

    @Override
    @GetMapping()
    public List<User> retrieveAll() {
        return userRepository.findAll();
    }

    @Override
    @PutMapping()
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        if (project != null && user != null){
            user.getProjects().add(project);
            userRepository.save(user);
        }
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findByFirstNameAndLastName(firstName,lastName);
        if (project != null && user != null){
            user.getProjects().add(project);
            userRepository.save(user);
        }
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User user = userRepository.findByFirstNameAndLastName(fName,lName);
        return user != null ? user.getProjects() : null;
    }

}
