package com.krishma.sb24.Controller;

import com.krishma.sb24.model.Person;
import com.krishma.sb24.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

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
    public void addPerson(@Valid @NotNull@RequestBody Person person)
    {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> personList()
    {
        return personService.getAllPeople();
    }

    @DeleteMapping(path = "{id}")
    public Boolean deletePerson(@PathVariable("id") UUID id)
    {
        return personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public Boolean updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person)
    {
        return personService.updatePersonByID(id, person);
    }
    @GetMapping(path = "{id}")
    public Person getPersonById (@PathVariable("id") UUID id)
    {
        return personService.selectPersonByID(id).orElse(null);
    }


}
