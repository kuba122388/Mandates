package com.mandate.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("select d from Driver d where d.pesel = ?1")
    Optional<Driver> findDriverByPesel(String pesel);
}
