package com.joyjos.joysweets.sw;

/*import java.time.LocalDate;*/
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joyjos.joysweets.seguridad.modelo.UsuarioDTO;
import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;
import com.joyjos.joysweets.seguridad.servicios.ServicioUsuario;
import com.joyjos.joysweets.servicios.ServicioPost;

@RestController
public class UsuarioWS {
	
	//Inyecto el servicio usuario
	@Autowired
	ServicioUsuario su;
	
	//Inyecto el servicio post
	@Autowired
	ServicioPost sp;
	
	//Muestro todos los usuarios
	@GetMapping("/usuarios")
	public Iterable<UsuarioDTO> mostrarUsuarios() {
		
		//creo una lista vacía que almacena los dto
		List<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
		
		//relleno la lista dto a partir de la lista VO
		for(UsuarioVO u:su.findAll())
			lista.add(new UsuarioDTO(u.getIdUsuario(),u.getNombre()));
		return lista;
	}
	
	//Muestro un usuario en particular
	@GetMapping("/usuario/{idUsuario}")
	public UsuarioDTO buscarUnUsuario(@PathVariable int idUsuario) {
		UsuarioVO uvo=su.findById(idUsuario).get();
		UsuarioDTO u=new UsuarioDTO(uvo.getIdUsuario(),uvo.getNombre());
		return u;
	}
	
	//Inserto un usuario (convierto el UsuarioDTO en UsuarioVO y lo persisto en la bbdd)
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/insertarUsuario")
	public String insertarUsuario(@RequestBody UsuarioVO udto) {
		UsuarioVO u=new UsuarioVO(udto.getNombre(),udto.getUsername(),udto.getPassword());
		su.save(u);
		return "El usuario "+udto.getNombre()+", se registró con éxito";
	}
	
	//Modifico un usuario (convierto el UsuarioDTO en UsuarioVO y lo persisto en la bbdd)
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/modificarUsuario/{idUsuario}")
	public String modificarUsuario(@PathVariable int idUsuario, @RequestBody UsuarioVO usuario) {
		//recupero el usuario a modificar
		UsuarioVO u=su.findById(idUsuario).get();
		u.setNombre(usuario.getNombre());
		u.setUsername(usuario.getUsername());
		u.setPassword(usuario.getPassword());
		su.save(u);
		return "El usuario "+usuario.getNombre()+", se modificó con éxito";
	}
	
	//Elimino un usuario
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminarUsuario/{idUsuario}")
	public String eliminarUsuario(@PathVariable int idUsuario) {
		try {
			
			su.delete(su.findById(idUsuario).get());
		}catch(Exception e) {
			return "Error al eliminar el usuario";
		}
		
		return "Usuario eliminado";
	}
	
	/*
	 * @PostMapping("/usuarios/{idUsuario}/{idPost}") public String
	 * matricular( @PathVariable int idUsuario, @PathVariable int idPost) {
	 * ComentarioVO up=new
	 * ComentarioVO(LocalDate.now(),su.findById(idUsuario).get(),sp.findById(idPost)
	 * .get()); UsuarioVO u=su.findById(idUsuario).get(); PostVO
	 * p=sp.findById(idPost).get(); u.getPosts().add(up); p.getUsuarios().add(up);
	 * su.save(u);
	 * 
	 * return "Usuario registrado"; }
	 */
}