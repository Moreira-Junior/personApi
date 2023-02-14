package com.moreirajunior.PersonAPI.repositories;

import com.moreirajunior.PersonAPI.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
