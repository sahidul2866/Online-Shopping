package sample;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static javafx.application.Application.launch;

public class Main extends Application{
    Stage window;
    Scene scene1,scene2;
    public void start(Stage primaryStage) throws Exception{

        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                Thread.sleep(2000);
                return null ;
            }
        };
        task.setOnSucceeded(event -> {
        });
        HOMEPage b=new HOMEPage(primaryStage);
        b.start();
        new Thread(task).run();
    }
    public static void main(String[] args) {
        try {
            FileWriter fw1 = new FileWriter("/home/sahidul/Desktop/Online Shopping/src/sample/currentUser.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write( "\n");
            bw1.close();


        }
        catch (Exception e1){
            e1.printStackTrace();
        }
        launch(args);
    }
}
