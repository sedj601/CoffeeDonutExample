package org.sed.javafxfxmltestingground;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CoffeeController {
    private Model model;
    @FXML Button btnAddSmallCoffee, btnAddMediumCoffee, btnAddLargeCoffee, btnBuyDonuts;
    @FXML TextField tfSmallSum, tfMediumSum, tfLargeSum;
    
    public void initModel(Model model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
        
        countSmallCoffeeToTextField();
        countMediumCoffeeToTextField();
        countLargeCoffeeToTextField();
    }
    
    @FXML
    protected void initialize()
    {
        btnAddSmallCoffee.setOnAction((actionEvent) -> {
            model.getFoodList().add(new Food("Small", "Coffee"));
            
            countSmallCoffeeToTextField();
        });
        
        btnAddMediumCoffee.setOnAction((actionEvent) -> {
            model.getFoodList().add(new Food("Medium", "Coffee"));
            
            countMediumCoffeeToTextField();
        });
        
        btnAddLargeCoffee.setOnAction((actionEvent) -> {
            model.getFoodList().add(new Food("Large", "Coffee"));
            
            countLargeCoffeeToTextField();
        });
        
        btnBuyDonuts.setOnAction((actionEvent) -> {
            try{
                Stage stage = ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow()));

                FXMLLoader donutLoader = new FXMLLoader(getClass().getResource("DonutView.fxml"));
                VBox donutRoot = (VBox)donutLoader.load();
                DonutController donutController = donutLoader.getController();
                
                System.out.println("Number of items: " + model.getFoodList().size());
                donutController.initModel(model); 

                Scene scene = new Scene(donutRoot);
                stage.setScene(scene);
            }
            catch (IOException ex) {
                 System.out.println(ex.toString());
            }        
        });
    }
    
    private void countSmallCoffeeToTextField()
    {
        tfSmallSum.setText(Integer.toString(model.getFoodList().filtered((food) -> {
                return food.getName().equals("Small") && food.getType().equals("Coffee");
            }).size()));
    }
    
    private void countMediumCoffeeToTextField()
    {
        tfMediumSum.setText(Integer.toString(model.getFoodList().filtered((food) -> {
                return food.getName().equals("Medium") && food.getType().equals("Coffee");
            }).size()));
    }
    
    private void countLargeCoffeeToTextField()
    {
        tfLargeSum.setText(Integer.toString(model.getFoodList().filtered((food) -> {
                return food.getName().equals("Large") && food.getType().equals("Coffee");
            }).size()));
    }
}
