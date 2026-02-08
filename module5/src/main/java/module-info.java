module edu.au.cpsc.miscstyle {
    requires javafx.controls;
    requires javafx.fxml;

    // Open packages to allow FXML to access controllers
    opens edu.au.cpsc.miscstyle to javafx.fxml;
    opens edu.au.cpsc.launcher to javafx.fxml;

    // Export packages so JavaFX can access your Application classes
    exports edu.au.cpsc.miscstyle;
    exports edu.au.cpsc.launcher;
}
