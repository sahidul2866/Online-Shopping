package sample;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.FileInputStream;
import java.io.IOException;



class starCreator{

    public String stared="/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg";
    public String staar;



    public HBox starCreatorr() {
        HBox hb = new HBox();
        try {
            Group r = new Group();
            ImageView i1 = new ImageView(new Image(new FileInputStream(stared)));
            ImageView i = new ImageView(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/1.jpg")));
            ImageView i2 = new ImageView(new Image(new FileInputStream(stared)));
            ImageView i3 = new ImageView(new Image(new FileInputStream(stared)));
            ImageView i4 = new ImageView(new Image(new FileInputStream(stared)));
            ImageView i5 = new ImageView(new Image(new FileInputStream(stared)));
            i1.setFitHeight(50);
            i1.setFitWidth(25);
            i2.setX(90);
            i2.setY(480);
            i2.setFitHeight(30);
            i2.setFitWidth(25);
            i3.setX(140);
            i3.setY(480);
            i3.setFitHeight(30);
            i3.setFitWidth(25);
            i4.setX(190);
            i4.setY(480);
            i4.setFitHeight(30);
            i4.setFitWidth(25);
            i5.setX(240);
            i5.setY(480);
            i5.setFitHeight(30);
            i5.setFitWidth(25);
            i1.setPreserveRatio(true);
            i.setX(50);
            i.setY(480);
            i.setFitHeight(200);
            i.setFitWidth(200);
            i.setPreserveRatio(true);
            hb.getChildren().addAll(i1, i2, i3, i4, i5);
            i1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                     @Override
                                     public void handle(final MouseEvent mouseEvent) {
                                         //System.out.println("CLICKED"); // will only be seen when the ImageView is wrapped in a HBox
                                         try {
                                             i1.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                             i2.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                             i3.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                             i4.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                             i5.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                             staar="/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/1.jpg";
                                         } catch (Exception e1) {
                                             e1.printStackTrace();
                                         }
                                     }
                                 });
                 i2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                          @Override
                                          public void handle(final MouseEvent mouseEvent) {
                                              //System.out.println("CLICKED"); // will only be seen when the ImageView is wrapped in a HBox
                                              try {
                                                  i1.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                  i2.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                  i3.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                                  i4.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                                  i5.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                                  staar="/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/2.jpg";
                                              } catch (Exception e1) {
                                                  e1.printStackTrace();
                                              }
                                          }
                                      });
                    i3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                             @Override
                                             public void handle(final MouseEvent mouseEvent) {
                                                 //System.out.println("CLICKED"); // will only be seen when the ImageView is wrapped in a HBox
                                                 try {
                                                     i1.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                     i2.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                     i3.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                     i4.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                                     i5.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                                     staar="/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/3.jpg";
                                                 } catch (Exception e1) {
                                                     e1.printStackTrace();
                                                 }
                                             }
                                         });
                         i4.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                                  @Override
                                                  public void handle(final MouseEvent mouseEvent) {
                                                      //System.out.println("CLICKED"); // will only be seen when the ImageView is wrapped in a HBox
                                                      try {
                                                          i1.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                          i2.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                          i3.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                          i4.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                                          i5.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/empty.jpg")));
                                                          staar="/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/4.jpg";
                                                      } catch (Exception e1) {
                                                          e1.printStackTrace();
                                                      }
                                                  }
                                              });
                            i5.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(final MouseEvent mouseEvent) {
                                    //System.out.println("CLICKED"); // will only be seen when the ImageView is wrapped in a HBox
                                    try {
                                        i1.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                        i2.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                        i3.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                        i4.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                        i5.setImage(new Image(new FileInputStream("/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/filled.jpg")));
                                        staar="/home/sahidul/Desktop/Online Shopping/src/sample/Pictures/5.jpg";
                                    } catch (Exception e1) {
                                        e1.printStackTrace();
                                    }
                                }
            });

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return hb;
    }



}
