package com.moreirajunior.PersonAPI.model.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDto {

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 20)
    private String name;
    @NotNull
    private LocalDate birthDay;
    @NotNull
    private List<AddressDto> addressList = new ArrayList<>();

    public PersonDto() {
    }
    public PersonDto(String name, LocalDate birthDay, List<AddressDto> addressList) {
        this.name = name;
        this.birthDay = birthDay;
        this.addressList = addressList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDto> addressList) {
        this.addressList = addressList;
    }
}
