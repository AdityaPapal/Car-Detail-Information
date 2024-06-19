package com.carInformation.Project.service;

import com.carInformation.Project.payloads.CarDto;

import java.util.List;

public interface CarService {

        CarDto createCar(CarDto car);
        CarDto updateCar(CarDto car,int id);
        CarDto getCarById(int id);
        List<CarDto> getAllCars();
        void deleteCar(int id);


}
