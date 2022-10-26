package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "evento")
public class Evento implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_evento")
    private Long id;
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;
    @Column (name = "fecha", nullable = false)
    private Date fecha;
    @Column (name = "ubicacion", length = 100, nullable = false)
    private String ubicacion;
    @Column (name = "url", length = 100, nullable = false)
    private String url;
    @Column (name = "imagen", nullable = false)
    private String imagen;
    @Column (name = "instrucciones", length = 100, nullable = false)
    private String instrucciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "id_usuario", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Ussurioooo ussurioooo;

    public Evento() {
    }

    public Evento(Long id, String descripcion, Date fecha, String ubicacion, String url, String imagen, String instrucciones, Ussurioooo ussurioooo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.url = url;
        this.imagen = imagen;
        this.instrucciones = instrucciones;
        this.ussurioooo = ussurioooo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public Ussurioooo getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Ussurioooo ussurioooo) {
        this.ussurioooo = ussurioooo;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", ubicacion='" + ubicacion + '\'' +
                ", url='" + url + '\'' +
                ", imagen='" + imagen + '\'' +
                ", instrucciones='" + instrucciones + '\'' +
                ", ussurioooo=" + ussurioooo +
                '}';
    }
}
