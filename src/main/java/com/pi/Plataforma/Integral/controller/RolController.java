package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Rol;
import com.pi.Plataforma.Integral.service.IRolService;
import com.pi.Plataforma.Integral.service.implement.RolServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class RolController {

    private  IRolService rolService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Rol rol){
        rolService.save(rol);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
