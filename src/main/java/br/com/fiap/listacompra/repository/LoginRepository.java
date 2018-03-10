package br.com.fiap.listacompra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.listacompra.model.Login;

import java.util.List;

@Repository
public interface LoginRepository extends MongoRepository<Login, String>{

	List<Login> findByUsuario(String usuario);
	List<Login> findById(String id);
	
	
}