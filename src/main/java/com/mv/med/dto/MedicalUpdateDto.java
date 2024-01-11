package com.mv.med.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record MedicalUpdateDto(
        @NotNull
        UUID id,
        String name,
        String email,
        String telephone,
        AddressDto addressDto) {

}
