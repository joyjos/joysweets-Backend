package com.joyjos.joysweets.servicios;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joyjos.joysweets.modelo.ComentarioVO;
import com.joyjos.joysweets.modelo.PostVO;
import com.joyjos.joysweets.repositorio.PostRepositorio;

@Service
public class ServicioPostImpl implements ServicioPost {
	
	@Autowired
	PostRepositorio pr;

	@Override
	public void delete(PostVO entity) {
		pr.delete(entity);
	}

	@Override
	public void deleteById(int id) {
		pr.deleteById(id);
	}

	@Override
	public Iterable<PostVO> findAll() {
		return pr.findAll();
	}

	@Override
	public PostVO findByNombre(String nombre) {
		return pr.findByNombre(nombre);
	}
	
	@Override
	public PostVO findByCategoria(String categoria) {
		return pr.findByCategoria(categoria);
	}
	
	@Override
	public PostVO findByPost(String post) {
		return pr.findByPost(post);
	}

	@Override
	public PostVO findByFechaPost(LocalDate fechaPost) {
		return pr.findByFechaPost(fechaPost);
	}

	@Override
	public Optional<PostVO> findById(int id) {
		return pr.findById(id);
	}

	@Override
	public PostVO findByImagen(String imagen) {
		return pr.findByImagen(imagen);
	}

	@Override
	public <S extends PostVO> S save(S entity) {
		return pr.save(entity);
	}

	@Override
	public ComentarioVO findByComentario(String string) {
		return null;
	}
	
}
