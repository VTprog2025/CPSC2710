module edu.au.cpsc.miscstyle {
    requires javafx.controls;
    requires javafx.fxml;

    // This allows the FXML loader to access the controller class and its members
    opens edu.au.cpsc.miscstyle to javafx.fxml;

    // This makes the package available to other modules if needed
    exports edu.au.cpsc.miscstyle;
}
