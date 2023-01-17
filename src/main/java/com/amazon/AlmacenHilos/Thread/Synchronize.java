package com.amazon.AlmacenHilos.Thread;

import java.util.Iterator;

public class Synchronize extends Thread {
	
	private static int n = 0;

	public Synchronize(int n, String name) {
		super(name);
		this.n = n;
	}
	
	public void run() {
		syncmethod(this.getName());
	}
	
	synchronized static void syncmethod(String name) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(name+" "+ n); n++;
		}
	}
}