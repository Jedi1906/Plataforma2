package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.*;
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
@RequestMapping("/colonia")
@CrossOrigin(origins = "*")
public class ColoniaController {
    @Autowired
    private IColoniaService coloniaService;

    public ColoniaController(IColoniaService coloniaService){this.coloniaService=coloniaService;}

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Colonia colonia){
        coloniaService.save(colonia);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getColonia")
    public ResponseEntity<?> TraerColonia(){
        List<Colonia> colonias = coloniaService.getAll();
        return new ResponseEntity<>(colonias,HttpStatus.OK);
    }

    @PostMapping("/getMunicipio/{municipio}")
    public ResponseEntity<?> getMunicipio(@PathVariable(name = "municipio") Long id_municipio){
        List<Colonia> response = coloniaService.getMunicipio(id_municipio);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getColonias")
    public ResponseEntity<?> TraerColoniass(){
        List<Colonia>  colonias= coloniaService.get();
        return new ResponseEntity<>(colonias,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        coloniaService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
