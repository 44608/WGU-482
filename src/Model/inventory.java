package Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class inventory {

    private static ObservableList<product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    /**
     * adds a part object to the ObservableList of allParts (inventory of parts)
     * @param newPart
     */
    public static void addPart(Part newPart) {
        allParts.addAll(newPart);
    }

    /**
     * adds a product object to the Observable list of allProducts (inventory of products)
     * @param newProduct
     */
    public static void addProducts(product newProduct) {
        allProducts.addAll(newProduct);
    }

    /**
     *
     * @param partID
     * @return Part object based on partID
     */
    public static Part lookUpPart(int partID) {
        if (!allParts.isEmpty()) {
            for (int i = 0; i < allParts.size(); i++) {
                if (allParts.get(i).getId() == partID) {
                    return allParts.get(i);
                }
            }

        }
        return null;
    }

    /**
     *
     * @param productID
     * @return Product object based on productID
     */
    public static product lookUpProduct(int productID) {
        if (!allProducts.isEmpty()) {
            for (int i = 0; i < allProducts.size(); i++) {
                if (allProducts.get(i).getId() == productID) {
                    return allProducts.get(i);
                }
            }
        }
        return null;
    }

    /**
     * creates a variable to show all parts from parts inventory that matches or partially matches the partName param
     * @param partName
     * @return list of matched parts based on names
     */

       public static ObservableList<Part> lookUpPart(String partName) {
        if (!allParts.isEmpty()) {
            ObservableList searchallParts = FXCollections.observableArrayList();
            for (Part p : getAllParts()) {
                if (p.getName().contains(partName)) {
                    searchallParts.add(p);
                }
            }
            return searchallParts;
        }
        return null;
    }

    /**
     * creates a variable to show all products from inventory that matches or partially matches the productName param
     * @param productName
     * @return list of matched products based on names
     */


    public static ObservableList<product> lookUpProduct(String productName) {
        if (!allProducts.isEmpty()) {
            ObservableList searchProductList = FXCollections.observableArrayList();
            for (product p : getAllProducts()) {
                if(p.getName().contains(productName)){
                    searchProductList.add(p);
                }
            }
        }
        return null;
    }

    /**
     * updates product in allproducts with new newproduct based on Index
     * @param Index
     * @param newProduct
     */

    public static void updateProduct(int Index, product newProduct) {
        allProducts.set(Index, newProduct);
    }

    /**
     * updates parts  in allParts with selectedPart based on Index
     * @param Index
     * @param selectedPart
     */

    public static void updatePart(int Index, Part selectedPart){
       allParts.set(Index, selectedPart);
    }

    /**
     *
     * @return the observablelist allParts
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     *
     * @return the observableList allProducts
     */


    public static ObservableList<product> getAllProducts() {
        return allProducts;
    }


    /**
     *
     * @param selectedProduct
     * @return True if product is deleted, else return false
     */
    public static boolean deleteProduct(product selectedProduct) {
        for (product p : allProducts){
            if (p.getId() == selectedProduct.getId()) {
                allProducts.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param selectedPart
     * @return True if part is deleted, else return false
     */

    public static boolean deletePart(Part selectedPart) {
        for (Part p : allParts){
            if (p.getId() == selectedPart.getId()) {
                allParts.remove(p);
                return true;
            }
        }
        return false;
    }


}
