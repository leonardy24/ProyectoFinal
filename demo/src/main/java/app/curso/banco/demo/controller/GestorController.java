package app.curso.banco.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.curso.banco.demo.model.Gestor;
import app.curso.banco.demo.service.GestorService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/gestor")
public class GestorController {

	
	@Autowired
	GestorService gestorService;

	@GetMapping()
	public ArrayList<Gestor>obtenerGestores(){
		return this.gestorService.obtenerGestores();
	}
	@GetMapping(path="/{id}")
	public Optional<Gestor> obtenerGestor(@PathVariable("id")Long id){
		return this.gestorService.obtenerGestor(id);
	}
	
	@PostMapping()
	public Gestor guardarGestor(@RequestBody Gestor gestor) {
		return this.gestorService.guardarGestor(gestor);
	}
	
	@DeleteMapping( path="/{id}")
	public boolean borrarGestor(@PathVariable("id")Long id) {
		return this.gestorService.borrasGestor(id);
	}
	//por correo
	@GetMapping(path="/correo/{correo}")
	public Optional<Gestor> obtenerConCorreo(@PathVariable("correo")String correo){
	 return this.gestorService.obtenerConCorreo(correo);
	}
	
	//login
	@GetMapping(path="/login")
	public Optional<Gestor>obtenerPorLogin(@RequestParam("correo") String correo,@RequestParam("password") String password){
		return this.gestorService.obtenerPorLogin(correo, password);
	}
}
