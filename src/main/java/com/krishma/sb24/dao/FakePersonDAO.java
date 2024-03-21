package com.krishma.sb24.dao;

import com.krishma.sb24.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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

}
