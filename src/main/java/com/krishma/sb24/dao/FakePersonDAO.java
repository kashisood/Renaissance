package com.krishma.sb24.dao;

import com.krishma.sb24.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// This annotation tells Spring that this class needs to be instantiated as a bean so that it can be injected in other classes
// we can also use @Component annotation, but @Repository is more precise as this depicts the class as Repository
@Repository("fakeDAO")
public class FakePersonDAO implements IPersonDao{

    private static List<Person> mockDataBase = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        mockDataBase.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return mockDataBase;
    }

    @Override
    public Boolean deletePerson(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if(person.isEmpty())
        {
            return false;
        }
        else {
            mockDataBase.remove(person.get());
        }
        return true;
    }

    @Override
    public Boolean updatePersonByID(UUID id, Person person) {

        Optional<Person> personOld = selectPersonById(id);
       /* if(personOld.isEmpty()) {
            mockDataBase.add(new Person(id, person.getName()));
        } else {
            mockDataBase.remove(personOld.get());
            mockDataBase.add(person);
        }*/


            int delIndex = mockDataBase.indexOf(personOld.get());
            if(delIndex >= 0) {
                Person pNew = new Person(personOld.get().getId() , person.getName());
                mockDataBase.set(delIndex, pNew);
                return true;
             }
        return false;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        //We will search if the ID exists in our database by Streaming our database
        return mockDataBase.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

}
