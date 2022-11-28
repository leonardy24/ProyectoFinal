package app.curso.banco.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.curso.banco.demo.model.Cliente;
import app.curso.banco.demo.repository.ClienteRepository;

@Service
public class ClienteService {

	
		@Autowired
		ClienteRepository clienteRepository;
		
		//obteniendo todos los cliente
		 public ArrayList<Cliente>obtenerClientes(){
			 
			 return(ArrayList<Cliente>) this.clienteRepository.findAll();
			 
			 
		 }
		//obtener un gestor
		 public Optional<Cliente>obtenerCliente(Long id){
			 
			 return this.clienteRepository.findById(id);
		 }
		
		//crear y actualiza gestores y lo devuelve con id. cuando el gestor no  existe
			//lo crea. y cuando existe lo actualiza
		 public Cliente guardarCliente(Cliente cliente){
			 
			 return this.clienteRepository.save(cliente);
		 }
		 //eliminar cliente
		 
		 public boolean borrarCliente(Long id) {
			
			 try {
					this.clienteRepository.deleteById(id);
					return true;
				}catch(Exception e) {
					e.printStackTrace();
					return false;
				}
		 }
		 //por correo 
		 public Optional<Cliente>obtenerConCorreo(String correo){
			 return this.clienteRepository.findByCorreo(correo);
		 }
		 //por login
		 public Optional<Cliente>obtenerPorLogin(String correo, String password){
			 return this.clienteRepository.findByCorreoAndPassword(correo, password);
		 }
		 
		 //obtener mis clientes por Id
		 public ArrayList<Cliente> obtenerPorIdGestor(Long id){
			 return this.clienteRepository.findByGestorId(id);
		 }
}

