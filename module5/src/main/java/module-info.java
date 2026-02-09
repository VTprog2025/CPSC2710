module edu.au.cpsc.launcher{
    requires javafx.controls;
    requires javafx.fxml;

    // Allow FXML loader to access controllers in these packages
    opens edu.au.cpsc.launcher to javafx.fxml;
    opens edu.au.cpsc.miscstyle to javafx.fxml;

    // Export packages so other modules can access them
    exports edu.au.cpsc.launcher;
    exports edu.au.cpsc.miscstyle;
}
