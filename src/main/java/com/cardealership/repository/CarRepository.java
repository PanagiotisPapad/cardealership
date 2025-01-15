package com.cardealership.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cardealership.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
