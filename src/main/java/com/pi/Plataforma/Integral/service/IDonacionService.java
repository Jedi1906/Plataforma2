package com.pi.Plataforma.Integral.service;

import com.itextpdf.text.DocumentException;
import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IDonacionService {
    Donacion save(Donacion donacion);
    Donacion update(Donacion donacion);
    public void delete(Long id);


    List<Donacion> get();
    List<Donacion> getAll();


    Donacion getById(Long id);
    Optional<Donacion> findById(Long id);


    List<Ussurioooo> getUssurioooo();



    String generatePdf(Long id) throws IOException, DocumentException;

}