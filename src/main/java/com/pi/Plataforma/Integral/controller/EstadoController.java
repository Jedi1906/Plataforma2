package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.service.IEstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
