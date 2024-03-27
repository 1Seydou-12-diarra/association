package com.Association.association.repository;

import com.Association.association.entity.Membre;
import com.Association.association.entity.TypeCotisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TypeCotisationRepository extends JpaRepository<TypeCotisation,Long> {
    Optional<TypeCotisation> findByLibelle(String libelle);

}
