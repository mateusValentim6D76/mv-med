package com.mv.med.dto;

import com.mv.med.enums.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicalRegistrationDto(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        String telephone,
        @NotBlank
        @Pattern(regexp = "\\d{4,8}")
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull
        @Valid
        AddressDto address) {
}
