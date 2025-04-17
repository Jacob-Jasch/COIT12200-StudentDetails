/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coit12200.studentdetails;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * This class is the controller for the main FXML file. It handles the actions of the buttons and the text area.
 * It also initializes the data set and displays the data in the text area.
 * 
 * @author Jacob Duckworth
 */
public class MainController implements Initializable {


    @FXML
    private TextArea txaOutput;
    @FXML
    private Button btnDisplayGrades;
    @FXML
    private Button btnFindID;
    @FXML
    private Button btnMarkRange;
    @FXML
    private Button btnStats;
    @FXML
    private TextField txtStudentId;
    @FXML
    private TextField txtMarkLow;
    @FXML
    private TextField txtMarkHigh;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnExit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    /** 
     * @param event
     */
    @FXML
    private void displayGradeAction(ActionEvent event) {
        txaOutput.appendText("You clicked the Display Grades button\n");
    }

    
    /** 
     * @param event
     */
    @FXML
    private void findIdAction(ActionEvent event) {
        txaOutput.appendText("You clicked the Find ID button\n");
    }

    
    /** 
     * @param event
     */
    @FXML
    private void resultsInRangeAction(ActionEvent event) {
        txaOutput.appendText("You clicked the Mark Range button\n");
    }

    
    /** 
     * @param event
     */
    @FXML
    private void displayStatsAction(ActionEvent event) {
        txaOutput.appendText("You clicked the Stats button\n");
    }

    
    /** 
     * @param event
     * A method to clear the text area
     */
    @FXML
    private void clearAction(ActionEvent event) {
        txaOutput.clear();
        txtMarkHigh.clear();
        txtMarkLow.clear();
        txtStudentId.clear();
    }

    
    /** 
     * @param event
     * A method to exit the program
     */
    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }

}
