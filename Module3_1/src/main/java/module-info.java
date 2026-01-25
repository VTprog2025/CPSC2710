module edu.au.cpsc.module3_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens edu.au.cpsc.module3_1 to javafx.fxml;
    exports edu.au.cpsc.module3_1;
}