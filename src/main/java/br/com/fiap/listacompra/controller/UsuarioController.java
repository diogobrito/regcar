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

import br.com.fiap.listacompra.component.UsuarioComponent;
import br.com.fiap.listacompra.model.Produto;
import br.com.fiap.listacompra.model.Usuario;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {

	   @Autowired
	   private UsuarioComponent usuarioComponent;
	   
	   @PostMapping
	   private void save(@RequestBody Usuario usuario) {
	       usuarioComponent.salvar(usuario);
	   }

	   @GetMapping
	   private List<Usuario> findAll() {
	       return usuarioComponent.findAll();
	   }
	   
	   @GetMapping(value = "/usuario/{usuario}")
	   private Usuario buscarUsuario(@PathVariable(value = "usuario") String usuario) {
	       return usuarioComponent.buscarUsuario(usuario);
	   }
	   
       @GetMapping(value = "/validarsenha/{usuario}/{senha}")
       private int validarSenha(@PathVariable(value = "senha") String senha, @PathVariable(value = "usuario") String usuario) {
    	   return usuarioComponent.validarSenha(usuario,senha);
       }

}
