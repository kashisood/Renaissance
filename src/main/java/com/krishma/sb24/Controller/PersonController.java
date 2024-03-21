package com.krishma.sb24.Controller;

import com.krishma.sb24.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {


    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
}
