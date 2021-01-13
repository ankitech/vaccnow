package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.repository.VaccineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public List<Vaccine> findAllVaccines() {
        return vaccineRepository.findAll();
    }
}
