package sample;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;

class Menu{
    public MenuBar menuBar;
    public Stage window;
    public String currentUser;

    public Menu(MenuBar menuBar, Stage window) {
        this.menuBar = menuBar;
        this.window = window;
    }

    public Menu(MenuBar menuBar) {
        this.menuBar = menuBar;
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

    public void menuBar(){

        javafx.scene.control.Menu Catagories = new javafx.scene.control.Menu("_Catagories");
        MenuItem Electronics = new MenuItem("_Mobiles");
        MenuItem CarsVehicles = new MenuItem("_Cars");
        MenuItem Property = new MenuItem("_Bikes");
        MenuItem Sports = new MenuItem("_Sports");
        MenuItem Fashion = new MenuItem("_Men Fashion");
        MenuItem Other = new MenuItem("_Women Fashion");
        Catagories.getItems().addAll(Electronics,CarsVehicles,Property,Sports,Fashion);
        Electronics.setOnAction(e -> new scene1(window).start());
        CarsVehicles.setOnAction(e -> new Cars(window).start());
        Property.setOnAction(e -> new Bikes(window).start());
        Sports.setOnAction(e -> new Sports(window).start());
        Fashion.setOnAction(e -> new MenFashion(window).start());
        Other.setOnAction(e -> new WomenFashion(window).start());

        javafx.scene.control.Menu Cart = new javafx.scene.control.Menu("Cart");
        MenuItem MyCart = new MenuItem("My Cart");
        Cart.getItems().add(MyCart);
        MyCart.setOnAction(e -> {
            getUser();
            if(currentUser.length()==0) {
                new Error().show();
                getUser();
            }
            else
            new Cart(currentUser,new Stage()).table();
        });


        MenuItem Return = new MenuItem("Return a Product");
        Cart.getItems().add(Return);
        Return.setOnAction(e -> {
            getUser();
            if(currentUser.length()==0) {
                new Error().show();
                getUser();
            }
            else {

                new ReturnProduct(currentUser,new Stage()).ReturnAProduct();
            }
        });


        javafx.scene.control.Menu myAccount = new javafx.scene.control.Menu("My Account");
        MenuItem LogOut = new MenuItem("Log Out");
        MenuItem NewAccount = new MenuItem("Create a new Account");
        MenuItem login = new MenuItem("LogIn");
        myAccount.getItems().addAll(LogOut,NewAccount,login);
        LogOut.setOnAction(e -> System.out.println("LogOut"));
        NewAccount.setOnAction(e -> new Sign_Up().Sign_Up());

        login.setOnAction(event -> new LogIn().login());

        javafx.scene.control.Menu Help = new javafx.scene.control.Menu("Help");
        MenuItem Instructions = new MenuItem("Instructions");
        MenuItem ContactUs = new MenuItem("Contact Us");
        Help.getItems().addAll(Instructions,ContactUs);
        Instructions.setOnAction(e -> System.out.println("Instructions"));
        ContactUs.setOnAction(e -> System.out.println("Contact Us"));

        javafx.scene.control.Menu Credits = new javafx.scene.control.Menu("Credits");
        MenuItem credits = new MenuItem("Credits");
        Credits.getItems().add(credits);
        credits.setOnAction(e -> System.out.println("Credits"));

        javafx.scene.control.Menu Exit = new javafx.scene.control.Menu("_Exit");
        MenuItem exit = new MenuItem("Exit");
        Exit.getItems().add(exit);
        exit.setOnAction(e -> window.close()
        );



        menuBar.getMenus().addAll(Catagories,Cart,myAccount,Help,Credits,Exit);
        menuBar.getBorder();

    }
}