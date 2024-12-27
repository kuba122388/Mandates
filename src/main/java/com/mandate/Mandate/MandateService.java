package com.mandate.Mandate;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MandateService {
    private final MandateRepository mandateRepository;

    @Autowired
    public MandateService(MandateRepository mandateRepository) {
        this.mandateRepository = mandateRepository;
    }

    public List<Mandate> getMandates() {
        return mandateRepository.findAll();
    }

    public Mandate createMandate(Mandate mandate) {
        if (mandate == null)
            throw new IllegalStateException("Cannot create null mandate");
        mandateRepository.save(mandate);
        return mandate;
    }

    @Transactional
    public Mandate activateMandate(Long mandateId) {
        Mandate existingMandate = mandateRepository.findById(mandateId).orElseThrow(() ->
                new IllegalStateException("Mandate does not exists"));

        if (existingMandate.getStatus() == Status.AKTYWNY)
            throw new IllegalStateException("Mandate is already active");
        existingMandate.setStatus(Status.AKTYWNY);
        return existingMandate;
    }

    @Transactional
    public Mandate cancelMandate(Long mandateId) {
        Mandate existingMandate = mandateRepository.findById(mandateId).orElseThrow(() ->
                new IllegalStateException("Mandate does not exists"));

        if (existingMandate.getStatus() == Status.ANULOWANY)
            throw new IllegalStateException("Mandate is already canceled");
        existingMandate.setStatus(Status.ANULOWANY);
        return existingMandate;
    }

    public void deleteMandate(Long mandateId) {
        boolean exists = mandateRepository.existsById(mandateId);
        if (!exists) {
            throw new IllegalStateException("Mandate with mandateId: " + mandateId + " does not exists");
        }
        mandateRepository.deleteById(mandateId);
    }
}
