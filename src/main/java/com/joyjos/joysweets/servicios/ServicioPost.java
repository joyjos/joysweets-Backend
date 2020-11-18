package com.joyjos.joysweets.servicios;

import java.time.LocalDate;
import java.util.Optional;

import com.joyjos.joysweets.modelo.ComentarioVO;
import com.joyjos.joysweets.modelo.PostDTO;
import com.joyjos.joysweets.modelo.PostVO;

public interface ServicioPost {

	void delete(PostVO entity);

	void deleteById(int id);

	Iterable<PostVO> findAll();
	
	PostVO findByNombre(String nombre);
	
	PostVO findByCategoria(String categoria);

	PostVO findByPost(String post);

	PostVO findByFechaPost(LocalDate fechaPost);

	Optional<PostVO> findById(int id);

	PostVO findByImagen(String imagen);

	<S extends PostVO> S save(S entity);

	ComentarioVO findByComentario(String string);

	void save(PostDTO pdto);

}