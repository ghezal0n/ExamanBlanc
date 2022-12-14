package com.example.MohamedMehdiGHEZAL.Service;

import com.example.MohamedMehdiGHEZAL.Entities.Project;
import com.example.MohamedMehdiGHEZAL.Entities.User;
import com.example.MohamedMehdiGHEZAL.Repositories.ProjectRepository;
import com.example.MohamedMehdiGHEZAL.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class IProjectServiceIMP implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;
    UserRepository userRepository;

    @Override
    @GetMapping
    public List<Project> retrieveAll() {
        return projectRepository.findAll();
    }

//    @Override
//    public void assignProjToUser(Integer idP, Integer idU){
//        Project project = ProjectRepository.findById(idP).orElse(null);
//        User user = userRepository.findBy();
//    }

    @Override
    @PutMapping()
    public Project addProject(Project u) {
        return projectRepository.save(u);
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    @PutMapping()
    public Project update(Project u) {
        return projectRepository.save(u);
    }

    @Override
    @PutMapping()
    public Project retrieve(int id) {
        return null; //projectRepository.findAllById(id).orElse(null);
    }

    @Override
    public List<Project> getAllCurrentProject() {
        return projectRepository.findAll().stream()
                .filter(project -> project.getSprintList().stream()
                        .anyMatch(sprint -> sprint.getStartDate().before(new Date()))
                ).collect(Collectors.toList());
    }

    @Scheduled(fixedRate = 30000)
    public void getNbrSprintByCurrentProject(){
        List<Project> list = getAllCurrentProject();
       // list.stream().forEach(e -> log.info(String.valueOf(e.getSprintList().size())));
    }


}
