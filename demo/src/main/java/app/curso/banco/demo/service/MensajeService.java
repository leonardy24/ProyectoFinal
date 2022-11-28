package app.curso.banco.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.curso.banco.demo.model.Mensaje;
import app.curso.banco.demo.repository.MensajeRepository;

	@Service
	public class MensajeService {

	@Autowired
	MensajeRepository mensajeRepository;
	
	//obtener mensajes
	public ArrayList<Mensaje> obtenerMensajes(){
		
		return(ArrayList<Mensaje>) this.mensajeRepository.findAll();
	}
	
	//obtener mensaje
	public Optional<Mensaje> obtenerMensaje(Long id){
		return this.mensajeRepository.findById(id);
	};
	
	//crear y actualiza gestores y lo devuelve con id. cuando el gestor no  existe
	//lo crea. y cuando existe lo actualiza
	public Mensaje guardarMensaje(Mensaje mensaje) {
		return this.mensajeRepository.save(mensaje);
	}
	//origenId
	public ArrayList<Mensaje> obtenerMensajePorIdGestor(Long id){
		return this.mensajeRepository.findByGestorDestinoId(id);
	};
	//destinoId
	public ArrayList<Mensaje>obtenerMensajePorIdGestor2(Long id){
		return this.mensajeRepository.findByGestorOrigenId(id);
	}
	

	public boolean borrasMensaje(Long id) {
		
		try {
			this.mensajeRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}