package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ussurioooo")
@CrossOrigin(origins = "*")
public class UssuriooooController {
    @Autowired
    private IUssuriooooService ussuriooooService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo( @RequestBody Ussurioooo ussurioooo){
        ussuriooooService.save(ussurioooo);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @GetMapping("/getUssurioooos")
    public ResponseEntity<?> TraerUsuarios(){
        List<Ussurioooo> ussurioooos = ussuriooooService.get();
        return new ResponseEntity<>(ussurioooos,HttpStatus.OK);
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


