package com.amazon.AlmacenHilos.Thread.RecursoCompartido;

import com.amazon.AlmacenHilos.Controller.Almacen;
import com.amazon.AlmacenHilos.Controller.Utils;
import com.amazon.AlmacenHilos.Model.Paquete;

public class Consumidor extends Thread  {

	private RCompartido rc;
	
	private int n;
	
	public Consumidor(RCompartido c,int n) {
		this.rc=c;
		this.n=n;
	}
	
	@Override
	public void run() {
		int i=0;
		while (i<n) {
			try {
				int id = Utils.ramdonNumber(rc.getPaquetes().size());
				rc.consumidor(new Paquete(id, null, null, 0));
			} catch (InterruptedException e) {
				return;
			}catch (Exception e) {}
			i++;
		}
	}

}
