package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Rol;
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

    private  IEstadoService estadoService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Estado estado){
        estadoService.save(estado);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getEstado")
    public ResponseEntity<?> TraerEstado(){
        List<Estado> estados = estadoService.getAll();
        return new ResponseEntity<>(estados,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        estadoService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
