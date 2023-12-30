package com.mv.med.dto;

public record AddressDto(String publicPlace,
                         String neighborhood,
                         String zipCode,
                         String city,
                         String uf,
                         Integer number,
                         String complement) {
}
