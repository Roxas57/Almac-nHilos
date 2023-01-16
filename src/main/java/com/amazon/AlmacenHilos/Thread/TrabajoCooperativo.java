package com.amazon.AlmacenHilos.Thread;

import java.util.ArrayList;

import com.amazon.AlmacenHilos.Controller.Utils;
import com.amazon.AlmacenHilos.Model.Paquete;

public class TrabajoCooperativo extends Thread {
	private String type;
	private String value;
	private ArrayList<Paquete> paquetes;
	private ArrayList<Paquete> paquetesEncontrados;

	public TrabajoCooperativo(String name, String type, String value, ArrayList<Paquete> paquetes) {
		super(name);
		this.type = type;
		this.value = value;
		this.paquetes = paquetes;
		this.paquetesEncontrados = new ArrayList<Paquete>();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(ArrayList<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public ArrayList<Paquete> getPaquetesEncontrados() {
		return paquetesEncontrados;
	}

	public void setPaquetesEncontrados(ArrayList<Paquete> paquetesEncontrados) {
		this.paquetesEncontrados = paquetesEncontrados;
	}

	public void run() {
		for (int i = 0; i < paquetes.size(); i++) {
			if (type.equals("Peso")) {
				if (paquetes.get(i).getPeso() == Utils.parseInt(value) && Utils.parseInt(value) != -1) {
					paquetesEncontrados.add(paquetes.get(i));
				}
			} else if (type.equals("Localidad")) {
				if (paquetes.get(i).getLocalidad().equals(value)) {
					paquetesEncontrados.add(paquetes.get(i));
				}
			} else if (type.equals("Destinatario")) {
				if (paquetes.get(i).getDestinatario().equals(value)) {
					paquetesEncontrados.add(paquetes.get(i));
				}
			}
		}

	}

}
