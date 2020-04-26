package com.joyjos.joysweets.repositorio;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joyjos.joysweets.modelo.ComentarioVO;

@Repository
public interface ComentarioRepositorio extends CrudRepository<ComentarioVO, Integer> {
	
	public ComentarioVO findByComentario(String comentario);
	public ComentarioVO findByFechaComentario(LocalDate fechaComentario);
}
