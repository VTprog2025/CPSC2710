module edu.au.cpsc.module {
    requires javafx.controls;
    requires javafx.fxml;

    exports edu.au.cpsc.part1;
    exports edu.au.cpsc.module6;

    opens edu.au.cpsc.part1 to javafx.fxml;
    opens edu.au.cpsc.module6 to javafx.fxml;
}
