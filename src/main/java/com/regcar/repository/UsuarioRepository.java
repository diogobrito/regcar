package com.regcar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.regcar.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	List<Usuario> findByUsuario(String usuario);
}
