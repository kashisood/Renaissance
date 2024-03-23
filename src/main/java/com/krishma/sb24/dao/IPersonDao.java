package com.krishma.sb24.dao;

import com.krishma.sb24.model.Person;

import java.util.List;
import java.util.UUID;

public interface IPersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPeople();

    Boolean deletePerson(UUID id);

    Boolean updatePersonByID(UUID id, Person person);
}
