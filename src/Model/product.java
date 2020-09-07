
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

public class product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();;


    /**
     * constructor for product, note this constructor does not include an observablelist per UML documentation.
     * an associated parts list is added after product creation
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     */
    public product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     *
     * @return product id
     */

    public int getId() {
        return id;
    }

    /**
     * sets a new product id based on param id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name of product
     */
    public String getName() {
        return name;
    }

    /**
     * sets a new product name based on param name
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return product price
     */

    public double getPrice() {
        return price;
    }

    /**
     * sets a new price for product based on param price
     * @param price
     */

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return current inventory level of product
     */
    public int getStock() {
        return stock;
    }

    /**
     * sets new inventory level of product based on param stock
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     *
     * @return minimum inventory level of product
     */
    public int getMin() {
        return min;
    }

    /**
     * sets new minimum inventory level of product based on param min
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     *
     * @return max inventory level of product
     */
    public int getMax() {
        return max;
    }

    /**
     * sets new max inventory level of product based on param max
     * @param max
     */

    public void setMax(int max) {
        this.max = max;
    }

    /**
     * adds a part to the associatedParts field of this product instance
     * @param associatedPart
     */
    public void addAssociatedPart(Part associatedPart) {
        this.associatedParts.add(associatedPart);
    }

    /**
     * removes a part from the associatedParts field of this product instance
     * @param partID
     * @return True if an associated Part was removed, false if it was not
     */

    public boolean removeAssociatedPart(int partID) {
        for (Part p : associatedParts) {
            if (p.getId() == partID) {
                associatedParts.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return an observableList containing all associated part for this product
     */

    public ObservableList getAssociatedPartsList() {
        return associatedParts;
    }

    /**
     * Requirements G: a detailed description of a logical or runtime error that you corrected in the code and a detailed description of how you corrected it above the line of code you are referring to
     * checks user inputs for errors on the modify product and add product pane.
     * Ran into multiple bugs trying to make this work because i was trying to use this for both data type error and logical error.
     * i resolved this issue by spliting the logical error check into this part and leaving the data error to be handled through an try catch block
     * @param name
     * @param stock
     * @param price
     * @param max
     * @param min
     * @param associatedParts
     */
    public static void checkProductFields(String name, int stock, double price, int max, int min, ObservableList<Part> associatedParts){

        if (max < min ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The product was NOT added or modified!");
            alert.setContentText("Max can not be less than Min");
            alert.showAndWait();
        }

        if (stock < min ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The product was NOT added or modified!");
            alert.setContentText("Inventory can not be less than Min");
            alert.showAndWait();}

        if (stock > max ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The product was NOT added or modified!");
            alert.setContentText("Inventory can not be greater than Max");
            alert.showAndWait();}

        if (name.length() == 0 ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The product was NOT added or modified!");
            alert.setContentText("Product name Can not be empty!");
            alert.showAndWait();}

        if (associatedParts.isEmpty() ) {Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("The product was NOT added or modified!");
            alert.setContentText("Product name Can not be empty!");
            alert.showAndWait();}

    }

    /**
     * used for switching, might be able to combine with checkProductFields and accomplish both messaging and switching with less code
     * @param name
     * @param stock
     * @param price
     * @param max
     * @param min
     * @param associatedParts
     * @return True is an logical error is detected from the users inputs, false is no errors
     */

    public static boolean checkProductFields_logic(String name, int stock, double price, int max, int min, ObservableList<Part> associatedParts ){

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

        else if (associatedParts.isEmpty() ) {
            return true;
        }

        return false;
    }




}