package com.amazon.AlmacenHilos.Thread;

public class Join extends Thread{

	private int n;

	public Join(int n, String name) {
		super(name);
		this.n = n;
	}
	
	public void run() {
		for (int i = 1; i <= n; i++) {
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
