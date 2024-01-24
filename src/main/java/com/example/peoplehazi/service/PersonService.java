package com.example.peoplehazi.service;

import com.example.peoplehazi.domain.Person;
import com.example.peoplehazi.dto.incoming.PersonCommand;
import com.example.peoplehazi.dto.outgoing.PersonDetailsListItem;
import com.example.peoplehazi.exception.CustomException;
import com.example.peoplehazi.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public PersonDetailsListItem getPersonByEmail(String email) {
        Person person = personRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        PersonDetailsListItem personItem = new PersonDetailsListItem(person);
        return personItem;
    }


    public void addNewPerson(PersonCommand command) {
        Person person = new Person(command);
        personRepository.save(person);
    }

    public void delete(Person person) {
        if (!personRepository.existsById(person.getId())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Error: The person does not exist.");
        }
        personRepository.deleteById(person.getId());
    }

    public void deleteByEmail(String email) {
        if (!personRepository.existsByEmail(email)) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Error: The person does not exist.");
        }
        personRepository.deleteByEmail(email);
    }

}
