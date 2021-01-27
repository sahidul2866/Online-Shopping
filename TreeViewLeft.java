package sample;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;

public class TreeViewLeft {
    public TreeView<String> treeView;
    public Stage window;

    public TreeViewLeft(TreeView<String> treeView,Stage window) {
        this.treeView = treeView;
        this.window=window;
    }

    public TreeItem<String> makeBranch(String Title,TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(Title);
        parent.getChildren().add(item);
        return item;
    }
    public void treeView() {
        TreeItem<String> root, Electronics, Mobiles, Computers, Others, CarsVehicles, HeavyCars, PrivateCars, Bikes, Property, Sports, Fasion, Men, Women, Others1;
        root = new TreeItem<>();
        root.setExpanded(true);
        Electronics = makeBranch("Electronics", root);
        Mobiles = makeBranch("Mobiles", Electronics);
        CarsVehicles = makeBranch("CarsVehicles", root);
        HeavyCars = makeBranch("Cars", CarsVehicles);
        Bikes = makeBranch("Bikes", CarsVehicles);
        Sports = makeBranch("Sports", root);
        Fasion = makeBranch("Fashion", root);
        Men = makeBranch("Men", Fasion);
        Women = makeBranch("Women", Fasion);
        treeView = new TreeView<>(root);
        treeView.setShowRoot(false);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println(newValue.getValue());
            if(newValue.getValue().equals("Mobiles"))
                new scene1(window).start();
            if(newValue.getValue().equals("Cars"))
                new Cars(window).start();
            if(newValue.getValue().equals("Bikes"))
                new Bikes(window).start();
            if(newValue.getValue().equals("Sports"))
                new Sports(window).start();
            if(newValue.getValue().equals("Men"))
                new MenFashion(window).start();
            if(newValue.getValue().equals("Women"))
                new WomenFashion(window).start();
        });
    }

}
