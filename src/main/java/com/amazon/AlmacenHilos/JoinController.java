package com.amazon.AlmacenHilos;

import java.io.IOException;
import javafx.fxml.FXML;

public class JoinController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}