package com.amazon.AlmacenHilos.Thread.RecursoCompartido;

import com.amazon.AlmacenHilos.Controller.Utils;
import com.amazon.AlmacenHilos.Model.Paquete;

public class Productor extends Thread {
	private RCompartido rc;
	private int n;
	
	public Productor(RCompartido c, int n) {
		this.rc=c;
		this.n=n;
		
	}


	@Override
	public void run() {
		int i=0;
		while (i<n) {
			try {
				rc.productor(Utils.ramdonPaquete(rc.getPaquetes()));
			} catch (InterruptedException e) {
				return;
			}catch (Exception e) {}
			i++;
		}
	}
}
