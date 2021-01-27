

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Product;

import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static javafx.application.Application.launch;

public class checker extends Application{

   javafx.scene.control.TableView table;
   //ObservableList products=FXCollections.observableArrayList();


    public void start(Stage primaryStage ) {
        try {
            Stage window = primaryStage;
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
            System.out.println("efefefd");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        String str1 = "sahidul";
        products.add(new Product(str1,"islam","vvvvv"));
        str1="safa";
        products.add(new Product(str1,"islam","vvvvv"));
        return products;
    }


    public static void main(String[] args){
        launch(args);
    }

}
