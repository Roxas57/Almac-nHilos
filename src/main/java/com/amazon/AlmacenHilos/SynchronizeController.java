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
	private TextField correos1;
	
	@FXML
	private TextField correos2;
	
	@FXML
	private TextField seur1;
	
	@FXML
	private TextField seur2;
	
	@FXML
	private void startButton(ActionEvent event) throws IOException {
		String sCorreos1 = correos1.getText();
		int nCorreos1 = Integer.parseInt(sCorreos1);
		
		String sCorreos2 = correos2.getText();
		int nCorreos2 = Integer.parseInt(sCorreos2);
		
		String sSeur1 = seur1.getText();
		int nSeur1 = Integer.parseInt(sSeur1);
		
		String sSeur2 = seur2.getText();
		int nSeur2 = Integer.parseInt(sSeur2);
		
		Almacen almacen = new Almacen(100);
		IngresarPaquetes correos1 = new IngresarPaquetes(almacen, "Correos", nCorreos1);
		SacarPaquetes correos2 = new SacarPaquetes(almacen, "Correos", nCorreos2);
		
		IngresarPaquetes seur1 = new IngresarPaquetes(almacen, "SEUR", nSeur1);
		SacarPaquetes seur2 = new SacarPaquetes(almacen, "SEUR", nSeur2);
		
		correos1.start();
		seur1.start();
		correos2.start();
		seur2.start();
		
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