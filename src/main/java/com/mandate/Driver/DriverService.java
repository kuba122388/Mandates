package com.mandate.Driver;
import com.mandate.Policeman.Policeman;
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

    public Driver getDriverByPesel(String pesel){
        Optional<Driver> driver = driverRepository.findDriverByPesel(pesel);
//        if(driver.isEmpty())
//            throw new IllegalStateException("Driver with id: " + pesel + " does not exists");
        return driver.orElse(null);
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
}
