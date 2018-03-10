package com.regcar.component;

import java.util.List;

import com.regcar.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.regcar.model.Login;

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
    	List<Login> logins = loginRepository.findById(id);

    	if (logins.isEmpty()) {
            return null;
        } else {
            return logins.get(0);
        }
    }
    
    
    public Login validarSenha(String usuario, String senha) {
    	List<Login> logins = loginRepository.findByUsuario(usuario);
    	if (logins.isEmpty()) {
    		return null;
    	} else {
    		if (logins.get(0).getSenha().equals(senha)) {
    			return logins.get(0);
    		} ;
    		return null;
    	}	

    }

    
}
