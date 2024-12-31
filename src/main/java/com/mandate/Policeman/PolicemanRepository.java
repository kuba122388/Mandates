package com.mandate.Policeman;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicemanRepository extends JpaRepository<Policeman, Long> {

    @Query("select d from Policeman d where d.numerSluzbowy = ?1")
    Optional<Policeman> findPolicemanByBadge(Long numerSluzbowy);

}
