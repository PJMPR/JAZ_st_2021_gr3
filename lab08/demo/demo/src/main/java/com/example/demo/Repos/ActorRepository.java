package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Actor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
