package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import javax.transaction.Transactional;
import java.util.List;

public interface IIntructorService {

    Instructor save(Instructor instructor);

    @Transactional
    Instructor save(Donante donante);

    List<Instructor> getAll();

    Instructor getById(Long id);

    List<Ussurioooo> getUssurioooo();

    List<Estado> getEstado();

    public boolean registrar(Instructor instructor);
    public List<Instructor> obtener();
    public boolean actualizar(Instructor instructor);
    public boolean eliminar(Instructor instructor);

}
