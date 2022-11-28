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
import org.springframework.web.bind.annotation.RestController;

import app.curso.banco.demo.model.Mensaje;
import app.curso.banco.demo.service.MensajeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/mensaje")
public class MensajeController {
	
	@Autowired
	MensajeService mensajeService;
	
	@GetMapping()
	public ArrayList<Mensaje> obtenerMensajes2(){
		return this.mensajeService.obtenerMensajes();
	}
	@GetMapping(path="/{id}")
	public Optional<Mensaje> obtenerMensaje2(@PathVariable("id")Long id){
		return this.mensajeService.obtenerMensaje(id);
	}
	@PostMapping()
	public Mensaje guardarMensaje(@RequestBody Mensaje mensaje) {
		return this.mensajeService.guardarMensaje(mensaje);
	}
	
	@DeleteMapping( path="/{id}")
	public boolean borrarMensaje(@PathVariable("id")Long id) {
		return this.mensajeService.borrasMensaje(id);
	}
	
	//DESTINO
	@GetMapping(path="/mensajes-recibidos/{idGestor}")
	public ArrayList<Mensaje>obtenerMensajeIdDestino(@PathVariable("idGestor") Long id){
		return this.mensajeService.obtenerMensajePorIdGestor(id);
	}
	
	//origen
	@GetMapping(path="/mensaje-enviados/{idGestor}")
	public ArrayList<Mensaje>obtenerMensajeIdOrigen(@PathVariable("idGestor") Long id){
		return this.mensajeService.obtenerMensajePorIdGestor2(id);
	}
	
	
}
