package com.moreirajunior.PersonAPI.services;

import com.moreirajunior.PersonAPI.appLogger.AppLogger;
import com.moreirajunior.PersonAPI.exceptions.PersonNotFoundException;
import com.moreirajunior.PersonAPI.mapper.Mapper;
import com.moreirajunior.PersonAPI.models.Address;
import com.moreirajunior.PersonAPI.models.Person;
import com.moreirajunior.PersonAPI.models.dtos.AddressDto;
import com.moreirajunior.PersonAPI.models.dtos.PersonDto;
import com.moreirajunior.PersonAPI.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private static final Logger LOGGER = AppLogger.getAppLogger();
    public List<PersonDto> getPeople() {
        LOGGER.info("Get all people!");
        return this.personRepository.findAll().stream().map(Mapper::personToDto).collect(Collectors.toList());
    }

    @Transactional
    public PersonDto createPearson(PersonDto personDto) {
        Person person = Mapper.dtoToPerson(personDto);
        Person personCreated = this.personRepository.save(person);
        LOGGER.info("Person created");
        return Mapper.personToDto(personCreated);
    }

    public PersonDto getPersonById(Long id) {
        Person person = this.getPerson(id);
        LOGGER.info("Person found");
        return Mapper.personToDto(person);
    }

    private Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> {
            LOGGER.warning("Person not found!");
            return new PersonNotFoundException();
        });
    }

    @Transactional
    public PersonDto editPerson(Long id, PersonDto personDto){
        Person person = Mapper.dtoToPerson(personDto);
        person.setId(this.getPerson(id).getId());
        Person editedPerson = this.personRepository.save(person);
        LOGGER.info("Edited person");
        return Mapper.personToDto(editedPerson);
    }

    @Transactional
    public PersonDto createPersonsAddress(Long id, AddressDto addressDto) {
        Person personFound = this.getPerson(id);
        Address address = Mapper.dtoToAddress(addressDto);
        personFound.getAddressList().add(address);
        Person personWithNewAddress = this.personRepository.save(personFound);
        LOGGER.info("Address entered in person");
        return Mapper.personToDto(personWithNewAddress);
    }
}
