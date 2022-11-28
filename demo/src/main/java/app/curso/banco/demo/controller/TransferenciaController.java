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
import app.curso.banco.demo.model.Transferencia;
import app.curso.banco.demo.service.MensajeService;
import app.curso.banco.demo.service.TransferenciaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/transferencia")
public class TransferenciaController {
	
	@Autowired
	TransferenciaService transferenciaService;
	
	@GetMapping()
	public ArrayList<Transferencia> obtenerTransferencias2(){
		return this.transferenciaService.obtenerTransferncias();
	}
	@GetMapping(path="/{id}")
	public Optional<Transferencia> obtenerTransferencia2(@PathVariable("id")Long id){
		return this.transferenciaService.obtenerTransferencia(id);
	}
	@PostMapping()
	public Transferencia guardarTransferencia(@RequestBody Transferencia transferencia) {
		return this.transferenciaService.guardarTransferencia(transferencia);
	}
	
	@DeleteMapping( path="/{id}")
	public boolean borrarTransferencia(@PathVariable("id")Long id) {
		return this.transferenciaService.borrasTransferencia(id);
	}
}