package com.regcar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.regcar.model.Login;
import com.regcar.model.Carro;

import java.util.List;

@Repository
public interface CarroRepository extends MongoRepository<Carro, String>{
	List<Carro> findByNome(String nome);
	List<Carro> findByLogin(Login login);
	List<Carro> findById(String id);
}
