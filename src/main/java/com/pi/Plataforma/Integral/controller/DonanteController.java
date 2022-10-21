package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donante")
@CrossOrigin(origins = "*")
public class DonanteController {

    private final IDonanteService donanteService;

    public DonanteController(IDonanteService donanteService) {
        this.donanteService = donanteService;
    }


    @GetMapping("/getEstado")
    public ResponseEntity<?> getEstado(){
        List<Estado> response =  donanteService.getEstado();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getUssurioooo")
    public ResponseEntity<?> getUssurioooo(){
        List<Ussurioooo> response =  donanteService.getUssurioooo();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Donante donante){
        donanteService.save(donante);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @GetMapping("/getById/{id_donante}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_donante") Long id_donante){
        Donante response =  donanteService.getById(id_donante);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
