package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Error {
    public void show()

    {
        Stage window1 = new Stage();
        window1.setTitle("Please Log In first");
        System.out.println("fdsfsdfsdf");
        Button bb = new Button("OK");
        Label lb = new Label("Invalid Input");
        bb.setOnAction(e1 -> {new LogIn().login();
        window1.close();});

        GridPane gridPane1 = new GridPane();
        gridPane1.setPadding(new Insets(50, 10, 10, 170));
        gridPane1.setVgap(8);
        gridPane1.setHgap(10);
        gridPane1.setConstraints(lb, 1, 1);
        gridPane1.setConstraints(bb, 1, 2);
        gridPane1.getChildren().add(bb);
        Scene scene = new Scene(gridPane1, 380, 140);
        window1.setScene(scene);

        window1.showAndWait();
    }
}
