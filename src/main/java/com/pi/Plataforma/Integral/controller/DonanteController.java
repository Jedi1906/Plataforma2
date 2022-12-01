package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonanteService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DonanteServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/donante")
@CrossOrigin(origins = "*")
public class DonanteController {

    @Autowired
    private  IDonanteService donanteService;

    public DonanteController(IDonanteService donanteService){this.donanteService=donanteService;}

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Donante donante){
        donanteService.save(donante);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }



    @GetMapping("/getDonante")
    public ResponseEntity<?> TraerDonante(){
        List<Donante> donantes = donanteService.getAll();
        return new ResponseEntity<>(donantes,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        donanteService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
