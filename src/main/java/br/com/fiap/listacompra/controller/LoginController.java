package br.com.fiap.listacompra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.listacompra.component.LoginComponent;
import br.com.fiap.listacompra.model.Login;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class LoginController {

	   @Autowired
	   private LoginComponent loginComponent;
	   
	   @PostMapping
	   private Login save(@RequestBody Login login) {
	       return loginComponent.salvar(login);
	   }

	   @GetMapping
	   private List<Login> findAll() {
	       return loginComponent.findAll();
	   }
	   
	   @GetMapping(value = "/usuario/{usuario}")
	   private Login buscarLogin(@PathVariable(value = "usuario") String usuario) {
	       return loginComponent.buscarUsuario(usuario);
	   }
	   
    @GetMapping(value = "/validarsenha/{usuario}/{senha}")
    private Login validarSenha(@PathVariable(value = "senha") String senha, @PathVariable(value = "usuario") String usuario) {
 	   return loginComponent.validarSenha(usuario,senha);
    }

}
