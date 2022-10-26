package com.pi.Plataforma.Integral.controller;

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
@RequestMapping(value = "/evento")
@CrossOrigin(origins = "*")
public class EventoController {
    @Autowired
    private IEventoService eventoService;





    @GetMapping("/getById/{id_evento}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_evento") Long id_evento) {
        Evento evento = eventoService.getById(id_evento);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @GetMapping("/getEvento")
    public ResponseEntity<?> getEvento() {
        List<Evento> response = eventoService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public void registrar(Evento evento ) {
        IEventoService dao= new EventoServiceImpl();
        dao.registrar(evento);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Evento evento) {
        IEventoService dao= new EventoServiceImpl();
        dao.actualizar(evento);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Evento evento) {
        IEventoService dao= new  EventoServiceImpl();
        dao.eliminar(evento);
    }

    //llama al servie para obtener todos los usuarios
    public void verEvento(){
            List<Evento> evento = new ArrayList<Evento>();
        IEventoService dao= new  EventoServiceImpl();
        evento=dao.obtener();
    }
}
