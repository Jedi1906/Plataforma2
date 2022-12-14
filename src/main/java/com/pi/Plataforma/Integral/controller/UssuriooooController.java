package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UssuriooooController {

    @Autowired
    private final IUssuriooooService ussuriooooService;

    public UssuriooooController(IUssuriooooService ussuriooooService) {
        this.ussuriooooService = ussuriooooService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo( @RequestBody Ussurioooo ussurioooo){
        ussuriooooService.save(ussurioooo);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Object getUser(@PathVariable long id){
        return ussuriooooService.findById(id);
    }

    @PostMapping
    public void actualizarUsuario(@RequestBody Ussurioooo ussurioooo){
        ussuriooooService.update(ussurioooo);

    }

    /*@PostMapping("update/{id}")
    public Ussurioooo update(@RequestBody Ussurioooo ussurioooo, @PathVariable("id") long id) {
        ussurioooo.setId(id);
        return ussuriooooService.update(ussurioooo);
    }*/



    /*
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo( @RequestBody Ussurioooo ussurioooo){
        ussuriooooService.save(ussurioooo);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

     */



    @GetMapping("/getUser")
    public ResponseEntity<?> TraerUsuarios(){
        List<Ussurioooo> ussuriooos = ussuriooooService.get();
        return new ResponseEntity<>(ussuriooos,HttpStatus.OK);
    }

    @GetMapping("/getUssurioooo")
    public ResponseEntity<?> TraerAtividad(){
        List<Ussurioooo> ussurioooos = ussuriooooService.getAll();
        return new ResponseEntity<>(ussurioooos,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        ussuriooooService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }





}


