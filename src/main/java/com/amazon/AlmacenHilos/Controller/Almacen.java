package com.amazon.AlmacenHilos.Controller;

import java.util.ArrayList;
import java.util.List;

import com.amazon.AlmacenHilos.Model.Paquete;

public class Almacen {
	private static ArrayList<Paquete> paquetes;
	
	public Almacen(){
		paquetes= new ArrayList<Paquete>();
	}

	public static ArrayList<Paquete> getPaquetes() {
		return paquetes;
	}

	public static void addPaquetes(ArrayList<Paquete> paquetes) {
		Almacen.paquetes.addAll(paquetes);
	}
	
	public static void addPaquete(Paquete paquete) {
		Almacen.paquetes.add(paquete);
	}
	
	public static void removePaquete(Paquete paquete) {
		Almacen.paquetes.remove(paquete);
		
	}
	
	
	

}
