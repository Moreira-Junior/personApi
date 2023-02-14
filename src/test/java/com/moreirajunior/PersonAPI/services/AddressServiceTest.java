package com.moreirajunior.PersonAPI.services;

import com.moreirajunior.PersonAPI.models.Address;
import com.moreirajunior.PersonAPI.repositories.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("AddressServiceTest")
public class AddressServiceTest {

    @MockBean
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;

    @Test
    public void shouldFindAll(){
        Address address = new Address("Street 1", 12345L, 12, "City1");
        List<Address> addressList = List.of(address);
        Mockito.when(addressRepository.findByPersonId(1L)).thenReturn(addressList);
        addressService.getPersonAddressList(1L);
        Mockito.verify(addressRepository, Mockito.times(1)).findByPersonId(1L);
    }
}
