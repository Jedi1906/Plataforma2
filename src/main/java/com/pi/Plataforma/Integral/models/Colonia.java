package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "colonia")
public class Colonia implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_colonia")
    private Long id;
    @Column (name = "nombre_colonia",length = 100, nullable = false)
    private String nombre_colonia;
    @Column (name = "cp", length = 100, nullable = false)
    private String cp;
    @Column (name = "ciudad", length = 100, nullable = false)
    private String ciudad;
    @Column (name = "asentamiento", length = 100, nullable = false)
    private String asentamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_municipio", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Municipio municipio;

    @OneToMany(mappedBy = "colonia",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direccion> direccion;

    public Colonia() {
    }

    public Colonia(Long id, String nombre_colonia, String cp, String ciudad, String asentamiento, Municipio municipio) {
        this.id = id;
        this.nombre_colonia = nombre_colonia;
        this.cp = cp;
        this.ciudad = ciudad;
        this.asentamiento = asentamiento;
        this.municipio = municipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_colonia() {
        return nombre_colonia;
    }

    public void setNombre_colonia(String nombre_colonia) {
        this.nombre_colonia = nombre_colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAsentamiento() {
        return asentamiento;
    }

    public void setAsentamiento(String asentamiento) {
        this.asentamiento = asentamiento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }


    public List<Direccion> getDireccion() {
        return direccion;
    }

    public void setDireccion(List<Direccion> direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "id=" + id +
                ", nombre_colonia='" + nombre_colonia + '\'' +
                ", cp='" + cp + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", asentamiento='" + asentamiento + '\'' +
                ", municipio=" + municipio +
                '}';
    }
}
