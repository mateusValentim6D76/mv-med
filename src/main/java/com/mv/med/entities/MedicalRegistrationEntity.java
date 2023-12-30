package com.mv.med.entities;

import com.mv.med.dto.MedicalRegistrationDto;
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
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new AddressEntity(data.address());
    }
}
