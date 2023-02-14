package com.moreirajunior.PersonAPI.controller;

import com.moreirajunior.PersonAPI.models.dtos.AddressDto;
import com.moreirajunior.PersonAPI.models.dtos.PersonDto;
import com.moreirajunior.PersonAPI.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonDto> getPeople(){
        return this.personService.getPeople();
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable("id")Long id){
        return this.personService.getPersonById(id);
    }

    @PostMapping
    public PersonDto createPerson(@RequestBody @Valid PersonDto personDto){
        return this.personService.createPearson(personDto);
    }

    @PutMapping("/{id}")
    public PersonDto editPerson(@PathVariable("id")Long id, @RequestBody @Valid PersonDto personDto){
        return this.personService.editPerson(id, personDto);
    }

    @PostMapping("/{id}")
    public PersonDto createPersonsAddress(@PathVariable("id") Long id, @RequestBody @Valid AddressDto addressDto){
        return this.personService.createPersonsAddress(id, addressDto);
    }
}
