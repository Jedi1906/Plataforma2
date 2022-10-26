package com.pi.Plataforma.Integral.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "donacion")
public class Donacion implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_donacion")
    private Long id;
    @Column (name = "tipo_donacion", length = 100, nullable = false)
    private String tipo_donacion;
    @Column (name = "fecha_registro",  nullable = false)
    private Date fecha_registro;
    @Column (name = "stock", length = 100, nullable = false)
    private String stock;
    @Column (name = "fecha_act",  nullable = false)
    private Date fecha_act;
    @Column (name = "validado", nullable = false)
    private boolean validado;
    @Column ( name = "status", nullable = false)
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", updatable = false)
    @JsonIgnoreProperties({"hibernataLazyIntializer", "handler"})
    private Ussurioooo ussurioooo;

    public Donacion() {
    }

    public Donacion(Long id, String tipo_donacion, Date fecha_registro, String stock, Date fecha_act, boolean validado, boolean status, Ussurioooo ussurioooo) {
        this.id = id;
        this.tipo_donacion = tipo_donacion;
        this.fecha_registro = fecha_registro;
        this.stock = stock;
        this.fecha_act = fecha_act;
        this.validado = validado;
        this.status = status;
        this.ussurioooo = ussurioooo;
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

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getFecha_act() {
        return fecha_act;
    }

    public void setFecha_act(Date fecha_act) {
        this.fecha_act = fecha_act;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Ussurioooo getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Ussurioooo ussurioooo) {
        this.ussurioooo = ussurioooo;
    }


    @Override
    public String toString() {
        return "Donacion{" +
                "id=" + id +
                ", tipo_donacion='" + tipo_donacion + '\'' +
                ", fecha_registro=" + fecha_registro +
                ", stock='" + stock + '\'' +
                ", fecha_act=" + fecha_act +
                ", validado=" + validado +
                ", status=" + status +
                ", ussurioooo=" + ussurioooo +
                '}';
    }
}
