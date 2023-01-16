package com.amazon.AlmacenHilos.Model;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Producto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Paquete implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@XmlAttribute(name = "id")
	private int id;
	private String destinatario;
	private String localidad;
	private int peso;
	public Paquete(int id, String destinatario, String localidad, int peso) {
		super();
		this.id = id;
		this.destinatario = destinatario;
		this.localidad = localidad;
		this.peso = peso;
	}
	public Paquete() {
		this.id = -1;
		this.destinatario = "";
		this.localidad = "";
		this.peso = -1;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	@Override
	public String toString() {
		return "Paquete [id=" + id + ", destinatario=" + destinatario + ", localidad=" + localidad + ", peso=" + peso
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		return id == other.id;
	}	
	
}
