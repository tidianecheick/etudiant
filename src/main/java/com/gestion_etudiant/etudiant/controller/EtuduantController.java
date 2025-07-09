package com.gestion_etudiant.etudiant.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gestion_etudiant.etudiant.entity.Etudiant;
import com.gestion_etudiant.etudiant.service.EtudiantService;

@CrossOrigin("*")
@RestController
public class EtuduantController {

    private final EtudiantService service;

    public EtuduantController(EtudiantService service){
        this.service = service;
    }
    @GetMapping("/api/etudiant")
    public List<Etudiant> getListEtudiant(){
        return service.RecupererEtudiant();
    }

    @PostMapping("/api/etudiant")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant){
        return service.EnregistrerEtudiant(etudiant);
    }
   @PutMapping("/api/etudiant/{id}")
public Etudiant modifierEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
    return service.modifierEtudiant(id, etudiant);
}
//     @DeleteMapping("/api/etudiant/{id}")
// public String supprimerEtudiant(@PathVariable Long id) {
//     boolean deleted = service.supprimerEtudiant(id);
//     if (deleted) {
//         return "Étudiant supprimé avec succès.";
//     } else {
//         return "Échec de la suppression : étudiant non trouvé.";
//     }
// }

@DeleteMapping("/api/etudiant/{id}")
public ResponseEntity<Map<String, String>> supprimerEtudiant(@PathVariable Long id) {
    boolean deleted = service.supprimerEtudiant(id);
    Map<String, String> response = new HashMap<>();

    if (deleted) {
        response.put("message", "Étudiant supprimé avec succès.");
        return ResponseEntity.ok(response); // HTTP 200 + JSON
    } else {
        response.put("message", "Échec de la suppression : étudiant non trouvé.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response); // HTTP 404 + JSON
    }
}


      
}