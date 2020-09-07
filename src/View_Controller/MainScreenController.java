
package View_Controller;

import Model.Part;
import Model.inventory;
import Model.product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;

import static Model.inventory.deletePart;
import static Model.inventory.lookUpPart;

public class MainScreenController  implements Initializable {





    @FXML
    private AnchorPane main_pane;

    @FXML
    private Button exitMain_button;

    @FXML
    private AnchorPane partMain_pane;

    @FXML
    private Button searchPartMain_button;

    @FXML
    private TextField searchPartMain_text;

    @FXML
    private Button modifyPartMain_button;

    @FXML
    private Button deletePartMain_button;

    @FXML
    private Button addPartMain_button;

    @FXML
    private TableView<Part> partMain_table;

    @FXML
    private TableColumn<Part, Integer> partMain_table_ID;

    @FXML
    private TableColumn<Part, String> partMain_table_Name;

    @FXML
    private TableColumn<Part, Integer> partMain_table_Inv;

    @FXML
    private TableColumn<Part, Double> partMain_table_Price;

    @FXML
    private AnchorPane productMain_pane;

    @FXML
    private Button searchProductMain_button;

    @FXML
    private TextField searchProductMain_text;

    @FXML
    private Button modifyProductMain_button;

    @FXML
    private Button deleteProductMain_button;

    @FXML
    private Button addProductMain_button;

    @FXML
    private TableView<product> productsMain_table;

    @FXML
    private TableColumn<product, Integer> productsMain_table_ID;

    @FXML
    private TableColumn<product, String> productsMain_table_Name;

    @FXML
    private TableColumn<product, Integer> productsMain_table_Inv;

    @FXML
    private TableColumn<product, Double> productsMain_table_Price;

    @FXML
    void addPartMain(MouseEvent event) throws IOException {
        try {

            Stage StageAddPart = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent SceneAddPart = FXMLLoader.load(getClass().getResource("AddParts.fxml"));
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();
        }
        catch (IOException e) {}
    }


    @FXML
    void addProductMain(MouseEvent event) throws IOException{
        try {
            Stage StageAddPart = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent SceneAddPart = FXMLLoader.load(getClass().getResource("AddProducts.fxml"));
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();
        }
        catch (IOException e) {}
    }

