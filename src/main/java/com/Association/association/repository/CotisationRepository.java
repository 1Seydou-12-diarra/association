package com.Association.association.repository;

import com.Association.association.entity.Cotisation;

import com.Association.association.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CotisationRepository extends JpaRepository<Cotisation,Long> {
    /**
     * @param datePaiement
     * @return
     */
    Optional<Cotisation> findByDatePaiement(String datePaiement);

}
