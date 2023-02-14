package com.moreirajunior.PersonAPI.service;

import com.moreirajunior.PersonAPI.appLogger.AppLogger;
import com.moreirajunior.PersonAPI.exceptions.AddressNotFoundException;
import com.moreirajunior.PersonAPI.mapper.Mapper;
import com.moreirajunior.PersonAPI.model.dtos.AddressDto;
import com.moreirajunior.PersonAPI.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    private static final Logger LOGGER = AppLogger.getAppLogger();

    public List<AddressDto> getPersonAddressList(Long id) {
        List<AddressDto> addressDtoList = this.addressRepository.findByPersonId(id).stream().map(Mapper::addressToDto).collect(Collectors.toList());
        if(addressDtoList.size() > 0) {
            LOGGER.info("Address list from id: " + id);
            return addressDtoList;
        } else {
            LOGGER.warning("Address not found!");
            throw new AddressNotFoundException();
        }
    }

}
