package com.pi.Plataforma.Integral.controller;


import com.pi.Plataforma.Integral.models.Archivo;

import com.pi.Plataforma.Integral.service.IArchivoService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.ArchivoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/archivo")
@CrossOrigin(origins = "*")
public class ArchivoController {

    @Autowired
    private final IArchivoService archivoService;

    public ArchivoController(IArchivoService archivoService) {
        this.archivoService = archivoService;
    }




    public void registrar(Archivo archivo ) {
        IArchivoService dao= new ArchivoServiceImpl();
        dao.registrar(archivo);
    }

    //llama al service para actualizar un ussurioooo
    public void actualizar(Archivo archivo) {
        IArchivoService dao= new ArchivoServiceImpl();
        dao.actualizar(archivo);
    }

    //llama al service para eliminar un ussurioooo
    public void eliminar(Archivo archivo) {
        IArchivoService dao= new  ArchivoServiceImpl();
        dao.eliminar(archivo);
    }

    //llama al servie para obtener todos los usuarios
    public void verArchivo(){
        List<Archivo> archivo = new ArrayList<Archivo>();
        IArchivoService dao= new  ArchivoServiceImpl();
        archivo=dao.obtener();
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        List<Archivo> response = archivoService.getAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
