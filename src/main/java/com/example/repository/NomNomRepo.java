package com.example.repository;

import com.example.model.NomNom;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomNomRepo extends JpaRepository<NomNom, Integer> {




    List<NomNom> findAllByNomNameContainingIgnoreCaseOrNomDescriptionContainingIgnoreCase(String nomName, String nomDescription);
}
