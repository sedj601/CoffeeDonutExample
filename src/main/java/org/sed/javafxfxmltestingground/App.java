package org.sed.javafxfxmltestingground;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.VBox;

/**
 * JavaFX App
 */
public class App extends Application {

     @Override
    public void start(Stage primaryStage){
         try {
             FXMLLoader coffeeLoader = new FXMLLoader(getClass().getResource("CoffeeView.fxml"));
             VBox coffeeRoot = (VBox)coffeeLoader.load();
             CoffeeController coffeeController = coffeeLoader.getController();
             
             Model model = new Model();
             coffeeController.initModel(model);
             
             Scene scene = new Scene(coffeeRoot);
             primaryStage.setScene(scene);
             primaryStage.show();
         } 
         catch (IOException ex) {
             System.out.println(ex.toString());
         }
    }

}