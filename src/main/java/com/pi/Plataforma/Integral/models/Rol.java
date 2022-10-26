package com.pi.Plataforma.Integral.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;
    @Column(name = "rol_nombre", nullable = false)
    private String rol_nombre;



    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "ussu_rol",
            joinColumns = {@JoinColumn(name = "id_rol")},
            inverseJoinColumns = {@JoinColumn(name = "id_usuario")}
    )
    private Set<Ussurioooo> ussurioooo;



    public Rol() {
    }

    public Rol(Long id, String rol_nombre, Set<Ussurioooo> ussurioooo) {
        this.id = id;
        this.rol_nombre = rol_nombre;
        this.ussurioooo = ussurioooo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol_nombre() {
        return rol_nombre;
    }

    public void setRol_nombre(String rol_nombre) {
        this.rol_nombre = rol_nombre;
    }

    public Set<Ussurioooo> getUssurioooo() {
        return ussurioooo;
    }

    public void setUssurioooo(Set<Ussurioooo> ussurioooo) {
        this.ussurioooo = ussurioooo;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", rol_nombre='" + rol_nombre + '\'' +
                ", ussurioooo=" + ussurioooo +
                '}';
    }
}
