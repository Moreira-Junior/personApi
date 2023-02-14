package com.moreirajunior.PersonAPI.controller;

import com.moreirajunior.PersonAPI.model.dtos.AddressDto;
import com.moreirajunior.PersonAPI.model.dtos.PersonDto;
import com.moreirajunior.PersonAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public List<AddressDto> getPersonAddressList(@PathVariable("id")Long id){
        return this.addressService.getPersonAddressList(id);
    }

    @GetMapping("/main/{id}")
    public AddressDto getMainAddress(@PathVariable("id")Long id){
        return this.addressService.getPersonAddressList(id).get(0);
    }
    
}
