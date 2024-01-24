package com.example.peoplehazi.controller;

import com.example.peoplehazi.domain.Person;
import com.example.peoplehazi.dto.incoming.PersonCommand;
import com.example.peoplehazi.dto.outgoing.PersonDetailsListItem;
import com.example.peoplehazi.exception.CustomException;
import com.example.peoplehazi.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<PersonDetailsListItem> getPersonByEmail(@PathVariable String email) {
        PersonDetailsListItem personItem = personService.getPersonByEmail(email);
        return new ResponseEntity<>(personItem, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNewPerson (@Valid @RequestBody PersonCommand command) {
        personService.addNewPerson(command);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Person person) {
        try {
            personService.delete(person);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatus());
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteByEmail(@PathVariable String email) {
        try {
            personService.deleteByEmail(email);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.getMessage(), e.getStatus());
        }
    }

}
