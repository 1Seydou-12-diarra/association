package com.Association.association.repository;

import com.Association.association.entity.Membre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembreRepository extends JpaRepository<Membre,Long> {

    Optional<Membre> findByPrenom(String prenom);

}
