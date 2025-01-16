package com.cardealership.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cardealership.entity.Dealership;
import com.cardealership.repository.DealershipRepository;

@Service
public class DealershipService {

    @Autowired
    private DealershipRepository dealershipRepository;

    public void addDealership(Dealership dealership) throws Exception {
        Optional<Dealership> byId = dealershipRepository.findById(dealership.getVat());
        if (!byId.isPresent()) {
            dealershipRepository.save(dealership);
        }
    }

    public Optional<Dealership> login(String vat, String password) {
        return dealershipRepository.findById(vat)
                .filter(dealership -> dealership.getPassword().equals(password));
    }
}