package com.moreirajunior.PersonAPI.controller;

import com.moreirajunior.PersonAPI.models.dtos.AddressDto;
import com.moreirajunior.PersonAPI.services.AddressService;
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
