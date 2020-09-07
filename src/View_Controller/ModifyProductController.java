package View_Controller;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

import static Model.inventory.*;

public class ModifyProductController implements Initializable {

    @FXML
    private AnchorPane modifyProduct_pane;

    @FXML
    private TableView<Part> modifyProductPart_table;

    @FXML
    private TableColumn<Part, Integer> modifyProductPart_table_ID;

    @FXML
    private TableColumn<Part, String> modifyProductPart_table_name;

    @FXML
    private TableColumn<Part, Integer> modifyProductPart_table_INV;

    @FXML
    private TableColumn<Part, Double> modifyProductPart_table_price;

    @FXML
    private TableView<Part> modifyProductAssoPart_table;

    @FXML
    private TableColumn<Part, Integer> modifyProductAssoPart_table_ID;

    @FXML
    private TableColumn<Part, String> modifyProductAssoPart_table_name;

    @FXML
    private TableColumn<Part, Integer> modifyProductAssoPart_table_INV;

    @FXML
    private TableColumn<Part, Double> modifyProductAssoPart_table_price;

    @FXML
    private TextField modifyProductSearch_text;

    @FXML
    private Button modifyProductAdd_button;

    @FXML
    private Button modifyProductRemove_button;

    @FXML
    private Button modifyProductCancel_button;

    @FXML
    private Button modifyProductSave_button;

    @FXML
    private TextField modifyProductID_auto;

    @FXML
    private TextField modifyProductName_text;

    @FXML
    private TextField modifyProductINV_text;

    @FXML
    private TextField modifyProductPrice_text;

    @FXML
    private TextField modifyProductMax_text;

    @FXML
    private TextField modifyProductMin_text;

    @FXML
    private Button modifyProductSearch_button;




    @FXML
    void modifyProductAdd(MouseEvent event) {

        Part selectedPart = modifyProductPart_table.getSelectionModel().getSelectedItem();
        if (selectedPart == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error! No Parts Selected");
            alert.setHeaderText("The part was not added!");
            alert.setContentText("A part must be selected from the table in order to be added");
            alert.showAndWait();
        }
        else {
            product loadedProduct = inventory.lookUpProduct(Integer.parseInt(modifyProductID_auto.getText()));
            loadedProduct.addAssociatedPart(selectedPart);
            modifyProductAssoPart_table.setItems(loadedProduct.getAssociatedPartsList());
        }

    }

    @FXML
    void modifyProductCancel(MouseEvent event) throws IOException {
        try{
            Stage StageAddPart = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();
        }
        catch (IOException e) {}
    }

    @FXML
    void modifyProductRemove(MouseEvent event)  {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Associated Part");
        alert.setHeaderText("Are you sure you want to delete the associated part?");
        alert.setContentText("Press OK to delete the associated part. \nPress Cancel to cancel the deletion.");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.OK) {
            try {
                product loadedProduct = inventory.lookUpProduct(Integer.parseInt(modifyProductID_auto.getText()));
                Part selectedPart = modifyProductAssoPart_table.getSelectionModel().getSelectedItem();
                loadedProduct.removeAssociatedPart(selectedPart.getId());
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
    void modifyProductSave(MouseEvent event) throws IOException {
        try {
            String name = modifyProductName_text.getText();
            int stock = Integer.parseInt(modifyProductINV_text.getText());
            Double price = Double.parseDouble(modifyProductPrice_text.getText());
            int min = Integer.parseInt(modifyProductMin_text.getText());
            int max = Integer.parseInt(modifyProductMax_text.getText());
            ObservableList<Part>  associatedParts = modifyProductAssoPart_table.getItems();

            if (product.checkProductFields_logic(name,stock,price,max,min, associatedParts) == true)
            {product.checkProductFields(name,stock,price,max,min, associatedParts);}
            else {

                {
                    int autoid = Integer.parseInt(modifyProductID_auto.getText());
                    deleteProduct(inventory.lookUpProduct(autoid));
                    product NewProduct = new product(autoid, name, price, stock, min, max);


                    for (Part p: associatedParts) {
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Product Add Warning");
            alert.setHeaderText("The product was NOT added!");
            alert.setContentText("Please Make sure to only input numbers into the MAX, MIN, INV, and Price fields!");
            alert.showAndWait();
        }
    }

    @FXML
    void modifyProductSearch(MouseEvent event) {
        String searchPartIDString = modifyProductSearch_text.getText();
        if (searchPartIDString.trim().isEmpty()) {
            modifyProductPart_table.setItems(inventory.getAllParts());
        }
        else {
            boolean found=false;
            try {
                Part searchID = inventory.lookUpPart(Integer.parseInt(modifyProductSearch_text.getText()));

                if (searchID != null) {
                    ObservableList<Part> filteredPartsList = FXCollections.observableArrayList();
                    filteredPartsList.add(searchID);
                    modifyProductPart_table.setItems(filteredPartsList);
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
                ObservableList<Part> searchtext = inventory.lookUpPart(modifyProductSearch_text.getText());
                if (!searchtext.isEmpty()){
                    modifyProductPart_table.setItems(searchtext);
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

    public void loadSelectedProduct (product modifyProduct)
    {

        int selectedPart_ID = modifyProduct.getId();
        modifyProductID_auto.setText(String.valueOf(selectedPart_ID));
        modifyProductName_text.setText(modifyProduct.getName());
        modifyProductINV_text.setText(Integer.toString(modifyProduct.getStock()));
        modifyProductPrice_text.setText(Double.toString(modifyProduct.getPrice()));
        modifyProductMax_text.setText(Integer.toString(modifyProduct.getMax()));
        modifyProductMin_text.setText(Integer.toString(modifyProduct.getMin()));


        modifyProductAssoPart_table.setItems(modifyProduct.getAssociatedPartsList());
        modifyProductAssoPart_table_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductAssoPart_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductAssoPart_table_INV.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyProductAssoPart_table_price.setCellValueFactory(new PropertyValueFactory<>("price"));

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {

        modifyProductPart_table.setItems(inventory.getAllParts());


        modifyProductPart_table_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
        modifyProductPart_table_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        modifyProductPart_table_INV.setCellValueFactory(new PropertyValueFactory<>("stock"));
        modifyProductPart_table_price.setCellValueFactory(new PropertyValueFactory<>("price"));

    }


}
