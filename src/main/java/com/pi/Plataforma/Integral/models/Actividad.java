package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "cupo",  length = 100, nullable = false)
    private String cupo;
    @Column(name = "horario", nullable = false)
    private String horario;


    @OneToMany(mappedBy = "actividad",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asistencia> asistencia;

    public Actividad() {
    }

    public Actividad(Long id, String nombre, String cupo, String horario) {
        this.id = id;
        this.nombre = nombre;
        this.cupo = cupo;
        this.horario = horario;
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

    public String getCupo() {
        return cupo;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }


    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Actividad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cupo='" + cupo + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
