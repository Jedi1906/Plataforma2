package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Municipio;
import com.pi.Plataforma.Integral.service.IMunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/municipio")
@CrossOrigin(origins = "*")
public class MunicipioController {
    private final IMunicipioService municipioService;

    public MunicipioController(IMunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("/getById/{id_municipio}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_municipio") Long id_municipio) {
        Municipio municipio = municipioService.getById(id_municipio);
        return new ResponseEntity<>(municipio, HttpStatus.OK);
    }

    @GetMapping("/getMunicipio")
    public ResponseEntity<?> getMunicipio() {
        List<Municipio> response = municipioService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}