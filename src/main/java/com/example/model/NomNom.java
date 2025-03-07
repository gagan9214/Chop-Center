package com.example.model;

import com.example.service.JWTService;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Entity
@Table
public class NomNom {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nomId;

    @NotBlank(message = "Nom name cannot be blank")
    @Column(nullable = false, updatable = false)
    private String nomName;

    private String nomDescription;


    private String userEmail;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date dateOfCreation;

    @UpdateTimestamp
    private Date dateOfModification;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public int getNomId() {
        return nomId;
    }

    public void setNomId(int nomId) {
        this.nomId = nomId;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public String getNomName() {
        return nomName;
    }

    public void setNomName(String nomName) {
        this.nomName = nomName;
    }

    public String getNomDescription() {
        return nomDescription;
    }

    public void setNomDescription(String nomDescription) {
        this.nomDescription = nomDescription;
    }


}
