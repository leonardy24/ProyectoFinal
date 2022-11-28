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

import app.curso.banco.demo.model.Cliente;
import app.curso.banco.demo.model.Gestor;
import app.curso.banco.demo.service.ClienteService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path ="/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	@GetMapping()
	public ArrayList<Cliente> obtenerClientes(){
		return this.clienteService.obtenerClientes();
		
	}
	
	@GetMapping(path="/{id}")
	public Optional<Cliente>  obtenerCliente(@PathVariable("id")Long id){
		return this.clienteService.obtenerCliente(id);
	}
	@PostMapping()
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return this.clienteService.guardarCliente(cliente);
	}
	@DeleteMapping(path="/{id}")
	public boolean borrarCliente(@PathVariable("id")Long id) {
		return this.clienteService.borrarCliente(id);
	}
	
	//por correo
		@GetMapping(path="/correo/{correo}")
		public Optional<Cliente>obtenerConCorreo(@PathVariable("correo")String correo){
		 return this.clienteService.obtenerConCorreo(correo);
		}
		
		//por login
		@GetMapping(path="/login")
		public Optional<Cliente>obtenerPorLogin(@RequestParam("correo")String correo,@RequestParam("password") String password){
			return this.clienteService.obtenerPorLogin(correo, password);
		}
		
		
		///
		@GetMapping(path="/gestor/{idGestor}")
		public ArrayList<Cliente>obtenerPorIdGestor(@PathVariable("idGestor")Long id){
		return this.clienteService.obtenerPorIdGestor(id);	
		}
		
		
}
