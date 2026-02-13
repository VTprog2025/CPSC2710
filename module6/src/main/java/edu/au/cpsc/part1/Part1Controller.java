package edu.au.cpsc.part1;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/*
* Project 6
* Christopher Boartfield
* clb0214@auburn.edu
* 2-13-2026
* Controller for Part1 Project 6.
 */

public class Part1Controller {

    @FXML
    private TextField messageTextField, echoTextField, firstBidirectionalTextField, secondBidirectionalTextField;

    @FXML
    private ImageView secretOverlayImageView;

    @FXML
    private Slider secretSlider;

    @FXML
    private CheckBox selectMeCheckBox;

    @FXML
    private Label selectMeLabel;

    @FXML
    private TextField tweetTextField;

    @FXML
    private Label numberOfCharactersLabel, validityLabel;

    public void initialize() {

            // 1️⃣ messageTextField → echoTextField
            echoTextField.textProperty().bind(messageTextField.textProperty());

            // 2️⃣ Bi-directional binding
            secondBidirectionalTextField.textProperty().bindBidirectional(firstBidirectionalTextField.textProperty());

            // 3️⃣ secretSlider → secretOverlayImageView opacity
            secretOverlayImageView.opacityProperty().bind(secretSlider.valueProperty());

            // 4️⃣ selectMeCheckBox → selectMeLabel (true/false)
            selectMeLabel.textProperty().bind(selectMeCheckBox.selectedProperty().asString());

            // 5️⃣ Number of characters in tweetTextField → numberOfCharactersLabel
            numberOfCharactersLabel.textProperty().bind(
                    Bindings.length(tweetTextField.textProperty()).asString()
            );

            // 6️⃣ Validity: "Valid" if ≤10 chars, "Invalid" otherwise
            validityLabel.textProperty().bind(
                    Bindings.when(Bindings.length(tweetTextField.textProperty()).lessThanOrEqualTo(10))
                            .then("Valid")
                            .otherwise("Invalid")
            );
        }

        // your bindings go here
    }