package app.curso.banco.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gestor")
public class Gestor {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private Long id;
		private String usuario;
		private String password;
		private String correo;
		private String imagenUrl;
		


		public String getImagenUrl() {
			return imagenUrl;
		}




		public void setImagenUrl(String imagenUrl) {
			this.imagenUrl = imagenUrl;
		}




		public Gestor() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getUsuario() {
			return usuario;
		}


		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getCorreo() {
			return correo;
		}


		public void setCorreo(String correo) {
			this.correo = correo;
		}


	

}