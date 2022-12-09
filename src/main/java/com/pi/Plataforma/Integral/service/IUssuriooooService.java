package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;
import java.util.Optional;

public interface IUssuriooooService {

    Ussurioooo save(Ussurioooo ussurioooo);

    Ussurioooo update(Ussurioooo ussurioooo);

    public void delete(Long id);


    List<Ussurioooo> get();

    List<Ussurioooo> getAll();


    Ussurioooo getById(Long idussurioooo);


    Ussurioooo findByEmail(String correo);

    Optional<Ussurioooo> findById(Long id);

}
