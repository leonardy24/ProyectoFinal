package app.curso.banco.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transferencia")
public class Transferencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private Double importe;
	private String concepto;
	@CreationTimestamp
	private Date fecha;

	@ManyToOne
	@JoinColumn(name="id_ordenante", nullable=false)
	private Cliente clienteOrdenante;
	
	@ManyToOne
	@JoinColumn(name="id_beneficiario", nullable=false)
	private Cliente clienteBeneficiario;





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getClienteOrdenante() {
		return clienteOrdenante;
	}

	public void setClienteOrdenante(Cliente clienteOrdenante) {
		this.clienteOrdenante = clienteOrdenante;
	}

	public Cliente getClienteBeneficiario() {
		return clienteBeneficiario;
	}

	public void setClienteBeneficiario(Cliente clienteBeneficiario) {
		this.clienteBeneficiario = clienteBeneficiario;
	}



	
}
