package com.amazon.AlmacenHilos;

import java.io.IOException;
import javafx.fxml.FXML;

public class SynchronizeController {
	
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