package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.IOException;

public class OneItem {
    private String location;
    private String name;
    private String price;
    public Group root;
    HBox hbox;
    public int setx;
    public  int sety;
    ImageView imageView;
    Button button1;
    Rectangle rectangle;
    Stage window;

    public OneItem(String location, String name, String price,int setx,int sety,Stage window) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.setx=setx;
        this.sety=sety;
        this.window = window;
    }
    public void createAnItem() throws IOException {
        FileInputStream input = new FileInputStream(location);
        Image image = new Image(input);
        imageView = new ImageView(image);
        imageView.setX(20);
        imageView.setY(50);
        imageView.setFitHeight(100);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imageView.setScaleX(1.9);
                imageView.setScaleY(1.8);
            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                imageView.setScaleX(1);
                imageView.setScaleY(1);
            }
        });
    }

    public void CREATEButton()  throws IOException {
        Label label = new Label(price);
        label.setFont(new Font("Arial", 15));
        button1 = new Button(name, label);
        button1.setOnAction(e -> {

            new ItemDetails(window,name,location,price).ViewDescription();
            System.out.println(name);
        });

        button1.setContentDisplay(ContentDisplay.BOTTOM);
    }
    public void createrectangle(){
        rectangle = new Rectangle();
        rectangle.setX(setx);
        rectangle.setY(sety);

        rectangle.setHeight(110);
        rectangle.setWidth(370);
        rectangle.setFill(Color.SILVER);
        rectangle.setStrokeWidth(4);
        rectangle.setStroke(Color.DARKGRAY);
    }
}