package Model;

import javafx.scene.control.Alert;

/**
 *
 * @author Qiao Wang
 *
 */

public abstract class Part {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the price
     */

    public double getPrice() {
        return price;
    }


    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }
    /**
     * @param stock the stock to set
     */

    public void setStock(int stock) {
        this.stock = stock;
    }


    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }
    /**
     * @return the max
     */

    public int getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */

    public void setMax(int max) {
        this.max = max;
    }

    /**
     * takes input from gui for the listed fields and runs them through a series of checks for logic or data errors.
     * displays the errors through alerts
     * @param name
     * @param stock
     * @param price
     * @param max
     * @param min
     */


    public static void checkPartFields(String name, int stock, double price, int max, int min){

        if (max < min ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The part was NOT added or modified!");
            alert.setContentText("Max can not be less than Min");
            alert.showAndWait();
            }

        if (stock < min ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The part was NOT added or modified!!");
            alert.setContentText("Inventory can not be less than Min");
            alert.showAndWait();}

        if (stock > max ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The part was NOT added or modified!");
            alert.setContentText("Inventory can not be greater than Max");
            alert.showAndWait();}

        if (name.length() == 0 ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The part was NOT added or modified!!");
            alert.setContentText("Name Can not be empty!");
            alert.showAndWait();}

    }

    /**
     * takes input from gui for the listed fields and runs them through a series of checks for logic or data errors.
     * return false if no errors
     * @param name
     * @param stock
     * @param price
     * @param max
     * @param min
     */


    public static boolean checkPartFields_logic(String name, int stock, double price, int max, int min){

        if (max < min ) {
            return true;

        }

        else if (stock < min ) {
            return true;
        }

        else if (stock > max ) {
            return true;
        }

        else if (name.length() == 0 ) {
            return true;
        }

        return false;
    }


}