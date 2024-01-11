package com.mv.med.controller;

import com.mv.med.dto.DataListDoctors;
import com.mv.med.dto.MedicalDataUpdate;
import com.mv.med.dto.MedicalRegistrationDto;
import com.mv.med.dto.MedicalUpdateDto;
import com.mv.med.entities.MedicalRegistrationEntity;
import com.mv.med.enums.Specialty;
import com.mv.med.repository.MedicalRegistrationRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<Page<DataListDoctors>> findAll(@PageableDefault(size = 10, sort = {"name", "crm"}) Pageable pageable){
        var getAllMedical =  medicalRegistrationRepository.findByActiveTrue(pageable).map(DataListDoctors::new);
        return ResponseEntity.ok(getAllMedical);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid MedicalUpdateDto data){
        var dataUpdate = medicalRegistrationRepository.getReferenceById(data.id());
        dataUpdate.updatedMedical(data);
        return ResponseEntity.ok(new MedicalDataUpdate(dataUpdate));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable UUID id){
        var inactiveDoc = medicalRegistrationRepository.getReferenceById(id);
        inactiveDoc.delete();
        return ResponseEntity.noContent().build();
    }
}
