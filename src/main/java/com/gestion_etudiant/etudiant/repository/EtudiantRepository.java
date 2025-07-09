package com.gestion_etudiant.etudiant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion_etudiant.etudiant.entity.Etudiant;


@Repository 
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    
}
