package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Cart {
    String user;
    String name;
    String price;
    ObservableList<Product> products = FXCollections.observableArrayList();
    javafx.scene.control.TableView<Product> table;
    Stage window;


    public Cart(String user,Stage window) {
        this.user=user;
        this.window = window;
    }
    public void table() {

    try{
        window.setTitle("Cart");
        javafx.scene.control.TableColumn<Product, String> nameColumn = new javafx.scene.control.TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        javafx.scene.control.TableColumn<Product, String> UserColumn = new javafx.scene.control.TableColumn<>("User Name");
        UserColumn.setMinWidth(200);
        UserColumn.setCellValueFactory(new PropertyValueFactory<>("User"));

        javafx.scene.control.TableColumn<Product, String> priceColumn = new javafx.scene.control.TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        priceColumn.setMinWidth(200);

        table = new javafx.scene.control.TableView<>();
        table.setItems(getProduct());
        table.setItems(getProduct());

        table.getColumns().addAll(UserColumn, nameColumn, priceColumn);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
        System.out.println("Cart Ca;;ed");
    }
        catch (Exception e){
        e.printStackTrace();
    }

}
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        String name;
        String price;
        try {


            FileReader fr = new FileReader("/home/sahidul/Desktop/Online Shopping/src/sample/Client/" + user + ".txt");
            BufferedReader br = new BufferedReader(fr);
            String str="g";
            while (str != null) {
                str = br.readLine();
                 name=str;
                str = br.readLine();
                price = str;
                products.add(new Product(user,name,price));

                }
            fr.close();
            }

        catch (Exception e){
            e.printStackTrace();
        }

        return products;
    }

}
