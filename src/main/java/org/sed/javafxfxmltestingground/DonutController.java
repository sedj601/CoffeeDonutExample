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

public class DonutController {
    private Model model;
    @FXML TextField tfGlazedSum, tfChocolateSum, tfBeignetSum;
    
    public void initModel(Model model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
        
        countGlazedToTextField();
        countChocolateToTextField();
        countBeignetToTextField();
    }
    
    @FXML
    private void handleBtnGlazedOnaction(){
        model.getFoodList().add(new Food("Glazed", "Donut"));
        
        countGlazedToTextField();
    }
    
    @FXML
    private void handleButtonChocolateOnaction(){
       model.getFoodList().add(new Food("Chocolate", "Donut"));
       
       countChocolateToTextField();
    }
    
    @FXML
    private void handleBtnBeignetOnaction(){
        model.getFoodList().add(new Food("Beignet", "Donut"));
        
        countBeignetToTextField();
    }
    
    @FXML
    private void handleBtnBuyCoffeeOnaction(ActionEvent actionEvent){
        try{
            Stage stage = ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow()));

            FXMLLoader coffeeLoader = new FXMLLoader(getClass().getResource("CoffeeView.fxml"));
            VBox coffeeRoot = (VBox)coffeeLoader.load();
            CoffeeController coffeeController = coffeeLoader.getController();

            
            coffeeController.initModel(model);

            Scene scene = new Scene(coffeeRoot);
            stage.setScene(scene);
        }
        catch (IOException ex) {
             System.out.println(ex.toString());
         }
    }
    
    
    private void countGlazedToTextField()
    {
        tfGlazedSum.setText(Integer.toString(model.getFoodList().filtered((food) -> {
                return food.getName().equals("Glazed") && food.getType().equals("Donut");
            }).size()));
    }
    
    private void countChocolateToTextField()
    {
        tfChocolateSum.setText(Integer.toString(model.getFoodList().filtered((food) -> {
                return food.getName().equals("Chocolate") && food.getType().equals("Donut");
            }).size()));
    }
    
    private void countBeignetToTextField()
    {
        tfBeignetSum.setText(Integer.toString(model.getFoodList().filtered((food) -> {
                return food.getName().equals("Beignet") && food.getType().equals("Donut");
            }).size()));
    }
}