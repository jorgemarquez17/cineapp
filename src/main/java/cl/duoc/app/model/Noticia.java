package cl.duoc.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private Date fecha;
	private String detalle;
	private String estatus;
	
	public Noticia() {
		System.out.println("consuntructor  Noticia");
		this.fecha = new Date();
		this.estatus= "Activa";
		
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("Set Titutlo ");
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		System.out.println("Set Detalle");
		this.detalle = detalle;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		System.out.println("Set Status");
		this.estatus = estatus;
	}

}
