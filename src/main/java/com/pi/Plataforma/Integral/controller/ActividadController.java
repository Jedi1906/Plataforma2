package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.service.IActividadService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actividad")
@CrossOrigin(origins = "*")
public class ActividadController {

    private final IActividadService actividadService;

    public ActividadController(IActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Actividad> response = actividadService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
