module com.amazon.AlmacenHilos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.amazon.AlmacenHilos to javafx.fxml;
    exports com.amazon.AlmacenHilos;
}
