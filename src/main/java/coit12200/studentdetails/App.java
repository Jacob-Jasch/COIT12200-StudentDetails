package coit12200.studentdetails;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the main entry point for the JavaFX application. It sets up the stage and scene for the application.
 * 
 * @author Jacob Duckworth
 */
public class App extends Application {

    //create a scene object to display the FXML file.
    private static Scene scene;

    
    /** 
     * this method sets the scene to display the main FXML file and sets the stage to display said scene.
     * @param stage the stage to display the scene
     * @throws IOException 
     */
    @Override
    public void start(Stage stage) throws IOException {        
        FXMLLoader loader = new
                FXMLLoader(App.class.getResource("main.fxml"));
        Parent root = loader.load();
        
        // construct the DataSet and GradeAnalyser objects
        DataSet data = new DataSet();
        GradeAnalyser analyser = new GradeAnalyser(data);
        
        // get the reference to the controller object
        Controller controller = loader.getController();
        // inject the analyser into the controller
        controller.inject(analyser);
        
        // set the scene to the main FXML file
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Student Grade System");
        stage.show();
    }

    
    /** 
     * start the application by calling the launch method.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}