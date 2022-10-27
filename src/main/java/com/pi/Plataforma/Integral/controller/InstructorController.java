package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Estado;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IIntructorService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.InstructorService;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instructor")
@CrossOrigin(origins = "*")
public class InstructorController {

    private IIntructorService intructorService;

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Instructor instructor){
        intructorService.save(instructor);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
