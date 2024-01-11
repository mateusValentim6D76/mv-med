package com.mv.med.repository;

import com.mv.med.entities.MedicalRegistrationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicalRegistrationRepository extends JpaRepository<MedicalRegistrationEntity, UUID>  {

    Page<MedicalRegistrationEntity> findByActiveTrue(Pageable pageable);
}
