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

public class ReturnProduct {
    String currentUser;
    Stage window;

    public ReturnProduct(String currentUser, Stage window) {
        this.currentUser = currentUser;
        this.window = window;
    }

    public void takingReviews(TextField name,TextField Input){
        try{
            File f = new File("/home/sahidul/Desktop/Online Shopping/src/sample/review_info/" + name.getText() + ".txt");
            FileWriter fw1 = new FileWriter(f, true);
            BufferedWriter bw1 = new BufferedWriter(fw1);

            bw1.append("Returned By:"+currentUser + "\n");
            bw1.append("Reason:"+ Input.getText() + "\n");
            bw1.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeLineFromFile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().equals(lineToRemove)) {
                    String str = br.readLine();
                }

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            //Delete the original file
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ReturnAProduct() {
        window.setTitle("Return A Product");
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //Name label
        Label nameLabel = new Label("Product Name:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("name");
        GridPane.setConstraints(nameInput, 1, 0);

        //pass label
        Label passLabel = new Label("Reason:");
        GridPane.setConstraints(passLabel, 0, 1);

        //pass Input
        TextField passInput = new TextField();
        passInput.setPromptText("reason");
        GridPane.setConstraints(passInput, 1, 1);

        Button loginButton = new Button("Submit");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> {
                    removeLineFromFile("/home/sahidul/Desktop/Online Shopping/src/sample/Client/" + currentUser + ".txt", nameInput.getText());
                    takingReviews(nameInput,passInput);
                    new Cart(currentUser, window);
                    window.close();
                }
        );
        gridPane.getChildren().addAll(nameLabel, nameInput, passInput, passLabel, loginButton);
        Scene scene1 = new Scene(gridPane, 380, 220);
        scene1.getStylesheets().add("tst.css");
        window.setScene(scene1);
        window.show();
    }
}
