package com.mandate.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    public void addNewDriver(Driver driver){
        if (driver == null)
            throw new IllegalStateException("Cannot add null driver value");

        Optional<Driver> driverOptional = driverRepository.findDriverByPesel(driver.getPesel());
        if (driverOptional.isPresent()){
            Driver existingDriver = driverOptional.get();
            throw new IllegalStateException("Pesel already exist and belongs to: " + existingDriver);
        }
        this.driverRepository.save(driver);
    }

    public void deleteDriver(Long driverId) {
        boolean exists = driverRepository.existsById(driverId);
        if(!exists){
            throw new IllegalStateException("Driver with id: " + driverId + " does not exists");
        }
        driverRepository.deleteById(driverId);
    }

    public Optional<Driver> getDriverByPesel(String pesel) {
        return driverRepository.findDriverByPesel(pesel);
    }
}
