package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Direccion;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDireccionService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DireccionServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/direccion")
@CrossOrigin(origins = "*")
public class DireccionController {
    private final IDireccionService direccionService;

    public DireccionController(IDireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @GetMapping("/getById/{id_direccion}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_direccion") Long id_direccion) {
        Direccion direccion = direccionService.getById(id_direccion);
        return new ResponseEntity<>(direccion, HttpStatus.OK);
    }

    @GetMapping("/getDireccion")
    public ResponseEntity<?> getDireccion() {
        List<Direccion> response = direccionService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void registrar(Direccion direccion ) {
        IDireccionService dao= new DireccionServiceImpl();
        dao.registrar(direccion);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Direccion direccion) {
        IDireccionService dao= new DireccionServiceImpl();
        dao.actualizar(direccion);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Direccion direccion) {
        IDireccionService dao= new  DireccionServiceImpl();
        dao.eliminar(direccion);
    }

    //llama al servie para obtener todos los usuarios
    public void verDireccion(){
        List<Direccion> direccion = new ArrayList<Direccion>();
        IDireccionService dao= new  DireccionServiceImpl();
        direccion=dao.obtener();
    }

}
