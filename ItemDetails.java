package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;


public class ItemDetails {
    Stage window;
    String name;
    String location;
    public  String currentUser;
    String price;
    String stared = "/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/0.jpg";
   // boolean submitted;

    public ItemDetails(Stage window, String name, String location,String price) {
        this.window = window;
        this.name = name;
        this.location = location;
        this.price=price;

    }
    public void getUser(){
        try {
            FileReader fr = new FileReader("/home/sahidul/Desktop/Online Shopping/src/sample/currentUser.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            str = br.readLine();
            currentUser = str;
            fr.close();
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public String getReview(){
        String text = "\n";
        try {
           // String text="\n";
            Label labelll = new Label("\n\nReviews:");
            labelll.setFont(new Font(20));
            File ff = new File("/home/sahidul/Desktop/Online Shopping/src/sample/review_info/"+name+".txt");
            ff.createNewFile();
            FileReader frr = new FileReader("/home/sahidul/Desktop/Online Shopping/src/sample/review_info/"+name+".txt");
            BufferedReader brr = new BufferedReader(frr);
            String strr;

            while ((strr = brr.readLine()) != null) {
                text =text + strr+"\n";

            }
            frr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }

    public String getDescription(){
        String textt = "\n";
        try {
            File file = new File("/home/sahidul/Desktop/Online Shopping/src/sample/des_info/" + name + ".txt");
            file.createNewFile();
            FileReader frrr = new FileReader("/home/sahidul/Desktop/Online Shopping/src/sample/des_info/" + name + ".txt");
            BufferedReader brrr = new BufferedReader(frrr);
            String strrr;

            while ((strrr = brrr.readLine()) != null) {
                textt = textt + strrr + "\n";
            }
            frrr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return textt;


    }

    public void addToCart(){
        getUser();
        Stage window1 = new Stage();
        window1.setTitle("Cart");
        Button bb = new Button("Yes");
        Button bb1 = new Button("No");
        Label lb = new Label("Are you sure?");
        lb.setFont(new Font(14));
        bb1.setOnAction(e1-> window1.close());
        bb.setOnAction(e-> {
            if(currentUser.length()==0) {
                new Error().show();
                getUser();
                window1.close();
            }
                    else new Client(currentUser,name,price,window1).newClient();
                });
        BorderPane gridPane1= new BorderPane();
        HBox group = new HBox(bb,bb1);
        gridPane1.setTop(lb);

        gridPane1.setCenter(group);
        Scene scene = new Scene(gridPane1,380,140);
        window1.setScene(scene);

        window1.show();
    }

    public void ViewDescription()

    {
        try {


            getUser();

            System.out.println("called");
            window.setTitle(name);


            Menu s1Menu = new Menu(new MenuBar(),window);
            s1Menu.menuBar();

            TreeViewLeft s1TreeView = new TreeViewLeft(new TreeView<>(),window);
            s1TreeView.treeView();

            FileInputStream input = new FileInputStream(location);
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(300);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);

            Label label = new Label(name);
            label.setFont(new Font(40));
           label.setPadding(new Insets(40,350,90,50));
            Button cart = new Button("Add to Cart");
            cart.setOnAction(e->{
                addToCart();
            });


            Label des= new Label(getDescription());
            des.setFont(new Font(20));

           Label rateThis= new Label("Rate this product");
            rateThis.setFont(new Font(20));

            starCreator star = new starCreator();

            Label labelll = new Label("\n\nReviews:");
            labelll.setFont(new Font(20));
            File ff = new File("/home/sahidul/Desktop/Online Shopping/src/sample/review_info/"+name+".txt");
            ff.createNewFile();
            FileReader frr = new FileReader("/home/sahidul/Desktop/Online Shopping/src/sample/review_info/"+name+".txt");
            BufferedReader brr = new BufferedReader(frr);
            String strr;
            String text="\n";
            while ((strr = brr.readLine()) != null) {
                text =text + strr+"\n";

            }
            frr.close();
            Label labell = new Label(getReview());
            labell.setFont(new Font(16));


            Label commentThis = new Label("Your Comment");

            TextField comment = new TextField();
            Button submit = new Button("Submit");


            submit.setOnAction(e-> {
                try {
                    if(currentUser.length()==0){
                        new Error().show();
                        this.ViewDescription();
                    }
                    else {
                        File f = new File("/home/sahidul/Desktop/Online Shopping/src/sample/review_info/" + name + ".txt");
                        FileWriter fw1 = new FileWriter(f, true);
                        BufferedWriter bw1 = new BufferedWriter(fw1);

                        bw1.append("By:"+currentUser + "\n");
                        bw1.append(comment.getText() + "\n");
                        bw1.close();
                        this.ViewDescription();
                    }
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            });





            Rectangle rectangle = new Rectangle();
            rectangle.setX(0);
            rectangle.setY(420);
            rectangle.setHeight(200);
            rectangle.setWidth(800);
            rectangle.setFill(Color.SILVER);
            rectangle.setStrokeWidth(4);
            rectangle.setStroke(Color.DARKGRAY);

            VBox group1 = new VBox(commentThis,comment,submit);
            VBox group2 = new VBox(rateThis,star.starCreatorr(),labelll,labell);
            VBox vBox = new VBox(imageView,cart,group2);
            VBox vBox1 = new VBox(des,group1);
            vBox1.setSpacing(100);
            vBox.setSpacing(20);


            HBox main = new HBox();
            main.getChildren().addAll(vBox,vBox1);
            main.setSpacing(100);
            main.setPadding(new Insets(150,700,1000,50));



            BorderPane borderpane = new BorderPane();

          //  borderpane.getChildren(scrollBar);
            Group group = new Group(label,main);
            borderpane.setCenter(group);
            borderpane.setTop(s1Menu.menuBar);
            borderpane.setLeft(s1TreeView.treeView);
           // ScrollBar scrollBar = new ScrollBar(borderpane);
            borderpane.maxHeight(10000);
            borderpane.maxWidth(10000);
            Scene scene11 = new Scene(borderpane, 1140, 690);
            System.out.println(scene11.getX());
            window.setScene(scene11);
            window.show();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




}