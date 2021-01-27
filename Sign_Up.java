package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;

public class Sign_Up {
    Stage window = new Stage();


    public boolean validation(TextField nameInput,TextField EmailInput, PasswordField passInput,PasswordField ConpassInput,TextField PhonNoInput,TextField AddressInput) {
        if(nameInput.getText().equals(null)||EmailInput.getText().equals(null)||passInput.getText().equals(null)||PhonNoInput.getText().equals(null)||AddressInput.getText().equals(null))
            return false;
        if(!passInput.getText().equals(ConpassInput.getText()))
            return false;
        return true;
    }

    public boolean readFromFile(TextField nameInput,TextField EmailInput, PasswordField passInput,PasswordField ConpassInput,TextField PhonNoInput,TextField AddressInput){
        try {
            //FileReader fr = new FileReader("C:\\2-click run\\test.txt.txt");
            FileWriter fw = new FileWriter("/home/sahidul/Desktop/Online Shopping/src/sample/UserInfo.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nameInput.getText()+"\n");
            bw.write(EmailInput.getText()+"\n");
            bw.write(passInput.getText()+"\n");
            //bw.write(ConpassInput.getText()+"\n");
            bw.write(PhonNoInput.getText()+"\n");
            bw.write(AddressInput.getText()+"\n");
            bw.write("##\n");
            bw.close();

            FileWriter fw1 = new FileWriter("/home/sahidul/Desktop/Online Shopping/src/sample/login_input.txt",true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.append(nameInput.getText()+"#");
            bw1.append(passInput.getText()+"\n");
            bw1.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public void errorwindow(){
        Stage window1 = new Stage();
        window1.setTitle("Invalid Input");
        System.out.println("fdsfsdfsdf");
        Button bb = new Button("OK");
        Label lb = new Label("Invalid Input");
        bb.setOnAction(e1-> window1.close());

        GridPane gridPane1= new GridPane();
        gridPane1.setPadding(new Insets(10,10,10,10));
        gridPane1.setVgap(8);
        gridPane1.setHgap(10);
        gridPane1.setConstraints(lb,1,1);
        gridPane1.setConstraints(bb,1,2);
        gridPane1.getChildren().add(bb);
        Scene scene = new Scene(gridPane1,380,140);
        window1.setScene(scene);

        window1.show();
    }

    public void Sign_Up() {
        window.setTitle("Sign Up");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 0);

        Label Email = new Label("Email:");
        GridPane.setConstraints(Email, 0, 1);

        TextField EmailInput = new TextField();
        EmailInput.setPromptText("Email");
        GridPane.setConstraints(EmailInput, 1, 1);


        //pass label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);

        //pass Input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 2);

        //pass label
        Label ConpassLabel = new Label("Confirm Password:");
        GridPane.setConstraints(ConpassLabel, 0, 3);

        //pass Input
        PasswordField ConpassInput = new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(ConpassInput, 1, 3);

        Label PhoneNo = new Label("Mobile No:");
        GridPane.setConstraints(PhoneNo, 0, 4);

        TextField PhoneNoInput = new TextField();
        PhoneNoInput.setPromptText("Mobile No");
        GridPane.setConstraints(PhoneNoInput, 1, 4);

        Label Address = new Label("Address:");
        GridPane.setConstraints(Address, 0, 5);

        TextField AddressInput = new TextField();
        GridPane.setConstraints(AddressInput, 1, 5);


        Button loginButton = new Button("Sign Up");
        GridPane.setConstraints(loginButton, 1, 6);
        loginButton.setOnAction(e -> {
            if(!validation(nameInput,EmailInput, passInput,ConpassInput,PhoneNoInput,AddressInput)) {
                errorwindow();
            }
           else {
                readFromFile(nameInput,EmailInput, passInput,ConpassInput,PhoneNoInput,AddressInput) ;
            new LogIn().login();

            }

        });//store in file
        gridPane.getChildren().addAll(nameLabel, nameInput,Email,EmailInput, passLabel, passInput,ConpassLabel,ConpassInput,PhoneNo,PhoneNoInput,Address,AddressInput, loginButton);

        Scene scene1 = new Scene(gridPane, 380, 320);
        scene1.getStylesheets().add("tst.css");
        window.setScene(scene1);
        window.show();
    }
}
