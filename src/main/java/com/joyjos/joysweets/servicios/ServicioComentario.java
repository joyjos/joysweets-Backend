package com.joyjos.joysweets.servicios;

import java.time.LocalDate;
import java.util.Optional;

import com.joyjos.joysweets.modelo.ComentarioVO;

public interface ServicioComentario {

	ComentarioVO findByComentario(String comentario);

	ComentarioVO findByFechaComentario(LocalDate fechaComentario);

	<S extends ComentarioVO> S save(S entity);

	Optional<ComentarioVO> findById(Integer id);

	Iterable<ComentarioVO> findAll();

	void deleteById(Integer id);

	void delete(ComentarioVO entity);

}