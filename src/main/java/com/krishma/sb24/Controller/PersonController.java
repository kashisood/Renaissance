package com.krishma.sb24.Controller;

import com.krishma.sb24.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
}
