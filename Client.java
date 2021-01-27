package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    String User;
    String name;
    String Price;
    Stage window;
    String ddecider;

    public Client(String user, String name, String price,Stage window) {
        User = user;
        this.name = name;
        Price = price;
        this.window=window;

    }
    public void toServer() {
       try {
            Socket clientSocket = new Socket("127.0.0.1", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream())
            );
            out.println(name);
            String inputString = in.readLine();
            ddecider=inputString;

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        window.show();

    }
    public void newClient(){
        try {

            toServer();
            if(ddecider.equals("ok")) {
                FileWriter fr = new FileWriter("/home/sahidul/Desktop/Online Shopping/src/sample/Client/" + User + ".txt", true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write(name + "\n");
                br.write(Price + "\n");
                br.close();
                window.setTitle("Cart");
                Button bb = new Button("ok");
                Label lb = new Label("Added to Cart");
                lb.setFont(new Font(14));
                bb.setOnAction(e -> {
                    window.close();
                });
                BorderPane gridPane1 = new BorderPane();
                HBox group = new HBox(bb);
                gridPane1.setTop(lb);
                gridPane1.setCenter(group);
                Scene scene = new Scene(gridPane1, 380, 140);
                window.setScene(scene);

                window.show();
            }
                else{
                    window.setTitle("Cart");
                    Button bb = new Button("ok");
                    Label lb = new Label("Not Available");
                    lb.setFont(new Font(14));
                    bb.setOnAction(e-> {
                        window.close();
                    });
                    BorderPane gridPane1= new BorderPane();
                    HBox group = new HBox(bb);
                    gridPane1.setTop(lb);

                    gridPane1.setCenter(group);
                    Scene scene = new Scene(gridPane1,380,140);
                    window.setScene(scene);
                    window.show();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
