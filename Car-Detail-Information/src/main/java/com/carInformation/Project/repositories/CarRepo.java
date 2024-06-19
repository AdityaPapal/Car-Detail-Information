package com.carInformation.Project.repositories;

import com.carInformation.Project.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Cars,Integer> {

}
