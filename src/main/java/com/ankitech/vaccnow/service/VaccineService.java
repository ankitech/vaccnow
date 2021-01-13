package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Vaccine;

import java.util.List;

public interface VaccineService {

    List<Vaccine> findAllVaccines();
}
