package com.pi.Plataforma.Integral.service;

import com.pi.Plataforma.Integral.models.Ussurioooo;

import java.util.List;

public interface IUssuriooooService {
    Ussurioooo findByEmail(String mail);
    Ussurioooo getById(Long idussurioooo);
    /*Métodos para brokers*/
    void saveBroker(Ussurioooo ussurioooo);
    List<Ussurioooo> getBrokers();
    void updateBroker(Ussurioooo ussurioooo);
    /*Fin métodos*/
    void updatepassword(Ussurioooo ussurioooo);
    void sendRecoverPassword(Ussurioooo ussurioooo);


    public boolean registrar(Ussurioooo ussurioooo);
    public List<Ussurioooo> obtener();
    public boolean actualizar(Ussurioooo ussurioooo);
    public boolean eliminar(Ussurioooo ussurioooo);

}
