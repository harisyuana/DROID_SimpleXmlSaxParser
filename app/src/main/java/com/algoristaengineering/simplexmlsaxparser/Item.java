package com.algoristaengineering.simplexmlsaxparser;

/**
 * Created by NavcoreWindow8 on 1/20/2015.
 */
public class Item {
    private String itemNumber = null;
    private String description = null;
    private String price = null;
    private double weight = 0;

    public String getItemNumber(){
        return itemNumber;
    }

    public void setItemNumber(String itemNumber){
        this.itemNumber = itemNumber;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public double getWeight(){
        return weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

}
