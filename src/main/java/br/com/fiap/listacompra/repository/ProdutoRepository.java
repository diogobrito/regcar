package br.com.fiap.listacompra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.listacompra.model.Login;
import br.com.fiap.listacompra.model.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String>{

	List<Produto> findByNome(String nome);
	List<Produto> findByLogin(Login login);
	List<Produto> findById(String id);
	

}
