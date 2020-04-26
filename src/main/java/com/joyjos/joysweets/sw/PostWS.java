package com.joyjos.joysweets.sw;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyjos.joysweets.modelo.PostDTO;
import com.joyjos.joysweets.modelo.PostVO;
import com.joyjos.joysweets.servicios.ServicioPost;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostWS {
	
	//Inyecto el servicio post
	@Autowired
	ServicioPost sp;
	
	//Muestro todos los posts
	@GetMapping("/posts")
	public Iterable<PostDTO> mostrarPosts() {
			
		//creo una lista vacía que almacena los dto
		List<PostDTO> lista=new ArrayList<PostDTO>();
			
		// relleno la lista dto a partir de la lista VO
		for(PostVO p:sp.findAll())
			lista.add(new PostDTO(p.getIdPost(),p.getNombre(),p.getCategoria(),p.getPost(),p.getImagen(),p.getFechaPost()));
		return lista;
	}
	
	//Muestro un post en particular
	@GetMapping("/post/{idPost}")
	public PostDTO buscarUnPost(@PathVariable int idPost) {
		PostVO pvo=sp.findById(idPost).get();
		PostDTO p=new PostDTO(pvo.getIdPost(),pvo.getNombre(),pvo.getCategoria(),pvo.getPost(),pvo.getImagen(),pvo.getFechaPost());
		return p;
	}
	
	//Inserto un post
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/insertarPost")
	public String insertarPost(@RequestBody PostDTO pdto) {
		sp.save(new PostVO(pdto.getNombre(),pdto.getCategoria(),pdto.getPost(),pdto.getImagen(),pdto.getFechaPost()));
		return "El post "+pdto.getPost()+", se insertó con éxito";
	}
	
	//Modifico un post
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/modificarPost/{idPost}")
	public String modificarPost(@PathVariable int idPost,@RequestBody PostDTO post) {
		//recupero el post a modificar
		PostVO p=sp.findById(idPost).get();
		p.setNombre(post.getNombre());
		p.setCategoria(post.getCategoria());
		p.setPost(post.getPost());
		p.setImagen(post.getImagen());
		p.setFechaPost(post.getFechaPost());
		sp.save(p);
		return "El post "+post.getPost()+", se modificó con éxito";
	}
	
	//Elimino un post
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminarPost/{idPost}")
	public String eliminarPost(@PathVariable int idPost) {
		try {
			sp.delete(sp.findById(idPost).get());
		}catch(Exception e) {
			return "Error al eliminar el post";
		}
			
		return "Post eliminado";
	}
}
