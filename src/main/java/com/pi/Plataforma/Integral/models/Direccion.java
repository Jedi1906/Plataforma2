package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direccion")
public class Direccion implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "name", length = 100, nullable = false)
    private String Calle;
    @Column(name = "numero_ext", length = 100, nullable = false)
    private String numero_ext;
    @Column(name = "numero_int", length = 100, nullable = false)
    private String numero_int;
    @Column(name = "cp", length = 100, nullable = false)
    private String cp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_colonia", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Colonia colonia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_municipio", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_estado", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Estado estado;

    public Direccion() {
    }


    public Direccion(Long id, String nombre, String calle, String numero_ext, String numero_int, String cp, Colonia colonia, Municipio municipio, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.Calle = calle;
        this.numero_ext = numero_ext;
        this.numero_int = numero_int;
        this.cp = cp;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public String getNumero_ext() {
        return numero_ext;
    }

    public void setNumero_ext(String numero_ext) {
        this.numero_ext = numero_ext;
    }

    public String getNumero_int() {
        return numero_int;
    }

    public void setNumero_int(String numero_int) {
        this.numero_int = numero_int;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Calle='" + Calle + '\'' +
                ", numero_ext='" + numero_ext + '\'' +
                ", numero_int='" + numero_int + '\'' +
                ", cp='" + cp + '\'' +
                ", colonia=" + colonia +
                ", municipio=" + municipio +
                ", estado=" + estado +
                '}';
    }
}
