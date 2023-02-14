package com.moreirajunior.PersonAPI.repositories;

import com.moreirajunior.PersonAPI.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select a from Person p join Address a where p.id = :id")
    List<Address> findByPersonId(@Param("id") Long id);


}
