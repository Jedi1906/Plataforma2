package com.pi.Plataforma.Integral.service;

import org.springframework.core.io.Resource;

import java.net.MalformedURLException;

public interface IResourceService {
    Resource cargar(String ruta) throws MalformedURLException;

}
