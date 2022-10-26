package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Donante;
import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonanteService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DonanteServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    public void registrar(Donante donante ) {
        IDonanteService dao= new DonanteServiceImpl();
        dao.registrar(donante);
    }

    //llama al service para actualizar un donante
    public void actualizar(Donante donante) {
        IDonanteService dao= new DonanteServiceImpl();
        dao.actualizar(donante);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Donante donante) {
        IDonanteService dao= new  DonanteServiceImpl();
        dao.eliminar(donante);
    }

    //llama al servie para obtener todos los donante
    public void verDonante(){
        List<Donante> donante = new ArrayList<Donante>;
        IDonanteService dao= new  DonanteServiceImpl();
        donante=dao.obtener();
    }
}
