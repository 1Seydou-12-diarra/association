package com.Association.association.repository;

import com.Association.association.entity.Cotisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CotisationRepository  extends JpaRepository<Cotisation,Long> {
    @Override
    Optional<Cotisation> findById(Long aLong);
}
