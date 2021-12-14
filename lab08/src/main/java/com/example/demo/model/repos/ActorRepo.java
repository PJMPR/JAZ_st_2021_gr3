package com.example.demo.model.repos;

import com.example.demo.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepo extends JpaRepository<Actor, Integer> {
    Actor findByFirstNameAndLastName(String firstName, String LastName);
}