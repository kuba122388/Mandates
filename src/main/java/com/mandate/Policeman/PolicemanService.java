package com.mandate.Policeman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicemanService {
    private final PolicemanRepository policemanRepository;

    @Autowired
    public PolicemanService(PolicemanRepository policemanRepository) {
        this.policemanRepository = policemanRepository;
    }

    public List<Policeman> getPolicemen() {
        return policemanRepository.findAll();
    }

    public Policeman getPolicemanByBadge(String numerSluzbowy) {
        Optional<Policeman> policeman = policemanRepository.findPolicemanByBadge(numerSluzbowy);
        if(policeman.isEmpty())
            throw new IllegalStateException("Policeman with Badge Number of: " + numerSluzbowy + " does not exist");
        return policeman.get();
    }

    public void addNewPoliceman(Policeman policeman){
        Optional<Policeman> policemanOptional = policemanRepository.findPolicemanByBadge(policeman.getPesel());
        if (policemanOptional.isPresent()){
            Policeman existingPoliceman = policemanOptional.get();
            throw new IllegalStateException("Pesel already exist and belongs to: " + existingPoliceman);
        }
        this.policemanRepository.save(policeman);
    }

    public void deletePoliceman(Long badgeId) {
        boolean exists = policemanRepository.existsById(badgeId);
        if(!exists){
            throw new IllegalStateException("Policeman with badge number: " + badgeId + " does not exists");
        }
        policemanRepository.deleteById(badgeId);
    }
}
