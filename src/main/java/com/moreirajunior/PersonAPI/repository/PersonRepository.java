package com.moreirajunior.PersonAPI.repository;

import com.moreirajunior.PersonAPI.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
