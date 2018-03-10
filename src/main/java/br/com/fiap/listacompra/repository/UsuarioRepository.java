package br.com.fiap.listacompra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.listacompra.model.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

	List<Usuario> findByUsuario(String usuario);
	
}
