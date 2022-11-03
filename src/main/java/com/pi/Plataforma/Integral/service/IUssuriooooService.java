package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IUssuriooooService {

    Ussurioooo save(Ussurioooo ussurioooo);
    Ussurioooo update(Ussurioooo ussurioooo);
    public  void delete( Long id);

    List<Ussurioooo> getAll();


    Ussurioooo getById(Long idussurioooo);


    /*Métodos para brokers
    void saveBroker(Ussurioooo ussurioooo);
    List<Ussurioooo> getBrokers();
    void updateBroker(Ussurioooo ussurioooo);
    Fin métodos*/

    /*Metodos de contraseña*/

    Ussurioooo findByEmail(String correo);




}
