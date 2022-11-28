package app.curso.banco.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.curso.banco.demo.model.Transferencia;
import app.curso.banco.demo.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	//obtener transferencias
	public ArrayList<Transferencia> obtenerTransferncias(){
		
		return(ArrayList<Transferencia>)this.transferenciaRepository.findAll();
	}
	
	//obtener transferencia
	public Optional<Transferencia> obtenerTransferencia(Long id){
		return this.transferenciaRepository.findById(id);
	};
	
	//crear y actualiza gestores y lo devuelve con id. cuando el gestor no  existe
	//lo crea. y cuando existe lo actualiza
	public Transferencia guardarTransferencia(Transferencia transferencia) {
		return this.transferenciaRepository.save(transferencia);
	}

	public boolean borrasTransferencia(Long id) {
		
		try {
			this.transferenciaRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
}
