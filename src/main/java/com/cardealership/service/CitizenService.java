package com.cardealership.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealership.entity.Citizen;
import com.cardealership.repository.CitizenRepository;
import java.util.Optional;

@Service
public class CitizenService {

    @Autowired
    private CitizenRepository citizenRepository;

    public void addCitizen(Citizen citizen) throws Exception {
        Optional<Citizen> byId = citizenRepository.findById(citizen.getVat());
        if (!byId.isPresent()) {
            citizenRepository.save(citizen);
        }
    }

    public Optional<Citizen> login(String vat, String password) {
        return citizenRepository.findById(vat)
                .filter(citizen -> citizen.getPassword().equals(password));
    }
}