package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Archivo;
import com.pi.Plataforma.Integral.models.Ussurioooo;


import java.util.List;

public interface IArchivoService {
    Archivo save(Archivo archivo);
    Archivo update(Archivo archivo);
    public void delete(Long id);


    List<Archivo> get();
    List<Archivo> getAll();


    List<Ussurioooo> getUsuario();


    List<Ussurioooo> getUssurioooo();


}
