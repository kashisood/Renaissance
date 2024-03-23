package com.krishma.sb24.service;

import com.krishma.sb24.dao.IPersonDao;
import com.krishma.sb24.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// This annotation tells Spring that this class needs to be instantiated as a bean so that it can be injected in other classes
// we can also use @Component annotation, but @Service is more precise as this depicts the class as Service class - @Autowired annotation to be used
@Service
public class PersonService {

    private final IPersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDAO") IPersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
            return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.getAllPeople();
    }

    public Boolean deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public Boolean updatePersonByID(UUID id, Person person) {
        return personDao.updatePersonByID(id, person);
    }
}
