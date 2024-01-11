package com.mv.med.dto;

import com.mv.med.entities.AddressEntity;
import com.mv.med.entities.MedicalRegistrationEntity;
import com.mv.med.enums.Specialty;

import java.util.UUID;

public record MedicalDataUpdate(UUID id, String name, String email, String crm, Specialty specialty, AddressEntity address) {

    public MedicalDataUpdate(MedicalRegistrationEntity medicalRegistrationEntity){
        this(medicalRegistrationEntity.getId(), medicalRegistrationEntity.getName(), medicalRegistrationEntity.getEmail(), medicalRegistrationEntity.getCrm(), medicalRegistrationEntity.getSpecialty(), medicalRegistrationEntity.getAddress());
    }
}
