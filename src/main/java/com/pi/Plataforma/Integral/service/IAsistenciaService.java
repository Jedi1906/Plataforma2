package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IAsistenciaService {

    Asistencia save(Asistencia asistencia);
    Asistencia update(Asistencia asistencia);
    public void delete(Long id);


    List<Asistencia> getAll();





}

