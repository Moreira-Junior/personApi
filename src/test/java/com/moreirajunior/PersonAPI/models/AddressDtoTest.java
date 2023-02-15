package com.moreirajunior.PersonAPI.models;

import com.moreirajunior.PersonAPI.models.dtos.AddressDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AddressDtoTest {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void shouldBeValid() {
        AddressDto addressDto = new AddressDto("Street 1", 12345L, 12, "City1");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void shouldNotHasEmptyStreetName() {
        AddressDto addressDto = new AddressDto("", 12345L, 12, "City1");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    void shouldNotHasTooShortStreetName() {
        AddressDto addressDto = new AddressDto("Str", 12345L, 12, "City1");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasTooLongStreetName() {
        AddressDto addressDto = new AddressDto("Imagine having a street name bigger than 20 chars", 12345L, 12, "City1");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasNullZipCode() {
        AddressDto addressDto = new AddressDto("Street 1", null, 12, "City1");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasEmptyCityName() {
        AddressDto addressDto = new AddressDto("Street", 12345L, 12, "");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(2, violations.size());
    }

    @Test
    void shouldNotHasTooShortCityName() {
        AddressDto addressDto = new AddressDto("Street", 12345L, 12, "Cit");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }

    @Test
    void shouldNotHasTooLongCitytName() {
        AddressDto addressDto = new AddressDto("Street", 12345L, 12, "Imagine having a city name bigger than 20 chars");
        Set<ConstraintViolation<AddressDto>> violations = validator.validate(addressDto);
        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
    }
}
