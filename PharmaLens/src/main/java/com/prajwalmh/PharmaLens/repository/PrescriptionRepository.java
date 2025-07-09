package com.prajwalmh.PharmaLens.repository;



import com.prajwalmh.PharmaLens.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    // Default CRUD methods available automatically
}
