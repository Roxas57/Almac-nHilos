package com.amazon.AlmacenHilos;

import java.io.IOException;
import javafx.fxml.FXML;

public class FirstController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("join");
    }
}