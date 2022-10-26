package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Actividad;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.models.Instructor;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.AsistenciaServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    private final IAsistenciaService asistenciaService;

    public AsistenciaController(IAsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping("/getUssurioooo")
    public ResponseEntity<?> getUssurioooo(){
        List<Ussurioooo> response =  asistenciaService.getUssurioooo();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getInstructor")
    public ResponseEntity<?> getInstructor(){
        List<Instructor> response =  asistenciaService.getInstructor();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getActividad")
    public ResponseEntity<?> getActividad(){
        List<Actividad> response =  asistenciaService.getActividad();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> nuevo(@RequestBody Asistencia asistencia){
        asistenciaService.save(asistencia);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @GetMapping("/getById/{id_asistencia}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_asistencia") Long id_asistencia){
        Asistencia response =  asistenciaService.getById(id_asistencia);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    public void registrar(Asistencia asistencia ) {
        IAsistenciaService dao= new AsistenciaServiceImpl();
        dao.registrar(asistencia);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Asistencia asistencia) {
        IAsistenciaService dao= new AsistenciaServiceImpl();
        dao.actualizar(asistencia);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Asistencia asistencia) {
        IAsistenciaService dao= new  AsistenciaServiceImpl();
        dao.eliminar(asistencia);
    }

    //llama al servie para obtener todos los usuarios
    public void verAsistencia(){
        List<Asistencia> asistencia = new ArrayList<Asistencia>();
        IAsistenciaService dao= new  AsistenciaServiceImpl();
        asistencia=dao.obtener();
    }

}


