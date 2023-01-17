package com.amazon.AlmacenHilos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.amazon.AlmacenHilos.Controller.Almacen;
import com.amazon.AlmacenHilos.Controller.Utils;
import com.amazon.AlmacenHilos.Model.Paquete;
import com.amazon.AlmacenHilos.Thread.TrabajoCooperativo;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SearchController implements Initializable {

	@FXML
	private ChoiceBox<String> type;
	@FXML
	private TextField value;
	@FXML
	private Button search;
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
	
	private ArrayList<Paquete> result;
	
	
	@FXML
	private void search() {
		ArrayList<Paquete> paquetes = Almacen.getPaquetes();
		ArrayList<Paquete> pac1;
		ArrayList<Paquete> pac2;
		ArrayList<Paquete> pac3;
		if(paquetes.size()>=3) {
			if(paquetes.size()%3==0) {
				int n= paquetes.size()/3;
				pac1= Utils.divideArray(0, n, paquetes);
				pac2= Utils.divideArray(n, n*2, paquetes);
				pac3= Utils.divideArray(n*2, n*3, paquetes);
			}else if(paquetes.size()%3==1) {
				int n= paquetes.size()/3;
				pac1= Utils.divideArray(0, n, paquetes);
				pac2= Utils.divideArray(n, n*2, paquetes);
				pac3= Utils.divideArray(n*2, n*3+1, paquetes);
			}else {
				int n= paquetes.size()/3;
				pac1= Utils.divideArray(0, n, paquetes);
				pac2= Utils.divideArray(n, n*2+1, paquetes);
				pac3= Utils.divideArray(n*2+1, n*3+1, paquetes);
			}
			TrabajoCooperativo t1= new TrabajoCooperativo("hilo 1",this.type.getValue() ,this.value.getText(), pac1);
			TrabajoCooperativo t2= new TrabajoCooperativo("hilo 2",this.type.getValue() ,this.value.getText(), pac2);
			TrabajoCooperativo t3= new TrabajoCooperativo("hilo 3",this.type.getValue() ,this.value.getText(), pac3);
			t1.run();
			t2.run();
			t3.run();
			
			ArrayList<Paquete> total= new ArrayList<Paquete>();
			total.addAll(t1.getPaquetesEncontrados());
			total.addAll(t2.getPaquetesEncontrados());
			total.addAll(t3.getPaquetesEncontrados());
			this.result=total;
			updateTable();
			
		}
	}
	
	@FXML
	private void updateTable() {
		ObservableList<Paquete> oList = FXCollections.observableArrayList(this.result);
		
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
		type.setValue("Peso");
		String[] sub = {"Destinatario","Localidad","Peso"};
		type.getItems().addAll(sub);
		//paquetes a fuego
		Almacen al = new Almacen();
		Almacen.addPaquete(new Paquete(1, "Manolo", "Madrid", 5));
		Almacen.addPaquete(new Paquete(2, "Juan", "Barcelona", 5));
		Almacen.addPaquete(new Paquete(3, "Juan", "Madrid", 2));
		Almacen.addPaquete(new Paquete(4, "Juan", "Madrid", 5));
		Almacen.addPaquete(new Paquete(5, "Maria", "Barcelona", 0));
		Almacen.addPaquete(new Paquete(6, "Madrid", "", 1));
	}
	
	 @FXML
	    private void switchToJoin() throws IOException {
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