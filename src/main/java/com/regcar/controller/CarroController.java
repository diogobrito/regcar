package com.regcar.controller;
import com.regcar.model.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.regcar.component.LoginComponent;
import com.regcar.component.CarroComponent;
import com.regcar.model.Login;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class CarroController {

   @Autowired
   private CarroComponent carroComponent;

   @Autowired
   private LoginComponent loginComponent;
   
   
   @GetMapping
   private List<Carro> findAll() {
       return carroComponent.findAll();
   }

      
   @PostMapping
   private Carro save(@RequestBody Carro carro) {

		//validar se cliente existe ou não
		Login login = loginComponent.buscarId(carro.getLogin().getId());
		System.out.println(login);
		
		if (login == null) {
       	    System.out.println("está vazio classe login");
		}
		else {
       	System.out.println("tem classe login");
        return carroComponent.salvar(carro, login);
		}
		return null;
   }
   
   @DeleteMapping
   private void deleteAll() {
       carroComponent.deleteAll();
   }

   @DeleteMapping(value = "/nome/{nome}/{idLogin}")
   private void delete(@PathVariable(value = "nome") String nome, @PathVariable(value = "idLogin" ) String id) {
   	    Login login = loginComponent.buscarId(id);
  		System.out.println(login);

       carroComponent.delete(nome, login);
   }
   
  
   @GetMapping(value = "/produtos/{idLogin}")
   private List<Carro> findByLogin(@PathVariable(value = "idLogin") String idLogin) {

		//validar se cliente existe ou não
		Login login = loginComponent.buscarId(idLogin);
		System.out.println(login);
		
		if (login == null) {
      	    System.out.println("está vazio classe login");
		}
	   
       return carroComponent.findByLogin(login);
   }
   
   @GetMapping(value = "/nome/{nome}/{idLogin}")
   private Carro busca(@PathVariable(value = "nome") String nome, @PathVariable(value = "idLogin" ) String id) {
   	    Login login = loginComponent.buscarId(id);
  		System.out.println(login);

        return carroComponent.busca(nome, login);
   }
  
   @PostMapping(value = "/altera")
   private Carro altera(@RequestBody Carro carro){
		
	   return carroComponent.update(carro);
   }
   
}
