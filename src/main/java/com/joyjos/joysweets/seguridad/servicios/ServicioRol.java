package com.joyjos.joysweets.seguridad.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyjos.joysweets.seguridad.enums.RoleName;
import com.joyjos.joysweets.seguridad.modelo.RolVO;
import com.joyjos.joysweets.seguridad.repositorio.RolRepositorio;

@Service
@Transactional
public class ServicioRol {
	
	@Autowired
	RolRepositorio rr;
	
	public Optional<RolVO> getByRoleName(RoleName roleName){
        return rr.findByRoleName(roleName);
    }

    public void save(RolVO rol){
        rr.save(rol);
    }
}
