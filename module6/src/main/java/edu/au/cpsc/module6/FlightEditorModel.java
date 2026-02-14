package edu.au.cpsc.module6;

import javafx.beans.property.Property;

public class FlightEditorModel {

    private final StringProperty flightDesignator = new SimpleStringProperty("");
    private final StringProperty departure = new SimpleStringProperty("");
    private final StringProperty arrival = new SimpleStringProperty("");
    private final StringProperty depTime = new SimpleStringProperty("");
    private final StringProperty arrTime = new SimpleStringProperty("");

    private final BooleanProperty newState = new SimpleBooleanProperty(true);
    private final BooleanProperty modifiedState = new SimpleBooleanProperty(false);

    private final BooleanProperty flightValid = new SimpleBooleanProperty(false);
    private final BooleanProperty depValid = new SimpleBooleanProperty(false);
    private final BooleanProperty arrValid = new SimpleBooleanProperty(false);
    private final BooleanProperty depTimeValid = new SimpleBooleanProperty(false);
    private final BooleanProperty arrTimeValid = new SimpleBooleanProperty(false);

    private final BooleanBinding allValid =
            flightValid.and(depValid)
                    .and(arrValid)
                    .and(depTimeValid)
                    .and(arrTimeValid);

    public FlightEditorModel() {
        setupValidation();
    }

    private void setupValidation() {

        flightValid.bind(flightDesignator.isNotEmpty()
                .and(flightDesignator.length().greaterThan(2)));

        depValid.bind(departure.isNotEmpty());
        arrValid.bind(arrival.isNotEmpty());

        depTimeValid.bind(Bindings.createBooleanBinding(
                () -> depTime.get().matches("\\d{2}:\\d{2}"),
                depTime));

        arrTimeValid.bind(Bindings.createBooleanBinding(
                () -> arrTime.get().matches("\\d{2}:\\d{2}"),
                arrTime));

        modifiedState.bind(
                flightDesignator.isNotEmpty()
                        .or(departure.isNotEmpty())
                        .or(arrival.isNotEmpty())
                        .or(depTime.isNotEmpty())
                        .or(arrTime.isNotEmpty())
        );
    }

    public BooleanBinding allValidProperty() {
        return allValid;
    }

    public BooleanProperty newStateProperty() {
        return newState;
    }

    public BooleanProperty modifiedStateProperty() {
        return modifiedState;
    }

    public BooleanProperty flightValidProperty() { return flightValid; }
    public BooleanProperty depValidProperty() { return depValid; }
    public BooleanProperty arrValidProperty() { return arrValid; }
    public BooleanProperty depTimeValidProperty() { return depTimeValid; }
    public BooleanProperty arrTimeValidProperty() { return arrTimeValid; }

    public Property<String> flightDesignatorProperty() { return flightDesignator; }
    public Property<String> departureProperty() { return departure; }
    public Property<String> arrivalProperty() { return arrival; }
    public Property<String> depTimeProperty() { return depTime; }
    public Property<String> arrTimeProperty() { return arrTime; }
}
