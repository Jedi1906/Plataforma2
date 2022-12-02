package com.pi.Plataforma.Integral.controller;

import com.itextpdf.text.DocumentException;
import com.pi.Plataforma.Integral.models.*;
import com.pi.Plataforma.Integral.service.IDonacionService;
import com.pi.Plataforma.Integral.service.IResourceService;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import com.pi.Plataforma.Integral.service.implement.DonacionServiceImpl;
import com.pi.Plataforma.Integral.service.implement.UssuriooooImpl;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/donacion")
@CrossOrigin(origins = "*")
public class DonacionController {

    private final IDonacionService donacionService;

    private  final IResourceService resourceService;

    public DonacionController(IDonacionService donacionService, IResourceService resourceService) {
        this.donacionService = donacionService;
        this.resourceService = resourceService;
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Donacion donacion){
        donacionService.save(donacion);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getUssurioooo")
    public ResponseEntity<?> getUssurioooo(){
        List<Ussurioooo> response = donacionService.getUssurioooo();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping("/getDonacion")
    public ResponseEntity<?> TraerDonacion(){
        List<Donacion> donacions = donacionService.getAll();
        return new ResponseEntity<>(donacions,HttpStatus.OK);
    }



    @GetMapping("/getDonaciones")
    public ResponseEntity<?> TraerDonaciones(){
        List<Donacion>  donacions= donacionService.get();
        return new ResponseEntity<>(donacions,HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        donacionService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/generatePdf/{id}")
    public ResponseEntity<?> generatePdf(@PathVariable(name = "id") Long id) throws IOException, DocumentException {
        String path = donacionService.generatePdf(id);
        Resource resource = null;
        InputStreamResource inputStreamResource = null;

        try {
            resource = resourceService.cargar(path);
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
