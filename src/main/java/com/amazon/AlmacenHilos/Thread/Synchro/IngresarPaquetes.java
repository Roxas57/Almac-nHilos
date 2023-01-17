package com.amazon.AlmacenHilos.Thread.Synchro;

public class IngresarPaquetes extends Thread {
	private Almacen a;
	String nombre;
	int cantidad;
	
	public IngresarPaquetes(Almacen a, String nombre, int cantidad) {
		super();
		this.a = a;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	public void run() {
		a.sumaPaquete(cantidad, nombre);
	}
}
