package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "archivo_carga")
public class Archivo implements Serializable{

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column (name = "id_carga")
        private Long id;
        @Column(name = "nombre_archivo", length = 100, nullable = false)
        private String nombre_archivo;
        @Column(name = "ruta", length = 100, nullable = false)
        private String ruta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_usuario", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Ussurioooo ussurioooo;

    public Archivo() {
    }

    public Archivo(Long id, String nombre_archivo, String ruta, Ussurioooo ussurioooo) {
        this.id = id;
        this.nombre_archivo = nombre_archivo;
        this.ruta = ruta;
        this.ussurioooo = ussurioooo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Ussurioooo getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Ussurioooo ussurioooo) {
        this.ussurioooo = ussurioooo;
    }


    @Override
    public String toString() {
        return "Archivo{" +
                "id=" + id +
                ", nombre_archivo='" + nombre_archivo + '\'' +
                ", ruta='" + ruta + '\'' +
                ", ussurioooo=" + ussurioooo +
                '}';
    }
}
