package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "municipio")
public class Municipio implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_municipio")
    private Long id;
    @Column (name = "nombre_municipio", length = 100,nullable = false)
    private String nombre_municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_estado", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Estado estado;

    @OneToMany(mappedBy = "municipio",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direccion> direccion;

    @OneToMany(mappedBy = "municipio",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Colonia> colonia;

    public Municipio() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
