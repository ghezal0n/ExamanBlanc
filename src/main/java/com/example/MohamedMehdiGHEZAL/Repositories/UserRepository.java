package com.example.MohamedMehdiGHEZAL.Repositories;

import com.example.MohamedMehdiGHEZAL.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByFirstNameAndLastName(String fName, String lName);
    //public User findUserByFNameAndLName(String fName, String lName);
}
