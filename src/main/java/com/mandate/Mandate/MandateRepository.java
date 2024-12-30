package com.mandate.Mandate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MandateRepository extends JpaRepository<Mandate, Long> {
    
    @Query("select m from Mandate m where m.id = ?1")
    Optional<Mandate> findMandateById(String Id);

}
