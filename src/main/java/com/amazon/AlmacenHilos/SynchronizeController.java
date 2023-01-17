package com.amazon.AlmacenHilos;

import java.io.IOException;

import com.amazon.AlmacenHilos.Thread.Synchronize;
import com.amazon.AlmacenHilos.Thread.Synchro.Almacen;
import com.amazon.AlmacenHilos.Thread.Synchro.IngresarPaquetes;
import com.amazon.AlmacenHilos.Thread.Synchro.SacarPaquetes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SynchronizeController {
	
	@FXML
	private TextField correos;
	
	@FXML
	private TextField seur;
	
	@FXML
	private void startButton(ActionEvent event) throws IOException {
		String sCorreos = correos.getText();
		int nCorreos = Integer.parseInt(sCorreos);
		
		String sSeur = seur.getText();
		int nSeur = Integer.parseInt(sSeur);
		
		Almacen almacen = new Almacen(100);
		IngresarPaquetes correos = new IngresarPaquetes(almacen, "Correos", nCorreos);
		
		SacarPaquetes seur = new SacarPaquetes(almacen, "SEUR", nSeur);
		
		correos.start();
		seur.start();
		
	}
	
	@FXML
    private void switchToJoin() throws IOException {
        App.setRoot("join");
    }
	@FXML
    private void switchToSearch() throws IOException {
        App.setRoot("search");
    }
    @FXML
    private void switchToShareResources() throws IOException {
        App.setRoot("shareresources");
    }
}