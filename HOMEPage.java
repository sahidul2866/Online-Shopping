package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;




import  javafx.application.Application;
import static javafx.application.Application.launch;

//import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.net.URL;


class HOMEPage {
    static String result;
    Stage home;
    public HOMEPage(Stage home){
        this.home=home;
    }
    public void start() {
        try {
            Menu s1Menu = new Menu(new MenuBar(), home);
            s1Menu.menuBar();

            TreeViewLeft s1TreeView = new TreeViewLeft(new TreeView<>(),home);
            s1TreeView.treeView();


            home.setTitle("Home Page");

            Label labelfirst = new Label("From which field do you wanna shopping?");
            labelfirst.setFont(new Font("Monospaced",25));
            labelfirst.setTextFill(Color.LEMONCHIFFON);
            Label labelresponse = new Label();

            Button button = new Button("Enter");

            ChoiceBox<String> categories = new ChoiceBox<>();
            categories.setLayoutX(100);
            categories.setLayoutY(100);
            // categories.setPadding(new Insets(40,200,60,100));
            categories.getItems().addAll("Mobile Phones", "Men Fashion", "Women Fashion", "Private Cars", "Bikes", "Sports");
            categories.getSelectionModel().select(0);


            button.setOnAction(e ->
            {
                //  labelresponse.setText("You chose " + dropdown.getValue());
                if (categories.getValue() == "Sports") {
                    labelresponse.setText("Sports");
                    new Sports(home).start();
                }
                else if (categories.getValue() == "Mobile Phones") {
                    labelresponse.setText("Mobile Phones");
                    new scene1(home).start();
                }
                else if (categories.getValue() == "Men Fashion") {
                    labelresponse.setText("m f");
                    new MenFashion(home).start();
                }
                else  if (categories.getValue() == "Women Fashion") {
                    labelresponse.setText("w f");
                    System.out.println("women");
                    new WomenFashion(home).start();
                }
                else if (categories.getValue() == "Private Cars") {
                    labelresponse.setText("p c");
                    new Cars(home).start();
                }
                else if (categories.getValue() == "Bikes") {
                    labelresponse.setText("b");
                    new Bikes(home).start();
                }
            });

            Image image = new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/HOMEPAGe.jpg"));
            ImageView imageView=new ImageView(image);
            imageView.setX(200);
            imageView.setFitWidth(600);
            imageView.setFitHeight(300);
            String h="Categories";

            // Text t= new Text(h);
            Label l=new Label(h);
            l.setFont(new Font("Verdana",20));
            l.setTextFill(Color.TEAL);
            HBox lay = new HBox(10);
            lay.getChildren().addAll(l,categories);
            VBox layout=new VBox(15);
            layout.setPadding(new Insets(100,200,60,250));
            layout.getChildren().addAll(labelfirst, lay, button, labelresponse);
            BorderPane borderpane = new BorderPane();
            HBox hbox=new HBox();
            hbox.setSpacing(320);
            hbox.setPadding(new Insets(0,10,70,0));
            hbox.getChildren().addAll(s1TreeView.treeView,layout);
            VBox v2= new VBox();
            v2.getChildren().addAll(s1Menu.menuBar,hbox);
            Group root=new Group();
            root.getChildren().addAll(imageView,v2);
            Scene scenehome = new Scene(root, 1400, 750,Color.CORAL);

//                String css = this.getClass().getResource("E:\\java programming\\OKA\\src\\sample\\cas.css").toExternalForm();

            URL url = this.getClass().getResource("cas.css");
            if (url == null) {
                System.out.println("Resource not found. Aborting.");
                System.exit(-1);
            }
            String css = url.toExternalForm();
            scenehome.getStylesheets().add(css);


            home.setScene(scenehome);

            home.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}