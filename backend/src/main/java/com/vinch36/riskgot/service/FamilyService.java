package com.vinch36.riskgot.service;

import com.vinch36.riskgot.model.game.Family;
import com.vinch36.riskgot.repository.jpa.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public Optional<Family> getFamily(final Long id){
        return familyRepository.findById(id);
    }

    public Iterable<Family> getFamilies(){
        return familyRepository.findAll();
    }

    public void deleteFamily(final Long id){
        familyRepository.deleteById(id);
    }

    public Family saveFamily(Family family){
        Family savedFamily=familyRepository.save(family);
        return savedFamily;
    }
}
