package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IColoniaService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.ColoniaServicelmpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/colonia")
@CrossOrigin(origins = "*")
public class ColoniaController {
    @Autowired
    private IColoniaService coloniaService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Colonia colonia){
        coloniaService.save(colonia);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        coloniaService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
