package com.amazon.AlmacenHilos.Controller;

import java.util.ArrayList;

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
}
