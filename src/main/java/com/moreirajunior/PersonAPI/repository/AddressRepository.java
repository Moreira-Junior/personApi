package com.moreirajunior.PersonAPI.repository;

import com.moreirajunior.PersonAPI.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select a from Person p join Address a where p.id = :id")
    List<Address> findByPersonId(@Param("id") Long id);


}
