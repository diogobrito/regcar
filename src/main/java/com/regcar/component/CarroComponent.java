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
        List<Carro> carroList = carroRepository.findByLogin(login);
        
        if (carroList.size() > 0) {
           for (int i=0; i < carroList.size();i++) {

              if (carroList.get(i).getNome().equals(carro.getNome())){
                  List<Carro> carros = carroRepository.findById(carroList.get(i).getId());
            	  carro.setId(carroList.get(i).getId());
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
    	
        List<Carro> carrosList = carroRepository.findByLogin(login);
        
        if (carrosList.size() > 0) {
           for (int i=0; i < carrosList.size();i++) {
              if (carrosList.get(i).getNome().equals(nome)){
            	  carroRepository.delete(carrosList.get(i));
              }
        	
           }
 		}
    }

    public Carro busca(String nome, Login login) {
    	
        List<Carro> carroList = carroRepository.findByLogin(login);
        
        if (carroList.size() > 0) {
           for (int i=0; i < carroList.size();i++) {
              if (carroList.get(i).getNome().equals(nome)){
            	  return carroList.get(i);
              }
        	
           }
 		}
        return null;
    }

    
    public Carro update(Carro carro) {
        List<Carro> carroList = carroRepository.findByLogin(carro.getLogin());
        
        if (carroList.size() > 0) {
           for (int i=0; i < carroList.size();i++) {
              if (carroList.get(i).getNome().equals(carro.getNome())){
                  List<Carro> carros = carroRepository.findById(carroList.get(i).getId());
            	  carro.setId(carroList.get(i).getId());
              }
        	
           }
        }
        return carroRepository.save(carro);
        
    }
	
}
