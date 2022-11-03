package com.pi.Plataforma.Integral.auth;

import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IUssuriooooService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {

    private final IUssuriooooService ussuriooooService;

    public SecurityAuditorAware(IUssuriooooService ussuriooooService){
        this.ussuriooooService = ussuriooooService;
    }
    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() || authentication.getName().equals("anonymousUser")){
            return Optional.empty();
        }
        Ussurioooo ussurioooo = ussuriooooService.findByEmail(authentication.getName());
        return  Optional.of(ussurioooo.getId());
    }
}
