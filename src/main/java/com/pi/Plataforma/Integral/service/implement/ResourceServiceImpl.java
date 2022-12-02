package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.service.IResourceService;
import com.pi.Plataforma.Integral.utils.Constants;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ResourceServiceImpl implements IResourceService {
    private final static String DIRECTORIO_UPLOAD = Constants.DIRECTORIO_UPLOAD;

    @Override
    public Resource cargar(String nombreFoto) throws MalformedURLException {
        Path rutaArchivo = getPath(nombreFoto);

        Resource recurso = new UrlResource(rutaArchivo.toUri());

        if (!recurso.exists()) {
            throw new MalformedURLException("No se pudo cargar el recurso");
        }
        return recurso;
    }

    public Path getPath(String nombreFoto) {
        return Paths.get(DIRECTORIO_UPLOAD).resolve(nombreFoto).toAbsolutePath();
    }
}
