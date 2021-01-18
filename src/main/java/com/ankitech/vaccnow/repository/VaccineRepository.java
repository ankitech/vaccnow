package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Vaccine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends CrudRepository<Vaccine, String> {
}
