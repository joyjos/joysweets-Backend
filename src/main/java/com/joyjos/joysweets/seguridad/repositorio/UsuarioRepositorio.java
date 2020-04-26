package com.joyjos.joysweets.seguridad.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioVO, Integer> {
	
	public Optional<UsuarioVO> findByUsername(String username);
	public UsuarioVO findByNombre(String nombre);
	
	boolean existsByUsername(String username);
	boolean existsByNombre(String nombre);
}
