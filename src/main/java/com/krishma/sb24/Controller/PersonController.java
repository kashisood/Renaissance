package com.krishma.sb24.Controller;

import com.krishma.sb24.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {

// add comment in develop branch
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
}
