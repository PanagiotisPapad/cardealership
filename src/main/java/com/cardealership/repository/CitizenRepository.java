package com.cardealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardealership.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, String> {

}
