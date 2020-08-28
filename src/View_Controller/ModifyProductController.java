package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class ModifyProductController {

    @FXML
    private AnchorPane modifyProduct_pane;

    @FXML
    private TableView<?> modifyProductPart_table;

    @FXML
    private TableColumn<?, ?> modifyProductPart_table_ID;

    @FXML
    private TableColumn<?, ?> modifyProductPart_table_name;

    @FXML
    private TableColumn<?, ?> modifyProductPart_table_INV;

    @FXML
    private TableColumn<?, ?> modifyProductPart_table_price;

    @FXML
    private TableView<?> modifyProductAssoPart_table;

    @FXML
    private TableColumn<?, ?> modifyProductAssoPart_table_ID;

    @FXML
    private TableColumn<?, ?> modifyProductAssoPart_table_name;

    @FXML
    private TableColumn<?, ?> modifyProductAssoPart_table_INV;

    @FXML
    private TableColumn<?, ?> modifyProductAssoPart_table_price;

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
    void modifyProductAdd(MouseEvent event) {

    }

    @FXML
    void modifyProductCancel(MouseEvent event) {

    }

    @FXML
    void modifyProductRemove(MouseEvent event) {

    }

    @FXML
    void modifyProductSave(MouseEvent event) {

    }

}
