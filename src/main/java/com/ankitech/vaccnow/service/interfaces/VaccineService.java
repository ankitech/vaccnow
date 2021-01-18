package com.ankitech.vaccnow.service.interfaces;

import com.ankitech.vaccnow.model.Vaccine;

import java.util.List;

public interface VaccineService {

    List<Vaccine> findAllVaccines();
}
