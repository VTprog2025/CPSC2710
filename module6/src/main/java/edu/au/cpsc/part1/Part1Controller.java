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
        // your bindings go here
    }
}