package com.pi.Plataforma.Integral.auth;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    private final IUssuriooooService ussuriooooService;

    public InfoAdicionalToken(IUssuriooooService ussuriooooService){
        this.ussuriooooService=ussuriooooService;

    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Ussurioooo ussurioooo = ussuriooooService.findByEmail(oAuth2Authentication.getName());
        Map<String, Object> info = new HashMap<>();
        info.put("id", ussurioooo.getId());
        info.put("nombre", ussurioooo.getNombre());
        info.put("apellido", ussurioooo.getApellido());
        info.put("fecha_creaci",ussurioooo.getFecha_creaci());
        info.put("correo", ussurioooo.getCorreo());
        info.put("contraseña",ussurioooo.getContraseña());
        info.put("status",ussurioooo.getStatus());
        info.put("telefono",ussurioooo.getTelefono());
        info.put("fecha_actual", ussurioooo.getFecha_actual());
        info.put("genero",ussurioooo.getGenero());
        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }

}
