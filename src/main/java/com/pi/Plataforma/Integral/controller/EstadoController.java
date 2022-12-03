package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.service.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "*")
public class EstadoController {
    @Autowired
    private  IEstadoService estadoService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Estado estado){
        estadoService.save(estado);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getEstados")
    public ResponseEntity<?> TraerEstadoss(){
        List<Estado> estados = estadoService.get();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/getEstado")
    public ResponseEntity<?> TraerEstado(){
        List<Estado> estados = estadoService.getAll();
        return new ResponseEntity<>(estados,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        estadoService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
