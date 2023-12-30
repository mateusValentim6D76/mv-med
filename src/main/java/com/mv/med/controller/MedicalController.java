package com.mv.med.controller;

import com.mv.med.dto.MedicalRegistrationDto;
import com.mv.med.entities.MedicalRegistrationEntity;
import com.mv.med.repository.MedicalRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctors")
public class MedicalController {

    @Autowired
    private MedicalRegistrationRepository medicalRegistrationRepository;
    @PostMapping
    public void insert(@RequestBody MedicalRegistrationDto data){
        medicalRegistrationRepository.save(new MedicalRegistrationEntity(data));

    }
}
