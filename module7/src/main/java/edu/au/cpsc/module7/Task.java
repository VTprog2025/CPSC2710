package edu.au.cpsc.module7;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public StringProperty nameProperty() { return name; }

    public String getDescription() { return description.get(); }
    public void setDescription(String description) { this.description.set(description); }
    public StringProperty descriptionProperty() { return description; }

    public String getPriority() { return priority.get(); }
    public void setPriority(String priority) { this.priority.set(priority); }
    public StringProperty priorityProperty() { return priority; }

    public String getDueDate() { return dueDate.get(); }
    public void setDueDate(String dueDate) { this.dueDate.set(dueDate); }
    public StringProperty dueDateProperty() { return dueDate; }

    public boolean isComplete() { return complete.get(); }
    public void setComplete(boolean complete) { this.complete.set(complete); }
    public BooleanProperty completeProperty() { return complete; }
}