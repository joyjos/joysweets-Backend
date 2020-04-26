package com.joyjos.joysweets.seguridad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joyjos.joysweets.seguridad.modelo.UsuarioPrincipal;
import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    ServicioUsuario su;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        UsuarioVO usuario = su.getByNombre(nombre).get();
        return UsuarioPrincipal.build(usuario);
    }
}
