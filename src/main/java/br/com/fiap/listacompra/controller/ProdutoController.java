package br.com.fiap.listacompra.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.listacompra.component.LoginComponent;
import br.com.fiap.listacompra.component.ProdutoComponent;
import br.com.fiap.listacompra.model.Login;
import br.com.fiap.listacompra.model.Produto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/produto")
public class ProdutoController {

   @Autowired
   private ProdutoComponent produtoComponent;

   @Autowired
   private LoginComponent loginComponent;
   
   
   @GetMapping
   private List<Produto> findAll() {
       return produtoComponent.findAll();
   }
   
   //@GetMapping(value = "/nome/{nome}")
   //private Produto buscarProduto(@PathVariable(value = "nome") String nome) {
   //    return produtoComponent.buscarProduto(nome);
   //}

      
   @PostMapping
   private Produto save(@RequestBody Produto produto) {

		//validar se cliente existe ou não
		Login login = loginComponent.buscarId(produto.getLogin().getId());
		System.out.println(login);
		
		if (login == null) {
       	    System.out.println("está vazio classe login");
		}
		else {
       	System.out.println("tem classe login");
        return produtoComponent.salvar(produto, login);
		}
		return null;
   }
   
   @DeleteMapping
   private void deleteAll() {
       produtoComponent.deleteAll();
   }

   @DeleteMapping(value = "/nome/{nome}/{idLogin}")
   private void delete(@PathVariable(value = "nome") String nome, @PathVariable(value = "idLogin" ) String id) {
   	    Login login = loginComponent.buscarId(id);
  		System.out.println(login);

       produtoComponent.delete(nome, login);
   }
   
  
   @GetMapping(value = "/produtos/{idLogin}")
   private List<Produto> findByLogin(@PathVariable(value = "idLogin") String idLogin) {

		//validar se cliente existe ou não
		Login login = loginComponent.buscarId(idLogin);
		System.out.println(login);
		
		if (login == null) {
      	    System.out.println("está vazio classe login");
		}
	   
       return produtoComponent.findByLogin(login);
   }
   
   @GetMapping(value = "/nome/{nome}/{idLogin}")
   private Produto busca(@PathVariable(value = "nome") String nome, @PathVariable(value = "idLogin" ) String id) {
   	    Login login = loginComponent.buscarId(id);
  		System.out.println(login);

        return produtoComponent.busca(nome, login);
   }
  
   @PostMapping(value = "/altera")
   private Produto altera(@RequestBody Produto produto){
		
	   return produtoComponent.update(produto);
   }

   
   /*private Produto altera(@PathVariable(value = "nomeantigo") String nomeAntigo, @PathVariable(value = "produto") Produto produto, @PathVariable(value = "idLogin" ) String id) {
		System.out.println(" entrou no altera");   	   

	   
	   Login login = loginComponent.buscarId(id);
		System.out.println(" entrou no update");   	   
	   
	   return produtoComponent.update(nomeAntigo, produto, login);
   }
   */
   
}
