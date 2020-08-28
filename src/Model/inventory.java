package Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class inventory {
    private static ObservableList<product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();


    public static void addPart(Part newPart) {
        allParts.addAll(newPart);
    }

    public static void addProducts(product newProduct) {
        allProducts.addAll(newProduct);
    }

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

    public static void updateProduct(int Index, product newProduct) {
        allProducts.set(Index, newProduct);
    }

    public static void updatePart(int Index, Part selectedPart){
       allParts.set(Index, selectedPart);
    }


    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static ObservableList<product> getAllProducts() {
        return allProducts;
    }

    public static boolean deleteProduct(product selectedProduct) {
        for (product p : allProducts){
            if (p.getId() == selectedProduct.getId()) {
                allProducts.remove(p);
                return true;
            }
        }
        return false;
    }

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
