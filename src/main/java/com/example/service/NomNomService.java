package com.example.service;

import com.example.model.NomNom;
import com.example.repository.NomNomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomNomService {

    @Autowired
    JWTService jwtService;
    @Autowired
    private NomNomRepo repo;

    public List<NomNom> getAllNomNom() {
        return repo.findAll();
    }

    public NomNom saveNomNom(NomNom nomnom) {
        return repo.save(nomnom);
    }

    public NomNom getNomNom(int nomId) {
        return repo.findById(nomId).orElse(null);
    }

    public String deleteNomNom(int nomid , String email) {
        NomNom nomnom=repo.findById(nomid).orElse(null);

        if(!nomnom.getUserEmail().equals(email)) {
            return "You are not allowed to delete this nomnom";
        }
        if(nomnom==null)
            return "Nothing to delete";
        repo.deleteById(nomid);
        return "Successfully deleted";
    }

    public NomNom updateNomNom(int id, NomNom nomnom) {
        System.out.println("Serviceupdate called");
        NomNom nomnom1=repo.findById(id).orElse(null);
        if(nomnom1!=null)
        {
            nomnom1.setNomDescription(nomnom.getNomDescription());
            repo.save(nomnom1);
        }
        return nomnom1;
    }


    public List<NomNom> searchNomNom(String keyword) {
        System.out.println("Servicesearch called");
        return repo.findAllByNomNameContainingIgnoreCaseOrNomDescriptionContainingIgnoreCase(keyword,keyword);
    }
}
