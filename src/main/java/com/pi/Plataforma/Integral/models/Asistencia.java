package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asistencia")
public class Asistencia implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Long id;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "ubicacion",nullable = false)
    private String ubicacion;
    @Column(name = "validacion", length = 250)
    private String validacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_actividad", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Actividad actividad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_usuario", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Ussurioooo ussurioooo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_instructor", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Instructor instructor;

    public Asistencia() {
    }

    public Asistencia(Long id, String fecha, String ubicacion, String validacion, Actividad actividad, Ussurioooo ussurioooo, Instructor instructor) {
        this.id = id;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.validacion = validacion;
        this.actividad = actividad;
        this.ussurioooo = ussurioooo;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Ussurioooo getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Ussurioooo ussurioooo) {
        this.ussurioooo = ussurioooo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        return "Asistencia{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", validacion='" + validacion + '\'' +
                ", actividad=" + actividad +
                ", ussurioooo=" + ussurioooo +
                ", instructor=" + instructor +
                '}';
    }
}
