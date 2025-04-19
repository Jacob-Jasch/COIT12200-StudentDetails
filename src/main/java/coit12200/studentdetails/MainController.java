package coit12200.studentdetails;

import java.net.URL;
import java.util.ResourceBundle;

import coit12200.studentdetails.GradeAnalyser.RangeValidation;
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

    /** The text area to display the output */
    @FXML
    private TextArea txaOutput;
    /** The button to display the grades */
    @FXML
    private Button btnDisplayGrades;
    /** The button to display the grades */
    @FXML
    private Button btnFindID;
    /** The button to display the grades in a range */
    @FXML
    private Button btnMarkRange;
    /** The button to display the statistics */
    @FXML
    private Button btnStats;
    /** The text field to enter the student ID */
    @FXML
    private TextField txtStudentId;
    /** The text field to enter the lower mark */
    @FXML
    private TextField txtMarkLow;
    /** The text field to enter the upper mark */
    @FXML
    private TextField txtMarkHigh;
    /** The button to clear the text area and text fields */
    @FXML
    private Button btnClear;
    /** The button to exit the application */
    @FXML
    private Button btnExit;
    private GradeAnalyser gradeAnalyser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txaOutput.setText("Welcome to the Student Grade System\n");
    }    
    
    
    /** 
     * A method to display the grades of the students in the text area.
     * It gets the ordered list of students from the GradeAnalyser class and displays their details in the text area.
     * 
     * @param event the event that triggered the action
     */
    @FXML
    private void displayGradeAction(ActionEvent event) {
        txaOutput.clear(); 
        if (gradeAnalyser.getOrderedList() == null) {
            txaOutput.setText("Error: No data.\n");
            return;
        }
    
        for (int i = 0; i < gradeAnalyser.getOrderedList().size(); i++) {
            Student student = gradeAnalyser.getOrderedList().get(i);
            txaOutput.appendText(student.toString() + "\n");
        }
    }

    
    /** 
     * A method to find a student by their ID and display their details in the text area.
     * It gets the ID from the text field and calls the Find method in the GradeAnalyser class.
     * @param event the event that triggered the action
     * 
     */
    @FXML
    private void findIdAction(ActionEvent event) {       
        String id = txtStudentId.getText().trim().toUpperCase();
        
        if (id.isEmpty()) {
            txaOutput.setText("Please enter a Student ID.\n");
            return;
        }

        Student student = gradeAnalyser.find(id);
        if (student != null) {
            clearAction(event);
            txaOutput.setText(student.toString() + "\n");
        } else {
            txaOutput.setText("Student with ID " + id + " not found.\n");
        }
    }

    
    /** 
     * A method to display the students in a range of marks.
     * It gets the lower and upper marks from the text fields and calls the GetStudentRecordInRange method in the GradeAnalyser class.
     * 
     * @param event the event that triggered the action
     */
    @FXML
    private void resultsInRangeAction(ActionEvent event) {
        String lowerMark = txtMarkLow.getText().trim();
        String upperMark = txtMarkHigh.getText().trim();

        // Validate the range
        RangeValidation validation = gradeAnalyser.ValidateRanges(lowerMark, upperMark);
        if (!validation.result()) {
            txaOutput.setText(validation.message());
            return;
        }

        int lower = validation.range().lower();
        int upper = validation.range().upper();

        Student[] studentsInRange = gradeAnalyser.GetStudentRecordInRange(lower, upper);

        clearAction(event);
        if (studentsInRange.length == 0) {
            txaOutput.setText("No students found in the specified range.");
        } else {
            for (Student student : studentsInRange) {
                txaOutput.appendText(student.toString() + "\n");
            }
        }
    }

    
    /**
     * A method to display the statistics of the students.
     * It calls the medianMark, averageMark, maximum and minimum methods in the GradeAnalyser class and displays the results in the text area. 
     * 
     * @param event the event that triggered the action
     */
    @FXML
    private void displayStatsAction(ActionEvent event) {
        try {
            clearAction(event);
    
            double average = gradeAnalyser.averageMark();
            double median = gradeAnalyser.medianMark();
            int maximum = gradeAnalyser.Maximum();
            int minimum = gradeAnalyser.Minimum();

            txaOutput.setText("Class Statistics\n");
            txaOutput.appendText("---------------------\n");
            txaOutput.appendText("Average Mark = " + average + "\n");
            txaOutput.appendText("Median Mark  = " + median + "\n");
            txaOutput.appendText("Highest Mark = " + maximum + "\n");
            txaOutput.appendText("Lowest Mark  = " + minimum + "\n");
    
        } catch (EmptyListException e) {
            txaOutput.setText("There are no students in the list.\n");
        }
    }

    
    /** 
     * A method to clear the text area and the text fields.
     * It clears the text area and the text fields for student ID, lower mark and upper mark.
     * 
     * @param event the event that triggered the action
     */
    @FXML
    private void clearAction(ActionEvent event) {
        txaOutput.clear();
        txtMarkHigh.clear();
        txtMarkLow.clear();
        txtStudentId.clear();
    }

    
    /** 
     * A method to exit the application.
     * It closes the application when the exit button is clicked.
     * 
     * @param event the event that triggered the action
     */
    @FXML
    private void exitAction(ActionEvent event) {
        System.exit(0);
    }

    /**
     * This method injects the GradeAnalyser object into the controller.
     * 
     * @param gradeAnalyser The GradeAnalyser object to be injected
     */
    public void inject(GradeAnalyser gradeAnalyser) {
        this.gradeAnalyser = gradeAnalyser;
    }

}
