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

    private final IIntructorService intructorService;

    public InstructorController(IIntructorService intructorService) {
        this.intructorService = intructorService;
    }

    @GetMapping("/getEstado")
    public ResponseEntity<?> getEstado(){
        List<Estado> response =  intructorService.getEstado();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getUssurioooo")
    public ResponseEntity<?> getUssurioooo(){
        List<Ussurioooo> response =  intructorService.getUssurioooo();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Instructor instructor){
        intructorService.save(instructor);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @GetMapping("/getById/{id_instructor}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_instructor") Long id_instructor){
        Instructor response =  intructorService.getById(id_instructor);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void registrar(Instructor instructor ) {
        IIntructorService dao= new InstructorService();
        dao.registrar(instructor);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Instructor instructor) {
        IIntructorService dao= new InstructorService();
        dao.actualizar(instructor);
    }

    //llama al service para eliminar un instructor
    public void eliminar(Instructor instructor) {
        IIntructorService dao= new  InstructorService();
        dao.eliminar(instructor);
    }

    //llama al servie para obtener todos los usuarios
    public void verInstructor(){
        List<Instructor> instructor = new ArrayList<Instructor>();
        IIntructorService dao= new InstructorService();
        instructor=dao.obtener();
    }
}
