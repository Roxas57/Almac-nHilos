package com.amazon.AlmacenHilos.Thread.RecursoCompartido;

import com.amazon.AlmacenHilos.Model.Paquete;

public class Productor implements Runnable {
	private RCompartido rc;
	private Paquete paquete;
	
	public Productor(RCompartido c, Paquete paquete) {
		this.rc=c;
		this.paquete=paquete;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				rc.productor(paquete);
			} catch (InterruptedException e) {
				return;
			}catch (Exception e) {}
		}
	}
}
