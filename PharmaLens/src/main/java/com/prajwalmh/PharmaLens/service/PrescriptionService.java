package com.prajwalmh.PharmaLens.service;



import com.prajwalmh.PharmaLens.entity.Prescription;
import com.prajwalmh.PharmaLens.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository repository;

    public PrescriptionService(PrescriptionRepository repository) {
        this.repository = repository;
    }

    public Prescription savePrescription(Prescription prescription) {
        return repository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return repository.findAll();
    }
}
