package br.com.fiap.listacompra.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.listacompra.model.Login;
import br.com.fiap.listacompra.repository.LoginRepository;

@Component
public class LoginComponent {


	@Autowired
	LoginRepository loginRepository;
	
	public Login salvar(Login login) {
        List<Login> logins = loginRepository.findByUsuario(login.getUsuario());
        if (logins.size() > 0) {
            return null;
        }
        return loginRepository.save(login);
    }
	
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public void deleteAll() {
        loginRepository.deleteAll();
    }
    
    public void delete(String usuario) {
    	
    	List<Login> logins = loginRepository.findByUsuario(usuario);
    	if(!logins.isEmpty())
    		loginRepository.delete(logins.get(0));
    }
  
    public Login buscarUsuario(String usuario) {
        List<Login> logins = loginRepository.findByUsuario(usuario);
        if (logins.isEmpty()) {
            return null;
        } else {
            return logins.get(0);
        }
    }
    
    public Login buscarId(String id) {
    	System.out.println("entrou buscarId");
    	List<Login> logins = loginRepository.findById(id);
    	System.out.println("entrou findbyid");

    	if (logins.isEmpty()) {
        	System.out.println("está vazio");
            return null;
        } else {
        	System.out.println("acho login");
            return logins.get(0);
        }
    }
    
    
    public Login validarSenha(String usuario, String senha) {
    	List<Login> logins = loginRepository.findByUsuario(usuario);
    	if (logins.isEmpty()) {
    		return null; //Codigo de Erro para quando o Usuario não existe  
    	} else {
    		if (logins.get(0).getSenha().equals(senha)) {
    			return logins.get(0); //Senha validada com sucesso
    		} ;
    		return null; //Codigo de Erro para quando a Senha está incorreta;
    	}	

    }

    
}
