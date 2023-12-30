package com.mv.med.dto;

import com.mv.med.entities.MedicalRegistrationEntity;
import com.mv.med.enums.Specialty;

import java.util.Locale;

public record DataListDoctors(String name, String email, String crm, Specialty specialty) {

    public DataListDoctors(MedicalRegistrationEntity medicalRegistrationEntity) {

        this(medicalRegistrationEntity.getName(), medicalRegistrationEntity.getEmail(), medicalRegistrationEntity.getCrm(), medicalRegistrationEntity.getSpecialty());

    }
}
