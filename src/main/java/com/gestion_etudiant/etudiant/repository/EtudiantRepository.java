package com.gestion_etudiant.etudiant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion_etudiant.etudiant.entity.Etudiant;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    
}
