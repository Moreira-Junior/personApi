package com.moreirajunior.PersonAPI.models;

import com.moreirajunior.PersonAPI.models.dtos.PersonDto;
import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDtoTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void shouldBeValid() {
        PersonDto personDto = new PersonDto("Name", LocalDate.now(), new ArrayList<>());
        Set<ConstraintViolation<PersonDto>> violations = validator.validate(personDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldNotHasEmptyName() {
        PersonDto personDto = new PersonDto("", LocalDate.now(), new ArrayList<>());
        Set<ConstraintViolation<PersonDto>> violations = validator.validate(personDto);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    void shouldNotHasTooShortName() {
        PersonDto personDto = new PersonDto("Lua", LocalDate.now(), new ArrayList<>());
        Set<ConstraintViolation<PersonDto>> violations = validator.validate(personDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasTooLongName() {
        PersonDto personDto = new PersonDto("Too long name for that case", LocalDate.now(), new ArrayList<>());
        Set<ConstraintViolation<PersonDto>> violations = validator.validate(personDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasNullBirthDay() {
        PersonDto personDto = new PersonDto("Name", null, new ArrayList<>());
        Set<ConstraintViolation<PersonDto>> violations = validator.validate(personDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasNullAddressList() {
        PersonDto personDto = new PersonDto("Name", LocalDate.now(), null);
        Set<ConstraintViolation<PersonDto>> violations = validator.validate(personDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

}
