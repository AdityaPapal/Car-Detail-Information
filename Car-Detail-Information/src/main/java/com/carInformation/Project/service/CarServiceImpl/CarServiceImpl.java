package com.carInformation.Project.service.CarServiceImpl;

import com.carInformation.Project.entities.Cars;
import com.carInformation.Project.exception.ResourceNotFoundException;
import com.carInformation.Project.payloads.CarDto;
import com.carInformation.Project.repositories.CarRepo;
import com.carInformation.Project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Override
    public CarDto createCar(CarDto cardto) {

        //Process:  Dto to data -> save in database -> data to dto;

        Cars car = this.dtoToCar(cardto);
        Cars saveCar = this.carRepo.save(car);
        return this.carToDto(saveCar);
    }

    @Override
    public CarDto updateCar(CarDto cardto, int id) {
        Cars car = this.carRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Car","id",id));

        car.setId(cardto.getId());
        car.setCompanyName(cardto.getCompanyName());
        car.setCarName(cardto.getCarName());
        car.setEngine(cardto.getEngine());
        car.setPower(cardto.getPower());
        car.setTorque(cardto.getTorque());
        car.setDisplacement(cardto.getDisplacement());

        Cars updatedCar = this.carRepo.save(car);
        CarDto cardto1 = this.carToDto(updatedCar);

        return cardto1;
    }

    @Override
    public CarDto getCarById(int id) {
        Cars car = this.carRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Car","id",id));
        return this.carToDto(car);
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Cars> cars = this.carRepo.findAll();
        List<CarDto> cardtos = cars.stream().map(
                car->this.carToDto(car)).collect(Collectors.toList());

        return cardtos;
    }

    @Override
    public void deleteCar(int id) {
        Cars car = this.carRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Car","id",id));

        this.carRepo.delete(car);

    }

    public Cars dtoToCar(CarDto cardto){
        Cars car = new Cars();

        car.setId(cardto.getId());
        car.setCompanyName(cardto.getCompanyName());
        car.setCarName(cardto.getCarName());
        car.setEngine(cardto.getEngine());
        car.setPower(cardto.getPower());
        car.setTorque(cardto.getTorque());
        car.setDisplacement(cardto.getDisplacement());

        return car;
    }

    public CarDto carToDto(Cars car){
        CarDto cardto = new CarDto();

        cardto.setId(car.getId());
        cardto.setCompanyName(car.getCompanyName());
        cardto.setCarName(car.getCarName());
        cardto.setEngine(car.getEngine());
        cardto.setPower(car.getPower());
        cardto.setTorque(car.getTorque());
        cardto.setDisplacement(car.getDisplacement());
        return cardto;
    }



}
