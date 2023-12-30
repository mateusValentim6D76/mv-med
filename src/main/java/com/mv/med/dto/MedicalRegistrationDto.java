package com.mv.med.dto;

import com.mv.med.enums.Specialty;

public record MedicalRegistrationDto(String name,
                                     String email,
                                     String crm,
                                     Specialty specialty,
                                     AddressDto address) {
}
