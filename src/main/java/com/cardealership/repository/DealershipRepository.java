package com.cardealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardealership.entity.Dealership;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, String> {

}
