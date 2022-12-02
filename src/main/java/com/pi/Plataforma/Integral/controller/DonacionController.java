package com.pi.Plataforma.Integral.controller;

import com.itextpdf.text.DocumentException;
import com.pi.Plataforma.Integral.models.*;
import com.pi.Plataforma.Integral.service.IDonacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@RestController
@RequestMapping("/donacion")
@CrossOrigin(origins = "*")
public class DonacionController {
    @Autowired
    private IDonacionService donacionService;

    public DonacionController(IDonacionService donacionService){this.donacionService=donacionService;}

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Donacion donacion){
        donacionService.save(donacion);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/getUssurioooo/{ussurioooo}")
    public ResponseEntity<?> getUssurioooo(@PathVariable(name = "ussurioooo") Long id_usuario){
        List<Donacion> response = donacionService.getUssurioooo(id_usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getDonaciones")
    public ResponseEntity<?> TraerDonaciones(){
        List<Donacion>  donacions= donacionService.get();
        return new ResponseEntity<>(donacions,HttpStatus.OK);
    }


    @GetMapping("/getDonacion")
    public ResponseEntity<?> TraerDonacion(){
        List<Donacion> donacions = donacionService.getAll();
        return new ResponseEntity<>(donacions,HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> nuevo(@RequestBody Long id){
        donacionService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/generatePdf/{id_donacion}")
    public ResponseEntity<?> generatePdf(@PathVariable(name = "id_donacion") Long id_donacion) throws IOException, DocumentException {
        String path = donacionService.generatePdf(id_donacion);
        Resource resource = null;
        InputStreamResource inputStreamResource = null;

        try {
            inputStreamResource = new InputStreamResource(resource.getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return ResponseEntity.ok().headers(cabecera).contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(inputStreamResource);
    }
}
