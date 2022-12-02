package com.pi.Plataforma.Integral.service;

import com.itextpdf.text.DocumentException;
import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.io.IOException;
import java.util.List;

public interface IAsistenciaService {

    Asistencia save(Asistencia asistencia);
    Asistencia update(Asistencia asistencia);
    public void delete(Long id);


    List<Asistencia> get();
    List<Asistencia> getAll();

    List<Asistencia> getActividad(Long id_actividad);
    List<Asistencia> getUssurioooo(Long id_usuario);
    List<Asistencia> getInstructor(Long id_instructor);




}

