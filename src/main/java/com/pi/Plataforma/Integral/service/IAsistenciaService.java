package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IAsistenciaService {

    Asistencia save(Asistencia asistencia);

    List<Asistencia> getAll();

    Asistencia getById(Long id);

    List<Ussurioooo> getUssurioooo();

    List<Instructor> getInstructor();

    List<Actividad> getActividad();

    public boolean registrar(Asistencia asistencia);
    public List<Asistencia> obtener();
    public boolean actualizar(Asistencia asistencia);
    public boolean eliminar(Asistencia asistencia);
}

