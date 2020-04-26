package com.joyjos.joysweets.seguridad.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joyjos.joysweets.seguridad.enums.RoleName;
import com.joyjos.joysweets.seguridad.modelo.RolVO;

@Repository
public interface RolRepositorio extends CrudRepository<RolVO, Integer> {
	
	public Optional<RolVO> findByRoleName(RoleName roleName);
}
