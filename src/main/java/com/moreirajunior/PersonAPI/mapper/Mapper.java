package com.moreirajunior.PersonAPI.mapper;

import com.moreirajunior.PersonAPI.model.Address;
import com.moreirajunior.PersonAPI.model.Person;
import com.moreirajunior.PersonAPI.model.dtos.AddressDto;
import com.moreirajunior.PersonAPI.model.dtos.PersonDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public static PersonDto personToDto(Person person){
        String name = person.getName();
        LocalDate birthDay = person.getBirthDay();
        List<AddressDto> addressDtoList = person.getAddressList().stream().map(Mapper::addressToDto).collect(Collectors.toList());
        return new PersonDto(name, birthDay, addressDtoList);
    }

    public static AddressDto addressToDto(Address address){
        String street = address.getStreet();
        Long zipCode = address.getZipCode();
        int number = address.getNumber();
        String city = address.getCity();
        return new AddressDto(street, zipCode, number, city);
    }

    public static Person dtoToPerson(PersonDto personDto){
        return new Person(personDto.getName(), personDto.getBirthDay(), personDto.getAddressList().stream().map(Mapper::dtoToAddress).collect(Collectors.toList()));
    }

    public static Address dtoToAddress(AddressDto addressDto){
        return new Address(addressDto.getStreet(), addressDto.getZipCode(), addressDto.getNumber(), addressDto.getCity());
    }
}
