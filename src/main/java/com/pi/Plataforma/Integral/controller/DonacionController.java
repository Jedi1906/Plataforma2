package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.*;
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

    public DonacionController(IDonacionService donacionService){this.donacionService=donacionService;}

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Donacion donacion){
        donacionService.save(donacion);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/getUssurioooo/{ussurioooo}")
    public ResponseEntity<?> getUssurioooo(@PathVariable(name = "ussurioooo") Long id_usuario){
        List<Donacion> response = donacionService.getUssurioooo(id_usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDonaciones")
    public ResponseEntity<?> TraerDonaciones(){
        List<Donacion>  donacions= donacionService.get();
        return new ResponseEntity<>(donacions,HttpStatus.OK);
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
