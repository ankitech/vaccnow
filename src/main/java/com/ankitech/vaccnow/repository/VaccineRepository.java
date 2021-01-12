package com.ankitech.vaccnow.repository;

import com.ankitech.vaccnow.model.Vaccine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineRepository extends MongoRepository<Vaccine, String> {
}
