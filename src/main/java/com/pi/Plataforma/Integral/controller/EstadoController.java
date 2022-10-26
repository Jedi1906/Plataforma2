package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEstadoService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.EstadoServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/estado")
@CrossOrigin(origins = "*")
public class EstadoController {
    private final IEstadoService estadoService;

    public EstadoController(IEstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/getById/{id_estado}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_estado") Long id_estado) {
        Estado estado = estadoService.getById(id_estado);
        return new ResponseEntity<>(estado, HttpStatus.OK);
    }

    @GetMapping("/getEstado")
    public ResponseEntity<?> getEstado() {
        List<Estado> response = estadoService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void registrar(Estado estado ) {
        IEstadoService dao= new EstadoServiceImpl();
        dao.registrar(estado);
    }

    //llama al service para actualizar un estado
    public void actualizar(Estado estado) {
        IEstadoService dao= new EstadoServiceImpl();
        dao.actualizar(estado);
    }

    //llama al service para eliminar un estado
    public void eliminar(Estado estado) {
        IEstadoService dao= new  EstadoServiceImpl();
        dao.eliminar(estado);
    }

    //llama al servie para obtener todos los estados
    public void verEstado(){
        List<Estado> estado = new ArrayList<Estado>();
        IEstadoService dao= new EstadoServiceImpl();
        estado=dao.obtener();
    }


}
