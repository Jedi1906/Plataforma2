package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Long id;
    @Column(name = "nombre_estado", length = 100, nullable = false)
    private String nombre_estado;

    @OneToMany(mappedBy = "estado",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Instructor> instructor;

    @OneToMany(mappedBy = "estado",
            cascade = CascadeType.ALL )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Donante> donante;

    @OneToMany(mappedBy = "estado",
            cascade = CascadeType.ALL )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Municipio> municipio;

    @OneToMany(mappedBy = "estado",
            cascade = CascadeType.ALL)
    private List<Direccion> direccion;




    public Estado() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_estado() {
        return nombre_estado;
    }

    public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public List<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(List<Instructor> instructor) {
        this.instructor = instructor;
    }

    public List<Donante> getDonante() {
        return donante;
    }

    public void setDonante(List<Donante> donante) {
        this.donante = donante;
    }

    public List<Municipio> getMunicipio() {
        return municipio;
    }

    public void setMunicipio(List<Municipio> municipio) {
        this.municipio = municipio;
    }

    public List<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

}
