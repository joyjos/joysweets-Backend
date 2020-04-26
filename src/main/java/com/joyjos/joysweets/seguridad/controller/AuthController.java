package com.joyjos.joysweets.seguridad.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joyjos.joysweets.seguridad.dto.JwtDTO;
import com.joyjos.joysweets.seguridad.dto.LoginUsuario;
import com.joyjos.joysweets.seguridad.dto.Mensaje;
import com.joyjos.joysweets.seguridad.dto.NuevoUsuario;
import com.joyjos.joysweets.seguridad.enums.RoleName;
import com.joyjos.joysweets.seguridad.jwt.JwtProvider;
import com.joyjos.joysweets.seguridad.modelo.RolVO;
import com.joyjos.joysweets.seguridad.modelo.UsuarioVO;
import com.joyjos.joysweets.seguridad.servicios.ServicioRol;
import com.joyjos.joysweets.seguridad.servicios.ServicioUsuario;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ServicioUsuario su;

    @Autowired
    ServicioRol sr;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        if(su.existsByNombre(nuevoUsuario.getNombre()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(su.existsByUsername(nuevoUsuario.getUsername()))
            return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
        UsuarioVO usuario =
                new UsuarioVO(nuevoUsuario.getNombre(), nuevoUsuario.getUsername(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<RolVO> roles = new HashSet<>();
        roles.add(sr.getByRoleName(RoleName.ROLE_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(sr.getByRoleName(RoleName.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        su.save(usuario);
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }
}
