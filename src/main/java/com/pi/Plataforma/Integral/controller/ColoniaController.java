package com.pi.Plataforma.Integral.controller;

import com.pi.Plataforma.Integral.models.Colonia;
import com.pi.Plataforma.Integral.models.Ussurioooo;
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
@RequestMapping(value = "/colonia")
@CrossOrigin(origins = "*")
public class ColoniaController {
    @Autowired
    private IColoniaService coloniaService;
    @GetMapping("/getById/{id_colonia}")
    public ResponseEntity<?> getById(@PathVariable(name = "id_colonia") Long id_colonia) {
        Colonia colonia = coloniaService.getById(id_colonia);
        return new ResponseEntity<>(colonia, HttpStatus.OK);
    }

    @GetMapping("/getColonia")
    public ResponseEntity<?> getColonia() {
        List<Colonia> response = coloniaService.getBrokers();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public void registrar(Colonia colonia ) {
        IColoniaService dao= new ColoniaServicelmpl();
        dao.registrar(colonia);
    }

    //llama al service para actualizar un colonia
    public void actualizar(Colonia colonia) {
        IColoniaService dao= new ColoniaServicelmpl();
        dao.actualizar(colonia);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Colonia colonia) {
        IColoniaService dao= new  ColoniaServicelmpl();
        dao.eliminar(colonia);
    }

    //llama al servie para obtener todos los usuarios
    public void verColonia(){
        List<Colonia> colonia = new ArrayList<Colonia>();
        IColoniaService dao= new ColoniaServicelmpl();
        colonia=dao.obtener();
    }

}
