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
 * FXML Controller class
 *
 * @author xEnde
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
    
    @FXML
    private void displayGradeAction(ActionEvent event) {
    }

    @FXML
    private void findIdAction(ActionEvent event) {
    }

    @FXML
    private void resultsInRangeAction(ActionEvent event) {
    }

    @FXML
    private void displayStatsAction(ActionEvent event) {
    }

    @FXML
    private void clearAction(ActionEvent event) {
    }

    @FXML
    private void exitAction(ActionEvent event) {
    }

}
