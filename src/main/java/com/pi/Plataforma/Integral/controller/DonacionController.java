package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonacionService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DonacionServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/donacion")
@CrossOrigin(origins = "*")
public class DonacionController {
    private final IDonacionService donacionService;

    public DonacionController(IDonacionService donacionService) {
        this.donacionService = donacionService;
    }

    @GetMapping("/getById/{id_donacion}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_donacion") Long id_donacion) {
        Donacion donacion = donacionService.getById(id_donacion);
        return new ResponseEntity<>(donacion, HttpStatus.OK);
    }



    @GetMapping("/getDonacion")
    public ResponseEntity<?> getDonacion() {
        List<Donacion> response = donacionService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public void registrar(Donacion donacion ) {
        IDonacionService dao= new DonacionServiceImpl();
        dao.registrar(donacion);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Donacion donacion) {
        IDonacionService dao= new DonacionServiceImpl();
        dao.actualizar(donacion);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Donacion donacion) {
        IDonacionService dao= new  DonacionServiceImpl();
        dao.eliminar(donacion);
    }

    //llama al servie para obtener todos los usuarios
    public void verDonacion(){
        List<Donacion> donacion = new ArrayList<Donacion>();
        IDonacionService dao= new  DonacionServiceImpl();
        donacion=dao.obtener();
    }



}
