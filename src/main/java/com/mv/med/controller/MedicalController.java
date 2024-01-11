package com.mv.med.controller;

import com.mv.med.dto.DataListDoctors;
import com.mv.med.dto.MedicalRegistrationDto;
import com.mv.med.dto.MedicalUpdateDto;
import com.mv.med.entities.MedicalRegistrationEntity;
import com.mv.med.enums.Specialty;
import com.mv.med.repository.MedicalRegistrationRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class MedicalController {

    @Autowired
    private MedicalRegistrationRepository medicalRegistrationRepository;
    @PostMapping
    @Transactional
    public void insert(@RequestBody @Valid MedicalRegistrationDto data){
        var created = medicalRegistrationRepository.save(new MedicalRegistrationEntity(data));
    }

    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin
    public Page<DataListDoctors> findAll(@PageableDefault(size = 10, sort = {"name", "crm"}) Pageable pageable){
        return medicalRegistrationRepository.findAll(pageable).map(DataListDoctors::new);
    }

    @PatchMapping
    public void update(@RequestBody @Valid MedicalUpdateDto data){
        var dataUpdate = medicalRegistrationRepository.getReferenceById(data.id());
        dataUpdate.updatedMedical(data);
    }
}
