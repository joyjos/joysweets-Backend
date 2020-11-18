package com.joyjos.joysweets.repositorio;

import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joyjos.joysweets.modelo.PostDTO;
import com.joyjos.joysweets.modelo.PostVO;

@Repository
public interface PostRepositorio extends CrudRepository<PostVO, Integer> {
	
	public PostVO findByNombre(String nombre);
	public PostVO findByCategoria(String categoria);
	public PostVO findByPost(String post);
	public PostVO findByImagen(String imagen);
	public PostVO findByFechaPost(LocalDate fechaPost);
	public void save(PostDTO pdto);
}
