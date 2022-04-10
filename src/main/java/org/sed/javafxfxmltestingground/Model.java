/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sed.javafxfxmltestingground;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sedj601
 */
public class Model {
    private final ObservableList<Food> foodList = FXCollections.observableArrayList();
    
    public ObservableList<Food> getFoodList()
    {
        return foodList;
    }
}
