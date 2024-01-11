package com.mv.med.dto;

import com.mv.med.entities.MedicalRegistrationEntity;
import com.mv.med.enums.Specialty;

import java.util.Locale;
import java.util.UUID;

public record DataListDoctors(UUID id, String name, String email, String crm, Specialty specialty) {

    public DataListDoctors(MedicalRegistrationEntity medicalRegistrationEntity) {

        this(medicalRegistrationEntity.getId(), medicalRegistrationEntity.getName(), medicalRegistrationEntity.getEmail(), medicalRegistrationEntity.getCrm(), medicalRegistrationEntity.getSpecialty());

    }
}
