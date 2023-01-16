package com.amazon.AlmacenHilos.Thread.RecursoCompartido;

import java.util.HashMap;

import com.amazon.AlmacenHilos.Model.Paquete;
import com.amazon.AlmacenHilos.Model.RepoPaquete;

public class RCompartido {
	private boolean disponible;
	private RepoPaquete rp;
	public RCompartido() {
		disponible = true;
		rp= RepoPaquete.getInstance();
	}
	public HashMap<Integer, Paquete> getPaquetes() {
		return rp.getPaquetesList();
	}
	
	public synchronized void productor(Paquete paquete) throws InterruptedException {
		System.out.println(paquete);
		while (!disponible) {
			wait();
		}
		rp.loadFile("Paquetes.xml");
		rp.addPaquete(paquete);
		rp.saveFile("Paquetes.xml");
		disponible = false;
		notifyAll();
	}
	
	public synchronized void consumidor(Paquete paquete) throws InterruptedException {
		while (disponible) {
			wait();
		}
		rp.loadFile("paquetes.xml");
		rp.removePaquete(paquete.getId());
		rp.saveFile("paquetes.xml");
		disponible = true;
		notifyAll();
	}
}
