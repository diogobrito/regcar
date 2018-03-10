package com.regcar.component;

import com.regcar.model.Carro;
import com.regcar.repository.CarroRepository;
import org.springframework.stereotype.Component;

import com.regcar.model.Login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class CarroComponent {

	@Autowired
    CarroRepository carroRepository;
	
	public Carro salvar(Carro carro, Login login) {
        List<Carro> produtosLogin = carroRepository.findByLogin(login);
        
        if (produtosLogin.size() > 0) {
           for (int i=0; i < produtosLogin.size();i++) {

              if (produtosLogin.get(i).getNome().equals(carro.getNome())){
                  List<Carro> carros = carroRepository.findById(produtosLogin.get(i).getId());
            	  carro.setId(produtosLogin.get(i).getId());
                  return null;
              }
        	
           }
        }
        return carroRepository.save(carro);
        
    }

    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    public List<Carro> findByLogin(Login login) {
        return carroRepository.findByLogin(login);
    }

    
    public void deleteAll() {
        carroRepository.deleteAll();
    }
    
    public void delete(String nome, Login login) {
    	
        List<Carro> produtosLogin = carroRepository.findByLogin(login);
        
        if (produtosLogin.size() > 0) {
           for (int i=0; i < produtosLogin.size();i++) {
        	  System.out.println("produtoLogin " + produtosLogin.get(i).getNome());
        	          	  
              if (produtosLogin.get(i).getNome().equals(nome)){
            	  System.out.println("Produtos sao iguais");
            	  carroRepository.delete(produtosLogin.get(i));

              }
        	
           }
 		}
    }

    public Carro busca(String nome, Login login) {
    	
        List<Carro> produtosLogin = carroRepository.findByLogin(login);
        
        if (produtosLogin.size() > 0) {
           for (int i=0; i < produtosLogin.size();i++) {
        	  System.out.println("produtoLogin " + produtosLogin.get(i).getNome());
        	          	  
              if (produtosLogin.get(i).getNome().equals(nome)){
            	  System.out.println("Produtos sao iguais");
            	  return produtosLogin.get(i);
              }
        	
           }
 		}
        return null;
    }

    
    public Carro update(Carro carro) {
        List<Carro> produtosLogin = carroRepository.findByLogin(carro.getLogin());
        
        if (produtosLogin.size() > 0) {
           for (int i=0; i < produtosLogin.size();i++) {
        	  System.out.println("produtoLogin " + produtosLogin.get(i).getNome());
        	  System.out.println("carro" + carro.getNome());
        	          	  
              if (produtosLogin.get(i).getNome().equals(carro.getNome())){
            	  System.out.println("Produtos sao iguais");
                  List<Carro> carros = carroRepository.findById(produtosLogin.get(i).getId());
            	  carro.setId(produtosLogin.get(i).getId());

              }
        	
           }
        }
        return carroRepository.save(carro);
        
    }
	
}
