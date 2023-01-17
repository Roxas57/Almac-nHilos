package com.amazon.AlmacenHilos.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.amazon.AlmacenHilos.Model.Paquete;

public class Utils {
	public static int parseInt(String a) {
		int n=-1;
		try {
			n = Integer.parseInt(a);
		} catch (Exception e) {
			n=-1;
		}
		return n;
	}
	
	public static ArrayList<Paquete> divideArray(int i,int n,ArrayList<Paquete> paquetes){
		ArrayList<Paquete> result= new ArrayList<Paquete>();
		for(;i<n;i++) {
			result.add(paquetes.get(i));
		}
		return result;
	}
	
	public static int ramdonNumber(int max) {
		return (int) (Math.random()*max+0);
	}
	
	public static Paquete ramdonPaquete(HashMap<Integer, Paquete> ex) {
		ArrayList<String> destinatario= new ArrayList<String>();
		destinatario.add("Pedro");
		destinatario.add("Isabel");
		destinatario.add("Alex");
		destinatario.add("Juanma");
		destinatario.add("Alfonso");
		ArrayList<String> localidad= new ArrayList<String>();
		localidad.add("Madrid");
		localidad.add("Barcelona");
		localidad.add("valencia");
		localidad.add("Sevilla");
		localidad.add("Cordoba");
		int id=-1;
		if(!ex.isEmpty()) {
			for(int i=0;i<ex.size();i++) {
				if(ex.get(i)==null) {
					id=i;
				}
			}
			if(id==-1) {
				id=ex.size()+1;
			}
		}else {
			id=0;
		}
		return new Paquete(id,destinatario.get(ramdonNumber(destinatario.size())),localidad.get(ramdonNumber(localidad.size())),ramdonNumber(50));
	}
	
	public static boolean validateFormNumber(String num) {
		int n =-1;
		try {
			n = Integer.parseInt(num);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(n>0 && n<=500) {
			return true;
		}else {
			return false;
		}
		
	}
}
