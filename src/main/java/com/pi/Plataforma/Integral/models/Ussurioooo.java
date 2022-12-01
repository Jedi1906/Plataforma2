package com.pi.Plataforma.Integral.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ussurioooo")

public class Ussurioooo implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;
    @Column(name ="fecha_creaci", nullable = false)
    private Date fecha_creaci;
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;
    @Column(name ="contraseña",nullable = false)
    private String contraseña;
    @Column(name ="staus", nullable = false)
    private Integer status;
    @Column(name ="telefono")
    private String telefono;
    @Column(name ="fecha_actual", nullable = false)
    private Date fecha_actual;
    @Column(name ="genero")
    private String genero;

    @ManyToMany(mappedBy = "ussurioooo")
    private Set<Rol> rol;

    @OneToMany(mappedBy = "ussurioooo",
    cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "ussurioooo",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<Archivo> archivos;



    @OneToMany(mappedBy = "ussurioooo",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> evento;

    @OneToMany(mappedBy = "ussurioooo",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Donacion> donacion;

    @OneToOne(mappedBy = "ussurioooo",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Donante donante;

    @OneToOne(mappedBy = "ussurioooo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Instructor instructor;



    public Ussurioooo() {
    }



    public Ussurioooo(Long id, String nombre, String apellido, Date fecha_creaci, String correo, String contraseña, Integer status, String telefono, Date fecha_actual, String genero, Set<Rol> rol, List<Asistencia> asistencia, List<Archivo> archivos, List<Evento> evento, List<Donacion> donacion, Donante donante, Instructor instructor) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_creaci = fecha_creaci;
        this.correo = correo;
        this.contraseña = contraseña;
        this.status = status;
        this.telefono = telefono;
        this.fecha_actual = fecha_actual;
        this.genero = genero;
        this.rol = rol;
        this.asistencia = asistencia;
        this.archivos = archivos;
        this.evento = evento;
        this.donacion = donacion;
        this.donante = donante;
        this.instructor = instructor;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_creaci() {
        return fecha_creaci;
    }

    public void setFecha_creaci(Date fecha_creaci) {
        this.fecha_creaci = fecha_creaci;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Set<Rol> getRol() {
        return rol;
    }

    public void setRol(Set<Rol> rol) {
        this.rol = rol;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

    public List<Archivo> getArchivos() {
        return archivos;
    }

    public void setArchivos(List<Archivo> archivos) {
        this.archivos = archivos;
    }

    public List<Evento> getEvento() {
        return evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }

    public List<Donacion> getDonacion() {
        return donacion;
    }

    public void setDonacion(List<Donacion> donacion) {
        this.donacion = donacion;
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Ussurioooo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha_creaci=" + fecha_creaci +
                ", correo='" + correo + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", status=" + status +
                ", telefono='" + telefono + '\'' +
                ", fecha_actual=" + fecha_actual +
                ", genero='" + genero + '\'' +
                ", rol=" + rol +
                ", asistencia=" + asistencia +
                ", archivos=" + archivos +
                ", evento=" + evento +
                ", donacion=" + donacion +
                ", donante=" + donante +
                ", instructor=" + instructor +
                '}';
    }
}
