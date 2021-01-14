package com.ankitech.vaccnow.service;

import com.ankitech.vaccnow.model.Vaccine;
import com.ankitech.vaccnow.repository.VaccineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VaccineServiceImplTest {

    private final Vaccine v1 = Vaccine.builder().name("covax").cost(1000).build();
    private final Vaccine v2 = Vaccine.builder().name("pfizer").cost(2000).build();
    private final Vaccine v3 = Vaccine.builder().name("bharattec").cost(350).build();
    @Mock
    private VaccineRepository vaccineRepository;
    @InjectMocks
    private VaccineServiceImpl vaccineService;

    @Test
    void findAllVaccines() {

        when(vaccineRepository.findAll()).thenReturn(List.of(v1, v2, v3));
        List<Vaccine> allVaccines = vaccineService.findAllVaccines();

        verify(vaccineRepository, times(1)).findAll();
        assertEquals(3, allVaccines.size());
    }
}