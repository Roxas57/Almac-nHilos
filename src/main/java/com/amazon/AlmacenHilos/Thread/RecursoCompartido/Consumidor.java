package com.amazon.AlmacenHilos.Thread.RecursoCompartido;

import com.amazon.AlmacenHilos.Controller.Almacen;
import com.amazon.AlmacenHilos.Controller.Utils;
import com.amazon.AlmacenHilos.Model.Paquete;

public class Consumidor implements Runnable {

	private RCompartido rc;
	
	public Consumidor(RCompartido c) {
		this.rc=c;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				int id = Utils.ramdonNumber(rc.getPaquetes().size());
				rc.consumidor(new Paquete(id, null, null, 0));
			} catch (InterruptedException e) {
				return;
			}catch (Exception e) {}
		}
	}

}
