package com.amazon.AlmacenHilos.Thread.Synchro;

public class Almacen {
	private int paquetes;

	public Almacen(int paquetes) {
		super();
		this.paquetes = paquetes;
	}
	
	public int getPaquete() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paquetes;
	}
	
	synchronized public void sumaPaquete(int suma,String nombre) {
		System.out.println("***********");
		System.out.println("Cantidad de paquetes inicial ->"+ this.paquetes);
		this.paquetes+=suma;
		System.out.println(nombre+ " ha entregado "+suma+" paquetes");
		System.out.println("Cantidad de paquetes actual -> "+this.paquetes);
		System.out.println("***********");
	}
	
	synchronized public void restaPaquete(float cantidad, String nombre) {
		System.out.println();
		System.out.println("Cantidad de paquetes en almacén -> "+this.paquetes);
		System.out.println(nombre+" quiere recoger "+cantidad+" paquetes");
		if (this.paquetes<=0) {
			System.out.println("No quedan paquetes en el almacén");
		}else {
			if(this.paquetes<cantidad) {
				System.out.println("Cantidad de paquetes insuficientes");
			}else {
				this.paquetes-=cantidad;
				System.out.println(nombre+ " ha recogido "+cantidad+" paquetes");
				System.out.println("Cantidad de paquetes actual -> "+this.paquetes);
			}
		}
	
	}
	
}
