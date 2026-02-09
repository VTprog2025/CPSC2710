module edu.au.cpsc.launcher {
    requires javafx.controls;
    requires javafx.fxml;

    // Allow FXML loader to access controllers in this module
    opens edu.au.cpsc.launcher to javafx.fxml;

    // Export the package if other modules need to access your Application classes
    exports edu.au.cpsc.launcher;
}
