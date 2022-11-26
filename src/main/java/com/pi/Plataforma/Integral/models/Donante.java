package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "donante")
public class Donante implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donante")
    private Long id;
    @Column(name = "tipo_donacion", nullable = false)
    private String tipo_donacion;
    @Column(name = "validacion", nullable = false)
    private String validacion;
    @Column(name = "telefono_contacto")
    private Number telefono_contacto;
    @Column(name = "proviene_de", nullable = false)
    private String proviene_de;
    @Column(name = "observaciones", nullable = false)
    private String observaciones;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Ussurioooo ussurioooo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_estado")
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Estado estado;

    public Donante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_donacion() {
        return tipo_donacion;
    }

    public void setTipo_donacion(String tipo_donacion) {
        this.tipo_donacion = tipo_donacion;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public Number getTelefono_contacto() {
        return telefono_contacto;
    }

    public void setTelefono_contacto(Number telefono_contacto) {
        this.telefono_contacto = telefono_contacto;
    }

    public String getProviene_de() {
        return proviene_de;
    }

    public void setProviene_de(String proviene_de) {
        this.proviene_de = proviene_de;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Ussurioooo getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Ussurioooo ussurioooo) {
        this.ussurioooo = ussurioooo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
