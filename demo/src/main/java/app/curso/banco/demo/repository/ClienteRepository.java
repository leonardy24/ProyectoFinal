package app.curso.banco.demo.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.curso.banco.demo.model.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long>{
	
	public Optional<Cliente>findByCorreo(String correo);
	
	public Optional<Cliente>findByCorreoAndPassword(String correo, String password);
	
	public ArrayList<Cliente>findByGestorId(Long id);
}