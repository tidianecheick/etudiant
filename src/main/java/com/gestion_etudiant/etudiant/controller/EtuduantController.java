package com.gestion_etudiant.etudiant.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_etudiant.etudiant.entity.Etudiant;
import com.gestion_etudiant.etudiant.service.EtudiantService;

@RestController
public class EtuduantController {

    private final EtudiantService service;

    public EtuduantController(EtudiantService service){
        this.service = service;
    }
    @GetMapping("/etudiant")
    public List<Etudiant> getListEtudiant(){
        return service.RecupererEtudiant();
    }

    @PostMapping("/etudiant")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant){
        return service.EnregistrerEtudiant(etudiant);
    }
   @PutMapping("/etudiant/{id}")
public Etudiant modifierEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
    return service.modifierEtudiant(id, etudiant);
}
    @DeleteMapping("/etudiant/{id}")
public String supprimerEtudiant(@PathVariable Long id) {
    boolean deleted = service.supprimerEtudiant(id);
    if (deleted) {
        return "Étudiant supprimé avec succès.";
    } else {
        return "Échec de la suppression : étudiant non trouvé.";
    }
}

      
}
