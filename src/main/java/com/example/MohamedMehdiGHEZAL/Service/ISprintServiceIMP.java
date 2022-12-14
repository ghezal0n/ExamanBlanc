package com.example.MohamedMehdiGHEZAL.Service;

import com.example.MohamedMehdiGHEZAL.Entities.Project;
import com.example.MohamedMehdiGHEZAL.Entities.Sprint;
import com.example.MohamedMehdiGHEZAL.Entities.User;
import com.example.MohamedMehdiGHEZAL.Repositories.ProjectRepository;
import com.example.MohamedMehdiGHEZAL.Repositories.SprintRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class ISprintServiceIMP implements ISprintService{
    @Autowired
    SprintRepository sprintRepository;
    ProjectRepository projectRepository;

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        if(project != null){
            //sprint.setProjet(project);
            sprintRepository.save(sprint);
        }

    }

    @Override
    @GetMapping()
    public List<Sprint> retrieveAll() {
        return sprintRepository.findAll();
    }

    @Override
    @PutMapping()
    public Sprint add(Sprint u) {
        //
        return sprintRepository.save(u);
    }

    @Override

    public void delete(int id) {
        sprintRepository.deleteById(id);
    }

    @Override
    public Sprint update(Sprint u) {
        return sprintRepository.save(u);
    }

    @Override
    public User retrieve(int id) {
        return null;
    }

}
