package com.amazon.AlmacenHilos;

import java.io.IOException;

import com.amazon.AlmacenHilos.Thread.Join;

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
	private void startButton(ActionEvent event) throws IOException {
        try {
        	String sCorreos = correos.getText();
        	String sSeur = seur.getText();
        	String sMrw = mrw.getText();
      
        	int nCorreos = Integer.parseInt(sCorreos);
        	int nSeur = Integer.parseInt(sSeur);
        	int nMrw = Integer.parseInt(sMrw);
        	
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