    @FXML
    void deletePartMain(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Part");
        alert.setHeaderText("Are you sure you want to delete this part?");
        alert.setContentText("Press OK to delete the part. \n Or Press Cancel to Cancel this action");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            try {
                Part selectedPart = partMain_table.getSelectionModel().getSelectedItem();
                deletePart(selectedPart);
            }
            catch (NullPointerException e) {
                Alert nullalert = new Alert(Alert.AlertType.ERROR);
                nullalert.setTitle("Part Deletion Error");
                nullalert.setHeaderText("The part was NOT deleted!");
                nullalert.setContentText("There was no part selected!");
                nullalert.showAndWait();
            }
        }
        else {
            alert.close();
        }

    }

    @FXML
    void deleteProductMain(MouseEvent event) throws IOException{
        try {
            product selectedProduct = productsMain_table.getSelectionModel().getSelectedItem();

            if (!selectedProduct.getAssociatedPartsList().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Product Deletion Error!");
                alert.setHeaderText("Product was not removed!");
                alert.setContentText("This product has at least 1 associated parts, please remove associated parts before deleting this Product");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Product Delete");
                alert.setHeaderText("Confirm deletion?");
                alert.setContentText("Are you sure you want to delete " + selectedProduct.getName() + "?");
                alert.showAndWait();

                if (alert.getResult() == ButtonType.OK) {
                    inventory.deleteProduct(selectedProduct);

                }
            }
        } catch (NullPointerException e) {
            Alert nullalert = new Alert(Alert.AlertType.ERROR);
            nullalert.setTitle("Error");
            nullalert.setHeaderText("The product was NOT deleted!");
            nullalert.setContentText("There was no product selected!");
            nullalert.showAndWait();
        }

    }

    @FXML
    void exitMain(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void modifyPartMain(MouseEvent event) throws IOException {

        Part selectedPart = partMain_table.getSelectionModel().getSelectedItem();


        if (selectedPart == null) {
            Alert nullalert = new Alert(Alert.AlertType.ERROR);
            nullalert.setTitle("Part Modification Error");
            nullalert.setHeaderText("The part is NOT able to be modified!");
            nullalert.setContentText("There was no part selected!");
            nullalert.showAndWait();
        }
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ModifyParts.fxml"));
            loader.load();

            ModifyPartController Mod = loader.getController();
            Mod.loadSelected(selectedPart);

            Stage StageAddPart = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent SceneAddPart = loader.getRoot();
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();
            }
    }
    @FXML
    void modifyProductMain(MouseEvent event) throws IOException{

        product selectedProduct = productsMain_table.getSelectionModel().getSelectedItem();


        if (selectedProduct == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Product Modification Error");
            alert.setHeaderText("Unable to Modify Product");
            alert.setContentText("There was no product selected!");
            alert.showAndWait();
        }
        else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ModifyProduct.fxml"));
            loader.load();

            ModifyProductController Mod = loader.getController();
            Mod.loadSelectedProduct(selectedProduct);

            Stage StageModifyProduct = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent SceneModifyProduct = loader.getRoot();
            StageModifyProduct.setScene(new Scene(SceneModifyProduct));
            StageModifyProduct.show();
        }
    }


    @FXML
    void searchPartMain(MouseEvent event) throws IOException{
        String searchPartIDString = searchPartMain_text.getText();
            if (searchPartIDString.trim().isEmpty()) {
                partMain_table.setItems(inventory.getAllParts());
            }
            else {
                boolean found=false;
                    try {
                        Part searchID = inventory.lookUpPart(Integer.parseInt(searchPartMain_text.getText()));

                        if (searchID != null) {
                        ObservableList<Part> filteredPartsList = FXCollections.observableArrayList();
                        filteredPartsList.add(searchID);
                        partMain_table.setItems(filteredPartsList);
                        found=true;
                        }
                        else
                            {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Part Search Alert");
                        alert.setHeaderText("No Parts Found!!");
                        alert.setContentText("No Parts with this ID was found, try searching by Name");
                        alert.showAndWait();
                            }
                        }
                        catch (NumberFormatException e) {
                        ObservableList<Part> searchtext = inventory.lookUpPart(searchPartMain_text.getText());
                        if (!searchtext.isEmpty()){
                            partMain_table.setItems(searchtext);
                            found=true;
                        }
                        if (found==false)
                        {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Part Search Alert");
                            alert.setHeaderText("No Parts Found!!");
                            alert.setContentText("No Parts like this Name was found, try searching by ID");
                            alert.showAndWait();
                        }
                  }
            }

    }

    @FXML
    void searchProductMain(MouseEvent event) throws IOException{
        String searchProductIDString = searchProductMain_text.getText();
        if (searchProductIDString.trim().isEmpty()) {
            productsMain_table.setItems(inventory.getAllProducts());
        }
        else {
            boolean found=false;
            try {
                product searchID = inventory.lookUpProduct(Integer.parseInt(searchProductMain_text.getText()));

                if (searchID != null) {
                    ObservableList<product> filteredProductList = FXCollections.observableArrayList();
                    filteredProductList.add(searchID);
                    productsMain_table.setItems(filteredProductList);
                    found=true;
                }
                else
                {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Product Search Alert");
                    alert.setHeaderText("No Products Found!!");
                    alert.setContentText("No Product with this ID was found, try searching by Product Name");
                    alert.showAndWait();
                }
            }
            catch (NumberFormatException e) {
                ObservableList<product> searchProducttext = inventory.lookUpProduct(searchProductMain_text.getText());
                if (searchProducttext != null){
                    productsMain_table.setItems(searchProducttext);
                    found=true;
                }
                if (found==false)
                {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Product Search Alert");
                    alert.setHeaderText("No Products Found!!");
                    alert.setContentText("No Product like this Name was found, try searching by Product ID");
                    alert.showAndWait();
                }




            }
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partMain_table.setItems(inventory.getAllParts());
        productsMain_table.setItems(inventory.getAllProducts());

        productsMain_table_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        productsMain_table_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        productsMain_table_Inv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        productsMain_table_Price.setCellValueFactory(new PropertyValueFactory<>("price"));

        partMain_table_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        partMain_table_Name.setCellValueFactory(new PropertyValueFactory<>("name"));
        partMain_table_Inv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        partMain_table_Price.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

}
