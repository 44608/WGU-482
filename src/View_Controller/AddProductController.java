package View_Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
public class AddProductController implements Initializable {

    @FXML
    private AnchorPane addProduct_pane;

    @FXML
    private TableView<Part> addProductPart_table;

    @FXML
    private TableColumn<Part, Integer> addProductPart_table_ID;

    @FXML
    private TableColumn<Part, String> addProductPart_table_name;

    @FXML
    private TableColumn<Part, Integer> addProductPart_table_inv;

    @FXML
    private TableColumn<Part, Double> addProductPart_table_price;

    @FXML
    private TableView<Part> addProductPartAsso_table;

    @FXML
    private TableColumn<Part, Integer> addProductPartAsso_table_ID;

    @FXML
    private TableColumn<Part, String> addProductPartAsso_table_name;

    @FXML
    private TableColumn<Part, Integer> addProductPartAsso_table_inv;

    @FXML
    private TableColumn<Part, Double> addProductPartAsso_table_price;

    @FXML
    private TextField addProductSearch_text;

    @FXML
    private Button addProductSearch_button;

    @FXML
    private Button addProductAddPart_button;

    @FXML
    private Button addProductRemove_button;

    @FXML
    private Button addProductCancel_button;

    @FXML
    private Button addProductSave_button;

    @FXML
    private TextField addProductID_auto;

    @FXML
    private TextField addProductName_text;

    @FXML
    private TextField addProductINV_text;

    @FXML
    private TextField addProductPrice_text;

    @FXML
    private TextField addProductMax_text;

    @FXML
    private TextField addProductMin_text;

    private int autoid = 1;

    private ObservableList<Part> productParts = FXCollections.observableArrayList();

    @FXML
    void addAssociatedPart(MouseEvent event) {
        Part selectedPart = addProductPart_table.getSelectionModel().getSelectedItem();
        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error! No Parts Selected");
            alert.setHeaderText("The part was not added!");
            alert.setContentText("A part must be selected from the table in order to be added");
            alert.showAndWait();
        }
        else {
            productParts.add(selectedPart);
            addProductPartAsso_table.setItems(productParts);
        }

    }

    @FXML

    void cancelAddProduct(MouseEvent event) throws IOException {
        try{
            Stage StageAddPart = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();
        }
        catch (IOException e) {}
    }

    @FXML
    void removeAssociatedPart(MouseEvent event)  {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Associated Part");
        alert.setHeaderText("Confirm that you would like to delete the selected Part");
        alert.setContentText("Press OK to remove the part as associated. \nPress Cancel to cancel this action.");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            try {
                Part selectedPart = addProductPartAsso_table.getSelectionModel().getSelectedItem();
                productParts.remove(selectedPart);
            }
            catch (NullPointerException e) {
                Alert nullalert = new Alert(Alert.AlertType.ERROR);
                nullalert.setTitle("Associated Part Remove Error");
                nullalert.setHeaderText("Associated Part not removed");
                nullalert.setContentText("A part was not selected!");
                nullalert.showAndWait();
            }
        }
        else {
            alert.close();
        }
    }

    @FXML
    void saveAddProduct(MouseEvent event) throws IOException{
        try {
            String name = addProductName_text.getText();
            int stock = Integer.parseInt(addProductINV_text.getText());
            Double price = Double.parseDouble(addProductPrice_text.getText());
            int min = Integer.parseInt(addProductMin_text.getText());
            int max = Integer.parseInt(addProductMax_text.getText());
            ObservableList<Part>  associatedParts = addProductPartAsso_table.getItems();

            if (product.checkProductFields_logic(name,stock,price,max,min, associatedParts) == true)
            {product.checkProductFields(name,stock,price,max,min, associatedParts);}
            else {

                    {
                    /* increments autoid until a nonexistant id is found */
                    do  {
                        autoid++;
                        } while (inventory.lookUpProduct(autoid) != null);

                    product NewProduct = new product(autoid, name, price, stock, min, max);

                    for (Part p: productParts) {
                            NewProduct.addAssociatedPart(p);
                        }
                    inventory.addProducts(NewProduct);



                    }
                    Stage StageAddPart = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                    StageAddPart.setScene(new Scene(SceneAddPart));
                    StageAddPart.show();
                    }
            }
            catch (NumberFormatException e)
            {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("The product was NOT added!");
            alert.setContentText("Please Make sure to only input numbers into the MAX, MIN, INV, and Price fields!");
            alert.showAndWait();
            }
    }









    @FXML
    void addProductSearch(MouseEvent event) {
        String searchPartIDString = addProductSearch_text.getText();
        if (searchPartIDString.trim().isEmpty()) {
            addProductPart_table.setItems(inventory.getAllParts());
        }
        else {
            boolean found=false;
            try {
                Part searchID = inventory.lookUpPart(Integer.parseInt(addProductSearch_text.getText()));

                if (searchID != null) {
                    ObservableList<Part> filteredPartsList = FXCollections.observableArrayList();
                    filteredPartsList.add(searchID);
                    addProductPart_table.setItems(filteredPartsList);
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
                ObservableList<Part> searchtext = inventory.lookUpPart(addProductSearch_text.getText());
                if (!searchtext.isEmpty()){
                    addProductPart_table.setItems(searchtext);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addProductPart_table.setItems(inventory.getAllParts());
        addProductPart_table_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProductPart_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProductPart_table_inv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProductPart_table_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        addProductPartAsso_table_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        addProductPartAsso_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        addProductPartAsso_table_inv.setCellValueFactory(new PropertyValueFactory<>("stock"));
        addProductPartAsso_table_price.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

}
