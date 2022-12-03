package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_instructor")
    private Long id;
    @Column (name = "correoSec",length = 100, nullable = false)
    private String correoSec;
    @Column (name = "telefonoPart", length = 100, nullable = false)
    private String telefonoPart;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_estado")
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Estado estado;

    @Column (name = "fechaNac", length = 100, nullable = false)
    private Date fechaNac;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn (name = "id_usuario")
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Ussurioooo ussurioooo;

    @OneToMany(mappedBy = "instructor",
             cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Asistencia> asistencia;

    @Column (name = "area", length = 100, nullable = false)
    private String area;
    @Column (name = "especialidad", length = 100, nullable = false)
    private String especialidad;

    public Instructor() {
    }

    public Instructor(Long id, String correoSec, String telefonoPart, Date fechaNac, String area, String especialidad) {
        this.id = id;
        this.correoSec = correoSec;
        this.telefonoPart = telefonoPart;
        this.fechaNac = fechaNac;
        this.area = area;
        this.especialidad = especialidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCorreoSec() {
        return correoSec;
    }

    public void setCorreoSec(String correoSec) {
        this.correoSec = correoSec;
    }

    public String getTelefonoPart() {
        return telefonoPart;
    }

    public void setTelefonoPart(String telefonoPart) {
        this.telefonoPart = telefonoPart;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Ussurioooo getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Ussurioooo ussurioooo) {
        this.ussurioooo = ussurioooo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

}
