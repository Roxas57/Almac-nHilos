package com.amazon.AlmacenHilos.Thread.Synchro;

public class SacarPaquetes extends Thread{
	private Almacen a;
	String nombre;
	int cantidad;
	
	public SacarPaquetes(Almacen a, String nombre, int cantidad) {
		super();
		this.a = a;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public void run() {
		a.restaPaquete(cantidad, nombre);
	}
}
