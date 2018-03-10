package com.regcar.component;

import java.util.List;

import com.regcar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.regcar.model.Usuario;

@Component
public class UsuarioComponent {

	@Autowired
    UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findByUsuario(usuario.getUsuario());
        if (usuarios.size() > 0) {
            usuario.setUsuario(usuarios.get(0).getUsuario());
        }
        return usuarioRepository.save(usuario);
    }
	
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void deleteAll() {
        usuarioRepository.deleteAll();
    }
    
    public void delete(String usuario) {
    	
    	List<Usuario> usuarios = usuarioRepository.findByUsuario(usuario);
    	if(!usuarios.isEmpty())
    		usuarioRepository.delete(usuarios.get(0));
    }
  
    public Usuario buscarUsuario(String usuario) {
        List<Usuario> usuarios = usuarioRepository.findByUsuario(usuario);
        if (usuarios.isEmpty()) {
            return new Usuario();
        } else {
            return usuarios.get(0);
        }
    }
    
    public int validarSenha(String usuario, String senha) {
    	List<Usuario> usuarios = usuarioRepository.findByUsuario(usuario);
    	if (usuarios.isEmpty()) {
    		return 1;
    	} else {
    		if (usuarios.get(0).getSenha().equals(senha)) {
    			return 0;
    		} ;
    		return 2;
    	}	
    	
    }	
    

}
