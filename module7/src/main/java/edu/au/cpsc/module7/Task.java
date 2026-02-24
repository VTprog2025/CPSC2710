package edu.au.cpsc.module7;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
* CPSC 2710 Final Project
* Christopher Boartfield
* 2-25-2026
* A task manager program to help the user remember and complete tasks.
 */

public class Task {
    private final StringProperty name;
    private final StringProperty description;
    private final StringProperty priority;
    private final StringProperty dueDate;
    private final BooleanProperty complete;

    public Task(String name, String description, String priority, String dueDate) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.priority = new SimpleStringProperty(priority);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.complete = new SimpleBooleanProperty(false);
    }

    // Property methods — used by TableView column bindings
    public StringProperty nameProperty() { return name; }
    public StringProperty descriptionProperty() { return description; }
    public StringProperty priorityProperty() { return priority; }
    public StringProperty dueDateProperty() { return dueDate; }
    public BooleanProperty completeProperty() { return complete; }

    // Only the getter/setters that are actually called in code
    public boolean isComplete() { return complete.get(); }
    public void setComplete(boolean complete) { this.complete.set(complete); }
}