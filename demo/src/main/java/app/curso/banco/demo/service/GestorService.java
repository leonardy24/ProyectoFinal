package app.curso.banco.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.curso.banco.demo.model.Gestor;
import app.curso.banco.demo.repository.GestorRepository;

@Service
public class GestorService {

	@Autowired
	GestorRepository gestorRespository;

	//obtener todos los gestores
	public ArrayList<Gestor>obtenerGestores(){
		
		return(ArrayList<Gestor>) this.gestorRespository.findAll();
	}
	//obtener un gestor
	public Optional<Gestor> obtenerGestor(Long id) {
		
		return this.gestorRespository.findById(id);
	}
	//crear y actualiza gestores y lo devuelve con id. cuando el gestor no  existe
	//lo crea. y cuando existe lo actualiza
	public Gestor guardarGestor(Gestor gestor) {
		
		return this.gestorRespository.save(gestor);
		
	}
	
	
	public boolean borrasGestor(Long id) {
	
		try {
			this.gestorRespository.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	//por correo
	public Optional<Gestor> obtenerConCorreo(String correo){
		return this.gestorRespository.findByCorreo(correo);
	}
	
	//por login
	public Optional <Gestor> obtenerPorLogin(String correo, String password){
		return this.gestorRespository.findByCorreoAndPassword(correo, password);
	}
}
