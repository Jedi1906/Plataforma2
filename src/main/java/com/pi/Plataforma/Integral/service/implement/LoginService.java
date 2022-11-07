package com.pi.Plataforma.Integral.service.implement;

import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    private final IUssuriooooDao ussuriooooDao;

    public LoginService(IUssuriooooDao ussuriooooDao) {
        this.ussuriooooDao = ussuriooooDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Ussurioooo ussurioooo = ussuriooooDao.findByCorreo(username);
        if (ussurioooo == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (ussurioooo.getRol() != null) {
            authorities.add(new SimpleGrantedAuthority(ussurioooo.getRol().toString()));
        }
        return new User(ussurioooo.getCorreo(), ussurioooo.getContraseña(), ussurioooo.getStatus() == 1, true, true, true, authorities);
    }
}
