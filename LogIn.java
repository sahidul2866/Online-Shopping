package sample;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

class LogIn{
    private Stage window = new Stage();
    private int flag=0;
    public LogIn(){

    }
    public boolean readFromFile(TextField nameInput,PasswordField passInput) {
        try {


            FileReader fr = new FileReader("/home/sahidul/Desktop/Online Shopping/src/sample/login_input.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            while ((str = br.readLine()) != null) {
                if (passInput.getText().length()>=6 && str.equals(nameInput.getText() + "#" + passInput.getText())) {
                    return true;
                }

            }
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }
    public void login(){
        window.setTitle("Log In First");
        GridPane gridPane= new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput,1,0);

        //pass label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel,0,1);

        //pass Input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton,1,2);

        Button SignButton = new Button("Sign Up");
        GridPane.setConstraints(SignButton,2,2);
        loginButton.setOnAction(e -> {
            System.out.println(passInput.getText());

            if(readFromFile(nameInput,passInput)) {
                window.close();
                try {
                    FileWriter fw1 = new FileWriter("/home/sahidul/Desktop/Online Shopping/src/sample/currentUser.txt");
                    BufferedWriter bw1 = new BufferedWriter(fw1);
                    bw1.write(nameInput.getText() + "\n");
                    bw1.close();
                }
                catch (Exception e1){
                    e1.printStackTrace();
                }
                //store user info
            }
            else{
                Stage window1 = new Stage();
                window1.setTitle("Invalid Input");
                System.out.println("fdsfsdfsdf");
                Button bb = new Button("OK");
                Label lb = new Label("Invalid Input");
                bb.setOnAction(e1-> window1.close());

                GridPane gridPane1= new GridPane();
                gridPane1.setPadding(new Insets(50,10,10,170));
                gridPane1.setVgap(8);
                gridPane1.setHgap(10);
                gridPane1.setConstraints(lb,1,1);
                gridPane1.setConstraints(bb,1,2);
                gridPane1.getChildren().add(bb);
                Scene scene = new Scene(gridPane1,380,140);
                window1.setScene(scene);

                window1.show();
            }

        });//store in file

        SignButton.setOnAction(e->
        new Sign_Up().Sign_Up());
        gridPane.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,SignButton);

        Scene scene1=new Scene(gridPane, 380, 220);
        scene1.getStylesheets().add("tst.css");
        window.setScene(scene1);
        window.show();
    }
}