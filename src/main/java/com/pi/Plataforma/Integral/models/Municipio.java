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

    public Municipio(Long id, String nombre_municipio, Estado estado) {
        this.id = id;
        this.nombre_municipio = nombre_municipio;
        this.estado = estado;
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

    public List<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

    public List<Colonia> getColonia() {
        return colonia;
    }

    public void setColonia(List<Colonia> colonia) {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nombre_municipio='" + nombre_municipio + '\'' +
                ", estado=" + estado +
                '}';
    }
}
