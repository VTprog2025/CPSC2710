package edu.au.cpsc.module6;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;

/*
 * Project: project6
 * Author: Christopher
 * Auburn Email: clb0214@auburn.edu
 * Date: 2026-02-14
 * Description: Controller for the Flight Designator App. Handles table, editor, and database I/O.
 */
public class FlightScheduleController {

    private final AirlineDatabase database = new AirlineDatabase();
    private static final String DATABASE_FILE = "airlineDatabase.dat";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // Table and columns
    @FXML private TableView<ScheduledFlight> flightTable;
    @FXML private TableColumn<ScheduledFlight, String> designatorCol;
    @FXML private TableColumn<ScheduledFlight, String> departureCol;
    @FXML private TableColumn<ScheduledFlight, String> arrivalCol;
    @FXML private TableColumn<ScheduledFlight, String> depTimeCol;
    @FXML private TableColumn<ScheduledFlight, String> arrTimeCol;
    @FXML private TableColumn<ScheduledFlight, String> daysCol;

    // Editor fields
    @FXML private TextField flightField;
    @FXML private TextField depField;
    @FXML private TextField arrField;
    @FXML private TextField depTimeField;
    @FXML private TextField arrTimeField;

    // Days toggle buttons
    @FXML private ToggleButton monBtn;
    @FXML private ToggleButton tueBtn;
    @FXML private ToggleButton wedBtn;
    @FXML private ToggleButton thuBtn;
    @FXML private ToggleButton friBtn;
    @FXML private ToggleButton satBtn;
    @FXML private ToggleButton sunBtn;

    // Editor buttons
    @FXML private Button newBtn;
    @FXML private Button addUpdateBtn;
    @FXML private Button deleteBtn;

    @FXML
    public void initialize() {
        setupTable();
        setupButtons();
        loadDatabase();
    }

    private void setupTable() {
        // Bind columns to ScheduledFlight getters
        designatorCol.setCellValueFactory(new PropertyValueFactory<>("flightDesignator"));
        departureCol.setCellValueFactory(new PropertyValueFactory<>("departureAirportIdent"));
        arrivalCol.setCellValueFactory(new PropertyValueFactory<>("arrivalAirportIdent"));

        // Format LocalTime columns as HH:mm
        depTimeCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDepartureTime().format(TIME_FORMATTER))
        );
        arrTimeCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getArrivalTime().format(TIME_FORMATTER))
        );

        // Days as single-character string
        daysCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDaysString()));

        // Listen for selection changes to populate editor
        flightTable.getSelectionModel().selectedItemProperty().addListener((_, _, newSel) -> {
            if (newSel != null) populateEditor(newSel);
        });

        // Populate table initially
        flightTable.getItems().addAll(database.getScheduledFlights());
    }

    private void setupButtons() {
        newBtn.setOnAction(_ -> clearEditor());

        addUpdateBtn.setOnAction(_ -> {
            try {
                ScheduledFlight flight = readEditor();
                ScheduledFlight selected = flightTable.getSelectionModel().getSelectedItem();
                if (selected != null) {
                    database.updateScheduledFlight(flight);
                    int index = flightTable.getSelectionModel().getSelectedIndex();
                    flightTable.getItems().set(index, flight);
                } else {
                    database.addScheduledFlight(flight);
                    flightTable.getItems().add(flight);
                }
                saveDatabase();
                clearEditor();
            } catch (Exception ex) {
                showAlert("Error: " + ex.getMessage());
            }
        });

        deleteBtn.setOnAction(_ -> {
            ScheduledFlight selected = flightTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                database.removeScheduledFlight(selected);
                flightTable.getItems().remove(selected);
                saveDatabase();
                clearEditor();
            }
        });
    }

    private void populateEditor(ScheduledFlight flight) {
        flightField.setText(flight.getFlightDesignator());
        depField.setText(flight.getDepartureAirportIdent());
        arrField.setText(flight.getArrivalAirportIdent());
        depTimeField.setText(flight.getDepartureTime().format(TIME_FORMATTER));
        arrTimeField.setText(flight.getArrivalTime().format(TIME_FORMATTER));

        monBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.MONDAY));
        tueBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.TUESDAY));
        wedBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.WEDNESDAY));
        thuBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.THURSDAY));
        friBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.FRIDAY));
        satBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.SATURDAY));
        sunBtn.setSelected(flight.getDaysOfWeek().contains(DayOfWeek.SUNDAY));

        addUpdateBtn.setText("Update");
    }

    private void clearEditor() {
        flightTable.getSelectionModel().clearSelection();
        flightField.clear();
        depField.clear();
        arrField.clear();
        depTimeField.clear();
        arrTimeField.clear();

        monBtn.setSelected(false);
        tueBtn.setSelected(false);
        wedBtn.setSelected(false);
        thuBtn.setSelected(false);
        friBtn.setSelected(false);
        satBtn.setSelected(false);
        sunBtn.setSelected(false);

        addUpdateBtn.setText("Add");
    }

    private ScheduledFlight readEditor() {
        String flightDesignator = flightField.getText().trim();
        String dep = depField.getText().trim();
        String arr = arrField.getText().trim();

        if (flightDesignator.isEmpty() || dep.isEmpty() || arr.isEmpty()) {
            throw new IllegalArgumentException("Flight Designator, Departure, and Arrival cannot be empty");
        }

        LocalTime depTime;
        LocalTime arrTime;
        try {
            depTime = LocalTime.parse(depTimeField.getText().trim(), TIME_FORMATTER);
            arrTime = LocalTime.parse(arrTimeField.getText().trim(), TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Times must be in HH:mm format");
        }

        HashSet<DayOfWeek> days = new HashSet<>();
        if (monBtn.isSelected()) days.add(DayOfWeek.MONDAY);
        if (tueBtn.isSelected()) days.add(DayOfWeek.TUESDAY);
        if (wedBtn.isSelected()) days.add(DayOfWeek.WEDNESDAY);
        if (thuBtn.isSelected()) days.add(DayOfWeek.THURSDAY);
        if (friBtn.isSelected()) days.add(DayOfWeek.FRIDAY);
        if (satBtn.isSelected()) days.add(DayOfWeek.SATURDAY);
        if (sunBtn.isSelected()) days.add(DayOfWeek.SUNDAY);

        if (days.isEmpty()) {
            throw new IllegalArgumentException("At least one day of the week must be selected");
        }

        return new ScheduledFlight(flightDesignator, dep, arr, depTime, arrTime, days);
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    private void saveDatabase() {
        try (FileOutputStream fos = new FileOutputStream(DATABASE_FILE)) {
            AirlineDatabaseIO.save(database, fos);
        } catch (IOException e) {
            showAlert("Failed to save database: " + e.getMessage());
        }
    }

    private void loadDatabase() {
        try (FileInputStream fis = new FileInputStream(DATABASE_FILE)) {
            AirlineDatabase loadedDb = AirlineDatabaseIO.load(fis);
            database.getScheduledFlights().addAll(loadedDb.getScheduledFlights());
            flightTable.getItems().addAll(database.getScheduledFlights());
        } catch (Exception e) {
            System.out.println("No database found, starting with an empty database.");
        }
    }
}