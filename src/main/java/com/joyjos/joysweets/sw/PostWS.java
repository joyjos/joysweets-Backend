package com.joyjos.joysweets.sw;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.joyjos.joysweets.controlador.FicherosController;
import com.joyjos.joysweets.modelo.PostDTO;
import com.joyjos.joysweets.modelo.PostVO;
import com.joyjos.joysweets.servicios.ServicioPost;
import com.joyjos.joysweets.upload.StorageService;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostWS {
	
	//Inyecto el servicio post
	@Autowired
	ServicioPost sp;
	
	@Autowired
	private StorageService storageService;
	
	//Muestro todos los posts
	@GetMapping("/posts")
	public Iterable<PostDTO> mostrarPosts() {
			
		//creo una lista vacía que almacena los dto
		List<PostDTO> lista=new ArrayList<PostDTO>();
			
		// relleno la lista dto a partir de la lista VO
		for(PostVO p:sp.findAll())
			lista.add(new PostDTO(p.getIdPost(),p.getNombre(),p.getCategoria(),p.getPost(),p.getImagen(),p.getFechaPost(),p.getUsuarios()));
		return lista;
	}
	
	//Muestro un post en particular
	@GetMapping("/post/{idPost}")
	public PostDTO buscarUnPost(@PathVariable int idPost) {
		PostVO pvo=sp.findById(idPost).get();
		PostDTO p=new PostDTO(pvo.getIdPost(),pvo.getNombre(),pvo.getCategoria(),pvo.getPost(),pvo.getImagen(),pvo.getFechaPost(),pvo.getUsuarios());
		return p;
	}
	
	//Inserto un post
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/insertarPost")
	public ResponseEntity<?> insertarPost(@Valid @RequestPart MultipartFile file, @RequestPart PostDTO pdto){
		
		String urlImagen = null;
		if(!file.isEmpty()) {
			String imagen = storageService.store(file);
			urlImagen = MvcUriComponentsBuilder.fromMethodName(FicherosController.class, "serveFile", imagen, null)
						.build().toUriString();
		}
				
		PostVO post = new PostVO(pdto.getNombre(),pdto.getCategoria(),pdto.getPost(),pdto.getFechaPost());
				
		post.setImagen(urlImagen);
		sp.save(post);
		
		return new ResponseEntity<>("El post "+pdto.getNombre()+", se insertó con éxito", HttpStatus.CREATED);
	}
	
	//Modifico un post sin modificar la foto
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/modificarPostNoFile/{idPost}")
	public String modificarPost(@PathVariable int idPost,@RequestPart PostDTO pdto) {
		//recupero el post a modificar
		PostVO p=sp.findById(idPost).get();
		p.setNombre(pdto.getNombre());
		p.setCategoria(pdto.getCategoria());
		p.setPost(pdto.getPost());
		sp.save(p);
		return "El post "+pdto.getNombre()+", se modificó con éxito";
	}
	
	//Modifico un post
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/modificarPost/{idPost}")
	public ResponseEntity<?> modificarPost(@PathVariable int idPost, @Valid @RequestPart MultipartFile file, @RequestPart PostDTO pdto){
		
		String urlImagen = null;
		if(!file.isEmpty()) {
			String imagen = storageService.store(file);
			urlImagen = MvcUriComponentsBuilder.fromMethodName(FicherosController.class, "serveFile", imagen, null)
						.build().toUriString();
		}
				
		//recupero el post a modificar
		PostVO p=sp.findById(idPost).get();
		p.setNombre(pdto.getNombre());
		p.setCategoria(pdto.getCategoria());
		p.setPost(pdto.getPost());
				
		p.setImagen(urlImagen);
		sp.save(p);
		
		return new ResponseEntity<>("El post "+pdto.getNombre()+", se modificó con éxito", HttpStatus.CREATED);
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
