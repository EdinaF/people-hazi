package com.example.peoplehazi.repository;

import com.example.peoplehazi.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    Optional<Person> findByEmail(String email);

    void deleteByEmail(String email);

    boolean existsByEmail(String email);
}
