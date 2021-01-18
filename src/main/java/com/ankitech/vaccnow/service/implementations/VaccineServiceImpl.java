package com.ankitech.vaccnow.service.implementations;

import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.repository.VaccineRepository;
import com.ankitech.vaccnow.service.interfaces.VaccineService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public List<Vaccine> findAllVaccines() {
        List<Vaccine> result = new ArrayList<>();
        vaccineRepository.findAll().forEach(result::add);
        return result;
    }
}
