package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonacionService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DonacionServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/donacion")
@CrossOrigin(origins = "*")
public class DonacionController {
    @Autowired
    private IDonacionService donacionService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Donacion donacion){
        donacionService.save(donacion);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getDonacion")
    public ResponseEntity<?> TraerDonacion(){
        List<Donacion> donacions = donacionService.getAll();
        return new ResponseEntity<>(donacions,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        donacionService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
