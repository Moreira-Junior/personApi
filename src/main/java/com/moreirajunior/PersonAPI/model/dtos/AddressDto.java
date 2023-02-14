package com.moreirajunior.PersonAPI.model.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AddressDto {

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 20)
    private String street;
    @NotNull
    private Long zipCode;
    @NotNull
    private int number;
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 20)
    private String city;

    public AddressDto() {
    }

    public AddressDto(String street, Long zipCode, int number, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
