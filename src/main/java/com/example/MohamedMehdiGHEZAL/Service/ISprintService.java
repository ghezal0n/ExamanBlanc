package com.example.MohamedMehdiGHEZAL.Service;

import com.example.MohamedMehdiGHEZAL.Entities.Sprint;
import com.example.MohamedMehdiGHEZAL.Entities.User;

import java.util.List;

public interface ISprintService {
    List<Sprint> retrieveAll();

    Sprint add(Sprint u);

    void delete(int id);

    Sprint update(Sprint u);

    User retrieve(int id);

    void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
