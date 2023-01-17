package com.amazon.AlmacenHilos;

import java.io.IOException;
import java.util.ArrayList;

import com.amazon.AlmacenHilos.Model.Paquete;
import com.amazon.AlmacenHilos.Thread.Join;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class JoinController {
	
	@FXML
	private TextField correos;
	@FXML
	private TextField seur;
	@FXML
	private TextField mrw;
	@FXML
	private TableView<String> console;
	@FXML
	private TableColumn<String, String> imprimir;
	
	private ArrayList<String> consola;
	
	@FXML
	private void startButton(ActionEvent event) throws IOException {
        try {
        	String sCorreos = correos.getText();
        	String sSeur = seur.getText();
        	String sMrw = mrw.getText();
        	
        	int nCorreos;
        	int nSeur;
        	int nMrw;
        	
        	if (correos.getText()=="") {
        		nCorreos = 0;
        	} else {
        		nCorreos = Integer.parseInt(sCorreos);
        	}
        	if (seur.getText()=="") {
        		nSeur = 0;
        	} else {
        		nSeur = Integer.parseInt(sSeur);
        	}
        	if (mrw.getText()=="") {
        		nMrw = 0;
        	} else {
        		nMrw = Integer.parseInt(sMrw);
        	}
        	    	
        	Join hilocorreos = new Join(nCorreos,"Correos");
        	Join hiloseur = new Join(nSeur,"SEUR");
        	Join hilomrw = new Join(nMrw,"MRW");
        	
        	hilocorreos.start();
        	hiloseur.start();
        	hilomrw.start();
        	try {
        		hilocorreos.join();
        		hiloseur.join();
        		hilomrw.join();
        	}catch (InterruptedException e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
        	
        	System.out.println("--------------------------");
        	
        	//updateTable();
		} catch (Exception e) {
			// TODO: handle exception	
		}
    }
	
    @FXML
    private void switchToSearch() throws IOException {
        App.setRoot("search");
    }
    @FXML
    private void switchToSynchronize() throws IOException {
        App.setRoot("synchronize");
    }
    @FXML
    private void switchToShareResources() throws IOException {
        App.setRoot("shareresources");
    }
    
    
}