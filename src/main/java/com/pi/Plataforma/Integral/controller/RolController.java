package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.service.IRolService;
import com.pi.Plataforma.Integral.service.implement.RolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private  IRolService rolService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Rol rol){
        rolService.save(rol);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getRoles")
    public ResponseEntity<?> TraerRoles(){
        List<Rol> rols = rolService.get();
        return new ResponseEntity<>(rols,HttpStatus.OK);
    }

    @GetMapping("/getRol")
    public ResponseEntity<?> TraerRol(){
        List<Rol> rols = rolService.get();
        return new ResponseEntity<>(rols,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        rolService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
