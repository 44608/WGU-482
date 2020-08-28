package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class AddProductController {

    @FXML
    private AnchorPane addProduct_pane;

    @FXML
    private TableView<?> addProductPart_table;

    @FXML
    private TableColumn<?, ?> addProductPart_table_ID;

    @FXML
    private TableColumn<?, ?> addProductPart_table_name;

    @FXML
    private TableColumn<?, ?> addProductPart_table_inv;

    @FXML
    private TableColumn<?, ?> addProductPart_table_price;

    @FXML
    private TableView<?> addProductPartAsso_table;

    @FXML
    private TableColumn<?, ?> addProductPartAsso_table_ID;

    @FXML
    private TableColumn<?, ?> addProductPartAsso_table_name;

    @FXML
    private TableColumn<?, ?> addProductPartAsso_table_inv;

    @FXML
    private TableColumn<?, ?> addProductPartAsso_table_price;

    @FXML
    private TextField addProductSearch_text;

    @FXML
    private Button addPartADD_button;

    @FXML
    private Button addProductRemove_button;

    @FXML
    private Button addProductCancel_button;

    @FXML
    private Button addproductSave_button;

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

    @FXML
    void addAssociatedPart(MouseEvent event) {

    }

    @FXML
    void cancelAddProduct(MouseEvent event) {

    }

    @FXML
    void removeAssociatedPart(MouseEvent event) {

    }

    @FXML
    void saveAddProduct(MouseEvent event) {

    }

}
