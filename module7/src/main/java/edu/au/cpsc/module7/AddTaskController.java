package edu.au.cpsc.module7;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddTaskController {

    @FXML private TextField nameField;
    @FXML private TextArea descriptionArea;
    @FXML private ComboBox<String> priorityBox;
    @FXML private DatePicker dueDatePicker;
    @FXML private Label errorLabel;

    private Stage dialogStage;
    private boolean saved = false;
    private Task task;

    @FXML
    public void initialize() {
        priorityBox.setItems(FXCollections.observableArrayList("Low", "Medium", "High"));
        priorityBox.setValue("Medium");
        dueDatePicker.setValue(LocalDate.now());
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isSaved() {
        return saved;
    }

    public Task getTask() {
        return task;
    }

    @FXML
    private void onSave() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            errorLabel.setText("Task name cannot be empty.");
            return;
        }

        String description = descriptionArea.getText().trim();
        String priority = priorityBox.getValue();
        String dueDate = dueDatePicker.getValue() != null
                ? dueDatePicker.getValue().toString() : "";

        task = new Task(name, description, priority, dueDate);
        saved = true;
        dialogStage.close();
    }

    @FXML
    private void onCancel() {
        dialogStage.close();
    }
}