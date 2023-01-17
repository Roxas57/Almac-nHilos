package com.amazon.AlmacenHilos.Thread;

import java.util.ArrayList;

public class Join extends Thread{

	private int n;
	
	private ArrayList<String> mensajes;

	public Join(int n, String name) {
		super(name);
		this.n = n;
		mensajes = new ArrayList<String>();
	}
	
	public ArrayList<String> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList<String> mensajes) {
		this.mensajes = mensajes;
	}
	
	public void run() {
		for (int i = 1; i <= n; i++) {
			String mensaje = this.getName()+" ha recibido el paquete: "+i;
			this.mensajes.add(mensaje);
			System.out.println(this.getName()+" ha recibido el paquete: "+i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}	
		}
	}
	
}
