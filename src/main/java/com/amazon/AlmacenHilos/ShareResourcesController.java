package com.amazon.AlmacenHilos;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.amazon.AlmacenHilos.Controller.Almacen;
import com.amazon.AlmacenHilos.Controller.Utils;
import com.amazon.AlmacenHilos.Model.Paquete;
import com.amazon.AlmacenHilos.Model.RepoPaquete;
import com.amazon.AlmacenHilos.Thread.TrabajoCooperativo;
import com.amazon.AlmacenHilos.Thread.RecursoCompartido.Consumidor;
import com.amazon.AlmacenHilos.Thread.RecursoCompartido.Productor;
import com.amazon.AlmacenHilos.Thread.RecursoCompartido.RCompartido;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ShareResourcesController implements Initializable {

	@FXML
	private Button start;
	@FXML
	private TableView<Paquete> table;
	@FXML
	private TableColumn<Paquete, Integer> id;
	@FXML
	private TableColumn<Paquete, String> destinatario;
	@FXML
	private TableColumn<Paquete, String> localidad;
	@FXML
	private TableColumn<Paquete, Integer> peso;
	@FXML
	private TextField num;
	
	private RCompartido rc;
	private  Productor p;
	private Consumidor c ;
	

	@FXML
	private void start() {
		if(start.getText().equals("Start") && Utils.validateFormNumber(num.getText()) ) {
			start.setText("Stop");
			p = new Productor(rc,Integer.parseInt(num.getText()));
			c = new Consumidor(rc,Integer.parseInt(num.getText()));
			p.start();
			c.start();
			
			
		}else if(start.getText().equals("Stop")) {
			start.setText("Start");
			updateTable();
		}
	}
	
	
	private void updateTable() {
		ArrayList<Paquete> list = new ArrayList<Paquete>(rc.getPaquetes().values());
		ObservableList<Paquete> oList = FXCollections.observableArrayList(list);
		
		id.setCellValueFactory(Paquete -> {
			ObservableValue<Integer> a = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) a).setValue(Paquete.getValue().getId());
			return a;
			
		});
		destinatario.setCellValueFactory(Paquete -> {
			SimpleStringProperty a = new SimpleStringProperty();
			a.setValue(Paquete.getValue().getDestinatario());
			return a;
		});
		localidad.setCellValueFactory(Paquete -> {
			SimpleStringProperty a = new SimpleStringProperty();
			a.setValue(Paquete.getValue().getLocalidad());
			return a;
		});
		peso.setCellValueFactory(Paquete -> {
			ObservableValue<Integer> a = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) a).setValue(Paquete.getValue().getPeso());
			return a;
			
		});
		
		table.getItems().clear();
		table.getItems().addAll(oList);
	
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rc = new RCompartido();
		rc.loadPaquetes();
		updateTable();
	}
	
    
}