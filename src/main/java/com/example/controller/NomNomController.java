package com.example.controller;


import com.example.model.NomNom;
import com.example.service.NomNomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/")
public class NomNomController {

    @Autowired
    private NomNomService service;

    @GetMapping("/")
    public ResponseEntity<List<NomNom>> getAllNomNom()
    {
        try {
            List<NomNom> list = service.getAllNomNom();
            if(list.isEmpty())
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(list);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{nomId}")
    public ResponseEntity<NomNom> getNomNom(@PathVariable int nomId)
    {
        try {
            NomNom nomnom=service.getNomNom(nomId);
            if(nomnom==null)
                return ResponseEntity.noContent().build();
            return ResponseEntity.ok(nomnom);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<NomNom> createNomNom(@Valid @RequestBody NomNom nomnom, Principal principal)
    {
        try {
            nomnom.setUserEmail(principal.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNomNom(nomnom));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteNomNom(@PathVariable int id, Principal principal)
    {
        try {
            String email=principal.getName();
            System.out.println(email);
            String result=service.deleteNomNom(id,email);
            return ResponseEntity.ok(result);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<NomNom> editNomNom(@PathVariable int id, @RequestBody NomNom nomnom)
    {
        System.out.println("Controllerupdated called");
        try{
            NomNom nomnom1=service.updateNomNom(id,nomnom);
            if(nomnom1==null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(nomnom1);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<NomNom>> searchNomNom(@RequestParam String keyword)
    {
        System.out.println("Controllersearch called");
        try {
            List<NomNom> list=service.searchNomNom(keyword);

            if(list.isEmpty())
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(list);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }
}
