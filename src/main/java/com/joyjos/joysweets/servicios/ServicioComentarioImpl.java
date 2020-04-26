package com.joyjos.joysweets.servicios;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyjos.joysweets.modelo.ComentarioVO;
import com.joyjos.joysweets.repositorio.ComentarioRepositorio;

@Service
public class ServicioComentarioImpl implements ServicioComentario {
	
	@Autowired
	ComentarioRepositorio cr;

	public ComentarioVO findByComentario(String comentario) {
		return cr.findByComentario(comentario);
	}

	public ComentarioVO findByFechaComentario(LocalDate fechaComentario) {
		return cr.findByFechaComentario(fechaComentario);
	}

	public <S extends ComentarioVO> S save(S entity) {
		return cr.save(entity);
	}

	public Optional<ComentarioVO> findById(Integer id) {
		return cr.findById(id);
	}

	public Iterable<ComentarioVO> findAll() {
		return cr.findAll();
	}

	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	public void delete(ComentarioVO entity) {
		cr.delete(entity);
	}
	
}
