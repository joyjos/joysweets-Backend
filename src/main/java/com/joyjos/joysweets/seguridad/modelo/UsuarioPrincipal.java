package com.joyjos.joysweets.seguridad.modelo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioPrincipal implements UserDetails {
	private static final long serialVersionUID = 1L;
	
    private String nombre;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    
	public UsuarioPrincipal(String nombre, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.nombre = nombre;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
    
	
	public static UsuarioPrincipal build(UsuarioVO usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRoleName().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getUsername(), usuario.getPassword(), authorities);
    }
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
