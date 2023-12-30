package com.mv.med.entities;

import com.mv.med.dto.AddressDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private String publicPlace;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String uf;
    private Integer number;
    private String complement;

    public AddressEntity(AddressDto address) {
        this.publicPlace = address.publicPlace();
        this.neighborhood = address.neighborhood();
        this.zipCode = address.zipCode();
        this.city = address.city();
        this.uf = address.uf();
        this.number = address.number();
        this.complement = address.complement();
    }
}
