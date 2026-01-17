module edu.au.cpsc.module2_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.module2_1 to javafx.fxml;
    exports edu.au.cpsc.module2_1;
}