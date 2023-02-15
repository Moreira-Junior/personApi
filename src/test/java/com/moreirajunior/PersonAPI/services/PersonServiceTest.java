package com.moreirajunior.PersonAPI.services;

import com.moreirajunior.PersonAPI.models.Address;
import com.moreirajunior.PersonAPI.models.Person;
import com.moreirajunior.PersonAPI.models.dtos.AddressDto;
import com.moreirajunior.PersonAPI.models.dtos.PersonDto;
import com.moreirajunior.PersonAPI.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("PersonServiceTest")
public class PersonServiceTest {

    @MockBean
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    private PersonDto personDto;
    private Person person;

    @BeforeEach
    public void setUp(){
        AddressDto addressdto = new AddressDto("Street 1", 12345L, 12, "City1");
        this.personDto = new PersonDto("Name", LocalDate.now(), List.of(addressdto));
        Address address = new Address("Street 1", 12345L, 12, "City1");
        this.person = new Person("Name", LocalDate.now(), List.of(address));
        this.person.setId(1L);
    }

    @Test
    public void shouldCreatePerson(){
        Mockito.when(personRepository.save(Mockito.any())).thenReturn(person);
        personService.createPearson(personDto);
        Mockito.verify(personRepository, times(1)).save(Mockito.any());
    }

    @Test
    public void shouldFindById(){
        Mockito.when(personRepository.findById(1L)).thenReturn(Optional.ofNullable(this.person));
        personService.getPersonById(1L);
        Mockito.verify(personRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void shouldFindAll(){
        List<Person> personList = List.of(this.person);
        Mockito.when(personRepository.findAll()).thenReturn(personList);
        personService.getPeople();
        Mockito.verify(personRepository, Mockito.times(1)).findAll();
    }

}
