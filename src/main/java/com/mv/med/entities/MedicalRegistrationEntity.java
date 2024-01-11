package com.mv.med.entities;

import com.mv.med.dto.MedicalRegistrationDto;
import com.mv.med.dto.MedicalUpdateDto;
import com.mv.med.enums.Specialty;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Table(name = "medical_registration")
@Entity(name = "MedicalRegistration")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicalRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Boolean active;
    private String name;
    private String email;
    private String telephone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private AddressEntity address;

    public MedicalRegistrationEntity(MedicalRegistrationDto data) {
        this.name = data.name();
        this.active = true;
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new AddressEntity(data.address());
    }

    public void updatedMedical(MedicalUpdateDto data) {
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.email() != null){
            this.email = data.email();
        }
        if (data.telephone() != null){
            this.telephone = data.telephone();
        }
        if (data.addressDto() != null){
            this.address.updateAddress(data.addressDto());
        }
    }

    public void delete() {
        this.active = false;
    }
}
