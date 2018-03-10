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
	
	public Login salvar(Login loginSave) {
        List<Login> login = loginRepository.findByUsuario(loginSave.getUsuario());
        if (login.size() > 0) {
            return null;
        }
        return loginRepository.save(loginSave);
    }
	
    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public void deleteAll() {
        loginRepository.deleteAll();
    }
    
    public void delete(String user) {
    	
    	List<Login> login = loginRepository.findByUsuario(user);
    	if(!login.isEmpty())
    		loginRepository.delete(login.get(0));
    }
  
    public Login buscarUsuario(String user) {
        List<Login> login = loginRepository.findByUsuario(user);
        if (login.isEmpty()) {
            return null;
        } else {
            return login.get(0);
        }
    }
    
    public Login buscarId(String id) {
    	List<Login> login = loginRepository.findById(id);

    	if (login.isEmpty()) {
            return null;
        } else {
            return login.get(0);
        }
    }
    
    
    public Login validarSenha(String user, String senha) {
    	List<Login> login = loginRepository.findByUsuario(user);
    	if (login.isEmpty()) {
    		return null;
    	} else {
    		if (login.get(0).getSenha().equals(senha)) {
    			return login.get(0);
    		} ;
    		return null;
    	}
    }
}
