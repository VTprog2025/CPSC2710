package edu.au.cpsc.module2_1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class SeatReservationApplication extends Application {

    private SeatReservation seatReservation;

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField flightDesignatorField;
    private DatePicker flightDatePicker;
    private TextField numberOfBagsField;
    private CheckBox flyingWithInfantCheckBox;
    private CheckBox flyingWithInsuranceCheckBox;
    private TextField numberOfPassengersField;

    @Override
    public void start(Stage primaryStage) {

        seatReservation = new SeatReservation();
        seatReservation.setFirstName("Christopher");
        seatReservation.setLastName("Boartfield");
        seatReservation.setFlightDate(LocalDate.now().plusDays(3));
        seatReservation.setNumberOfBags(1);
        seatReservation.makeNotFlyingWithInfant();
        seatReservation.makeFlyingWithTravelInsurance();

        firstNameField = new TextField();
        lastNameField = new TextField();
        flightDesignatorField = new TextField();
        flightDatePicker = new DatePicker();
        numberOfBagsField = new TextField();
        flyingWithInfantCheckBox = new CheckBox();
        flyingWithInsuranceCheckBox = new CheckBox();
        numberOfPassengersField = new TextField("1");
        numberOfPassengersField.setEditable(false);

        flyingWithInfantCheckBox.setOnAction(e -> {
            if (flyingWithInfantCheckBox.isSelected()) {
                numberOfPassengersField.setText("2");
            } else {
                numberOfPassengersField.setText("1");
            }
        });

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);

        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(new Label("Flight Designator:"), 0, 2);
        grid.add(flightDesignatorField, 1, 2);
        grid.add(new Label("Flight Date:"), 0, 3);
        grid.add(flightDatePicker, 1, 3);
        grid.add(new Label("Number of Bags:"), 0, 4);
        grid.add(numberOfBagsField, 1, 4);
        grid.add(new Label("Flying With Infant:"), 0, 5);
        grid.add(flyingWithInfantCheckBox, 1, 5);
        grid.add(new Label("Travel Insurance:"), 0, 6);
        grid.add(flyingWithInsuranceCheckBox, 1, 6);
        grid.add(new Label("Number of Passengers:"), 0, 7);
        grid.add(numberOfPassengersField, 1, 7);

        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        HBox buttonBox = new HBox(5, cancelButton, saveButton);

        VBox root = new VBox(10, buttonBox, grid);

        saveButton.setOnAction(e -> {
            try {
                int bags = Integer.parseInt(numberOfBagsField.getText());

                seatReservation.setFirstName(firstNameField.getText());
                seatReservation.setLastName(lastNameField.getText());
                seatReservation.setFlightDesignator(flightDesignatorField.getText());
                seatReservation.setFlightDate(flightDatePicker.getValue());
                seatReservation.setNumberOfBags(bags);

                if (flyingWithInfantCheckBox.isSelected()) {
                    seatReservation.makeFlyingWithInfant();
                } else {
                    seatReservation.makeNotFlyingWithInfant();
                }

                if (flyingWithInsuranceCheckBox.isSelected()) {
                    seatReservation.makeFlyingWithTravelInsurance();
                } else {
                    seatReservation.makeNotFlyingWithTravelInsurance();
                }

                System.out.println(seatReservation);
                Platform.exit();

            } catch (NumberFormatException ex) {
                System.out.println("Error: Number of Bags must be a number.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });

        cancelButton.setOnAction(e -> {
            System.out.println("Cancel clicked");
            Platform.exit();
        });

        updateUI();

        Scene scene = new Scene(root, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle(seatReservation.getFirstName() + " " + seatReservation.getLastName() + "'s Seat Reservation App");
        primaryStage.show();
    }

    private void updateUI() {
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        flightDatePicker.setValue(seatReservation.getFlightDate());
        numberOfBagsField.setText(String.valueOf(seatReservation.getNumberOfBags()));
        flyingWithInfantCheckBox.setSelected(seatReservation.isFlyingWithInfant());
        flyingWithInsuranceCheckBox.setSelected(seatReservation.hasTravelInsurance());

        if (seatReservation.isFlyingWithInfant()) {
            numberOfPassengersField.setText("2");
        } else {
            numberOfPassengersField.setText("1");
        }
    }

    static void main(String[] args) {
        launch(args);
    }
}