package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IArchivoService {
    List<Archivo> getAll();

    public boolean registrar(Archivo archivo);
    public List<Archivo> obtener();
    public boolean actualizar(Archivo archivo);
    public boolean eliminar(Archivo archivo);

}
