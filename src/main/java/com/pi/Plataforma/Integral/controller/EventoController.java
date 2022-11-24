package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IEventoService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.EventoServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/evento")
@CrossOrigin(origins = "*")
public class EventoController {
    @Autowired
    private IEventoService eventoService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Evento evento){
        eventoService.save(evento);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getEvento")
    public ResponseEntity<?> TraerEvento(){
        List<Evento> eventos = eventoService.getAll();
        return new ResponseEntity<>(eventos,HttpStatus.OK);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        eventoService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }




}
