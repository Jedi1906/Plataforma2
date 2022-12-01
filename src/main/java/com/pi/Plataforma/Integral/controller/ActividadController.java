package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.service.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
@CrossOrigin(origins = "*")
public class ActividadController {
    @Autowired
    private IActividadService actividadService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Actividad actividad){
        actividadService.save(actividad);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    @GetMapping("/getActividades")
    public ResponseEntity<?> TraerActividades(){
        List<Actividad> actividads = actividadService.get();
        return new ResponseEntity<>(actividads, HttpStatus.OK);
    }

    @GetMapping("/getActividad")
    public ResponseEntity<?> TraerAtividad(){
        List<Actividad> actividads = actividadService.get();
        return new ResponseEntity<>(actividads,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        actividadService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
