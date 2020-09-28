package com.joyjos.joysweets.seguridad.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;
import com.joyjos.joysweets.seguridad.repositorio.UsuarioRepositorio;

@Service
@Transactional
public class ServicioUsuario {
	
	@Autowired
	UsuarioRepositorio ur;
	
	public Optional<UsuarioVO> getByNombre(String nombre){
        return ur.findByUsername(nombre);
    }

    public boolean existsByNombre(String nombre){
        return ur.existsByNombre(nombre);
    }

    public boolean existsByUsername(String username){
        return ur.existsByUsername(username);
    }

    public void save(UsuarioVO usuario){
        ur.save(usuario);
    }

	public Optional<UsuarioVO> findById(int id) {
		return ur.findById(id);
	}

	public void delete(UsuarioVO usuario) {
		ur.delete(usuario);
		
	}

	public Iterable<UsuarioVO> findAll() {
		return ur.findAll();
	}

	public UsuarioVO findByNombre(String nombre) {
		return ur.findByNombre(nombre);
	}
	
	public Optional<UsuarioVO> findByUsername(String username) {
		return ur.findByUsername(username);
	}
    
}
