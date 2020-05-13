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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.joyjos.joysweets.modelo.ComentarioDTO;
import com.joyjos.joysweets.modelo.ComentarioVO;
import com.joyjos.joysweets.modelo.PostVO;
import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;
import com.joyjos.joysweets.seguridad.servicios.ServicioUsuario;
import com.joyjos.joysweets.servicios.ServicioComentario;
import com.joyjos.joysweets.servicios.ServicioPost;

@RestController
@RequestMapping("/comentarios")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioWS {
	
	//Inyecto el servicio usuario
	@Autowired
	ServicioUsuario su;
	
	//Inyecto el servicio post
	@Autowired
	ServicioPost sp;
	
	//Inyecto el servicio comentario
	@Autowired
	ServicioComentario sc;
	
//	@GetMapping("/comentarios")
//	public Iterable<UsuarioVO> mostrarComentarios(){
//		return su.findAll();
//	}
	
	//Muestro todos los comentarios
	@GetMapping("/comentarios")
	public Iterable<ComentarioDTO> mostrarComentarios() {
			
		//creo una lista vacía que almacena los dto
		List<ComentarioDTO> lista=new ArrayList<ComentarioDTO>();
			
		// relleno la lista dto a partir de la lista VO
		for(ComentarioVO up:sc.findAll())
			lista.add(new ComentarioDTO(up.getIdComentario(),up.getComentario(),up.getFechaComentario()));
		return lista;
	}
	
	//Muestro los comentarios por Post
	@GetMapping("/comentarios/{idPost}")
	public ComentarioDTO buscarComentarioPorPost(@PathVariable int idPost) {
		ComentarioVO cvo=sc.findById(idPost).get();
		ComentarioDTO c=new ComentarioDTO(cvo.getIdComentario(),cvo.getComentario(),cvo.getFechaComentario());
		return c;
	}
	
	//Muestro un comentario en particular
	@GetMapping("/comentario/{idComentario}")
	public ComentarioDTO buscarUnComentario(@PathVariable int idComentario) {
		ComentarioVO cvo=sc.findById(idComentario).get();
		ComentarioDTO c=new ComentarioDTO(cvo.getIdComentario(),cvo.getComentario(),cvo.getFechaComentario());
		return c;
	}
	
	
//	  //Muestro los comentarios de un post
//	  @GetMapping("/comentarios/{idPost}")
//	  public Iterable<ComentarioDTO>buscarComentarios(@PathVariable int idPost) {
//	  
//		  //creo una lista vacía que almacena los dto
//		  List<ComentarioDTO> lista=new ArrayList<ComentarioDTO>();
//	  
//		  //relleno la lista dto a partir de la lista VO
//		  for(ComentarioVO up:sc.findById(idPost))
//			lista.add(new ComentarioDTO(up.getIdComentario(),up.getComentario(),up.getFechaComentario()));
//			return lista;
//	  }
	
	/*
	 * @GetMapping("/comentarios/children/{id}")
	 * 
	 * @ResponseBody public List<ComentarioDTO> getChildren(@PathVariable int id){
	 * return sc.findByParent(sc.getOne(id)); }
	 */
	 
	
	//Inserto un comentario
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/comentarios/{idUsuario}/{idPost}")
	public String insertarComentario( @PathVariable int idUsuario, @PathVariable int idPost, @RequestBody ComentarioVO cdto) {
		ComentarioVO up=new ComentarioVO(su.findById(idUsuario).get(),sp.findById(idPost).get(),cdto.getComentario(),cdto.getFechaComentario());
		UsuarioVO u=su.findById(idUsuario).get();
		PostVO p=sp.findById(idPost).get();
		u.getPosts().add(up);
		p.getUsuarios().add(up);
		sc.save(up);
		
		return "Comentario insertado";
	}
	
	//Modifico un comentario
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/modificarComentario/{idComentario}")
	public String modificarComentario(@PathVariable int idComentario, @RequestBody ComentarioVO comentario) {
		//recupero el comentario a modificar
		ComentarioVO c=sc.findById(idComentario).get();
		c.setComentario(comentario.getComentario());
		c.setFechaComentario(comentario.getFechaComentario());
		sc.save(c);
		return "Comentario modificado";
	}
	
	//Elimino un comentario
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminarComentario/{idComentario}")
	public String eliminarComentario(@PathVariable int idComentario) {
		try {
			sc.delete(sc.findById(idComentario).get());
		}catch(Exception e) {
			return "Error al eliminar el comentario";
		}
		
		return "Comentario eliminado";
	}
}
