module com.amazon.AlmacenHilos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.xml.bind;

    opens com.amazon.AlmacenHilos to javafx.fxml,jaxb.core,java.xml.bind;
    opens com.amazon.AlmacenHilos.Model to java.xml.bind;
    exports com.amazon.AlmacenHilos;
}
