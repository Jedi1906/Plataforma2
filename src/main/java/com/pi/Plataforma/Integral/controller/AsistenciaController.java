package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    private IAsistenciaService asistenciaService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Asistencia asistencia){
        asistenciaService.save(asistencia);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getAsistencia")
    public ResponseEntity<?> TraerAsistencia(){
        List<Asistencia> asistencias = asistenciaService.getAll();
        return new ResponseEntity<>(asistencias,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        asistenciaService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }




}


