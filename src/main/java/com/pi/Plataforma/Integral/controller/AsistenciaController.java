package com.pi.Plataforma.Integral.controller;

import com.itextpdf.text.DocumentException;
import com.pi.Plataforma.Integral.models.Asistencia;
import com.pi.Plataforma.Integral.service.IAsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/asistencia")
@CrossOrigin(origins = "*")
public class AsistenciaController {

    @Autowired
    private IAsistenciaService asistenciaService;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody Asistencia asistencia){
        asistenciaService.save(asistencia);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/getAsistencia")
    public ResponseEntity<?> TraerAsistencia(){
        List<Asistencia> asistencias = asistenciaService.getAll();
        return new ResponseEntity<>(asistencias,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        asistenciaService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

    /*@GetMapping("/generatePdf/{id_asistencia}")
    public ResponseEntity<?> generatePdf(@PathVariable(name = "id_asistencia") Long id_asistencia) throws IOException, DocumentException {
        String path = asistenciaService.generatePdf(id_asistencia);
        Resource resource = null;
        InputStreamResource inputStreamResource = null;

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""  + "\"");

        return ResponseEntity.ok().headers(cabecera).contentLength(resource.contentLength())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(inputStreamResource);
    }

*/



