package br.com.fiap.listacompra.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.listacompra.model.Produto;
import br.com.fiap.listacompra.model.Usuario;
import br.com.fiap.listacompra.repository.ProdutoRepository;
import br.com.fiap.listacompra.repository.UsuarioRepository;

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
    		return 1; //Codigo de Erro para quando o Usuario não existe  
    	} else {
    		if (usuarios.get(0).getSenha().equals(senha)) {
    			return 0; //Senha validada com sucesso
    		} ;
    		return 2; //Codigo de Erro para quando a Senha está incorreta;
    	}	
    	
    }	
    

}
