package com.mv.med.repository;

import com.mv.med.entities.MedicalRegistrationEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicalRegistrationRepository extends JpaRepository<MedicalRegistrationEntity, UUID>  {
}
