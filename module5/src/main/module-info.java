module edu.au.cpsc.launcher {
    requires javafx.controls;
    requires javafx.fxml;

    // Allow FXML loaders to access controllers in both packages
    opens edu.au.cpsc.launcher to javafx.fxml;
    opens edu.au.cpsc.miscstyle to javafx.fxml;

    // Export packages if needed (usually just for external modules)
    exports edu.au.cpsc.launcher;
    exports edu.au.cpsc.miscstyle;
}
