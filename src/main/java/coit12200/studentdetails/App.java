package coit12200.studentdetails;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * 
 * @author Jacob Duckworth
 */
public class App extends Application {

    //create a scene object to display the FXML file.
    private static Scene scene;

    
    /** 
     * @param stage
     * @throws IOException
     * this method sets the scene to display the main FXML file and sets the stage to display said scene.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main"), 700, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Student Grade System");
        stage.show();
    }

    
    /** 
     * @param fxml
     * @throws IOException
     * this method sets the scene to display the FXML file that is passed in.
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    
    /** 
     * @param fxml
     * @return Parent
     * @throws IOException
     *this method loads the FXML file and returns the Parent object.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    
    /** 
     * @param args
     * 
     * start the application by calling the launch method.
     */
    public static void main(String[] args) {
        launch();
    }

}