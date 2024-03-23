package com.krishma.sb24.Controller;

import com.krishma.sb24.model.Person;
import com.krishma.sb24.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//since this is a controller class.. or API front end class or RET API controller, it must be defined as RESTController
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

// add comment in develop branch
    private final PersonService personService;

    @Autowired // this is dependency injection. SB injects the actual service into this constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // This is the API endpoint. This will be called from the CLient (UI/Postman/Curl etc) The client will send HTTP Get/put/post/delete/.. type of request
    // so we define which method to be called based on the HTTP type. this method will be exposed to the client as endpoint
    // get - retrieve data, post - add resource to server , put- modifying , delete - deleting
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }
}
