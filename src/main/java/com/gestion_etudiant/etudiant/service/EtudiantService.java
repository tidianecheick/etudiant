package com.gestion_etudiant.etudiant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestion_etudiant.etudiant.entity.Etudiant;
import com.gestion_etudiant.etudiant.repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;




@Slf4j
@Service
public class EtudiantService {
   private final EtudiantRepository repository;

   public EtudiantService(EtudiantRepository repository){
    this.repository = repository;
   }

 public Etudiant EnregistrerEtudiant(Etudiant etudiant){
    if(etudiant == null){
        System.out.println("l'objet ne doit pas être null");
    }
    repository.save(etudiant);

    return etudiant;
 }

 public List<Etudiant> RecupererEtudiant(){
    List<Etudiant> list = repository.findAll();
    if(list.isEmpty()){
        System.out.println("aucun etudiant trouver");
    }

    return list;
 }
 public Etudiant modifierEtudiant(Long id, Etudiant e) {
   if (id == null) {
       System.out.println("ID non trouvé");
       return null;
   }

   Optional<Etudiant> etudiantExistant = repository.findById(id);
   if (etudiantExistant.isPresent()) {
    //    Etudiant e = etudiantExistant.get();
       // Mettre à jour les champs nécessaires
       e.setNom(e.getNom());
       e.setPrenom(e.getPrenom());
       e.setEmail(e.getEmail());
       e.setMatricule(e.getMatricule());
       // ... autres champs à mettre à jour

       return repository.save(e);
   } else {
       System.out.println("Étudiant avec ID " + id + " non trouvé");
       return null;
   }
}
public boolean supprimerEtudiant(Long id) {
   if (id == null) {
       System.out.println("ID null");
       return false;
   }

   Optional<Etudiant> etudiantExistant = repository.findById(id);
   if (etudiantExistant.isPresent()) {
       repository.deleteById(id);
       return true;
   } else {
       System.out.println("Étudiant avec ID " + id + " non trouvé");
       return false;
   }
}
  
    
} 
    
    


  
