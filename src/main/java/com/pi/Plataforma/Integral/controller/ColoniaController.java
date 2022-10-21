package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.service.IColoniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/colonia")
@CrossOrigin(origins = "*")
public class ColoniaController {
    @Autowired
    private IColoniaService coloniaService;
    @GetMapping("/getById/{id_colonia}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_colonia") Long id_colonia) {
        Colonia colonia = coloniaService.getById(id_colonia);
        return new ResponseEntity<>(colonia, HttpStatus.OK);
    }

    @GetMapping("/getColonia")
    public ResponseEntity<?> getColonia() {
        List<Colonia> response = coloniaService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
