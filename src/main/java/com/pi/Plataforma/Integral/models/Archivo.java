package com.pi.Plataforma.Integral.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "archivo")
public class Archivo implements Serializable{

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        @Column (name = "id_carga")
        private Long id;
        @Column(name = "nombre_archivo", length = 100, nullable = false)
        private String nombre_archivo;
        @Column(name = "ruta", length = 100, nullable = false)
        private String ruta;

    @ManyToOne()
    @JoinColumn (name = "id_usuario")
    private Ussurioooo ussurioooo;

    public Archivo() {
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
}
