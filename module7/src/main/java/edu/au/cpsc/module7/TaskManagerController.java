package edu.au.cpsc.module7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskManagerController {

    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task, Boolean> completeColumn;
    @FXML private TableColumn<Task, String> nameColumn;
    @FXML private TableColumn<Task, String> priorityColumn;
    @FXML private TableColumn<Task, String> dueDateColumn;
    @FXML private Label statusLabel;

    private final ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        completeColumn.setCellValueFactory(cellData -> cellData.getValue().completeProperty());
        completeColumn.setCellFactory(CheckBoxTableCell.forTableColumn(completeColumn));

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priorityColumn.setCellValueFactory(cellData -> cellData.getValue().priorityProperty());
        dueDateColumn.setCellValueFactory(cellData -> cellData.getValue().dueDateProperty());

        taskTable.setItems(taskList);
        taskTable.setEditable(true);

        updateStatus();
    }

    @FXML
    private void onAddTask() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    TaskManagerApplication.class.getResource("/add-task-view.fxml"));
            Scene scene = new Scene(loader.load(), 400, 350);
            scene.getStylesheets().add(
                    TaskManagerApplication.class.getResource("styles.css").toExternalForm());

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Task");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(scene);

            AddTaskController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            dialogStage.showAndWait();

            if (controller.isSaved()) {
                taskList.add(controller.getTask());
                updateStatus();
            }
        } catch (IOException e) {
            showError("Could not open Add Task window.");
        }
    }

    @FXML
    private void onDeleteTask() {
        Task selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            taskList.remove(selected);
            updateStatus();
        } else {
            showError("Please select a task to delete.");
        }
    }

    @FXML
    private void onMarkComplete() {
        Task selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setComplete(!selected.isComplete());
            taskTable.refresh();
            updateStatus();
        } else {
            showError("Please select a task to toggle.");
        }
    }

    @FXML
    private void onClearAll() {
        if (!taskList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Clear All Tasks");
            alert.setHeaderText("Are you sure?");
            alert.setContentText("This will remove all tasks from the list.");
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    taskList.clear();
                    updateStatus();
                }
            });
        }
    }

    @FXML
    private void onExit() {
        Stage stage = (Stage) taskTable.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Task Manager");
        alert.setHeaderText("Task Manager v1.0");
        alert.setContentText(
                "A simple task management application.\n"
                        + "Built with JavaFX for CPSC 2710.\n\n"
                        + "Author: Christopher Boartfield");
        alert.showAndWait();
    }

    private void updateStatus() {
        long completed = taskList.stream().filter(Task::isComplete).count();
        statusLabel.setText("Tasks: " + taskList.size()
                + "  |  Completed: " + completed
                + "  |  Remaining: " + (taskList.size() - completed));
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}