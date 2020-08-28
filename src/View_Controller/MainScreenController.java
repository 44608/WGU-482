
package View_Controller;

import Model.Part;
import Model.product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainScreenController {


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


    void addPartMain(MouseEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddParts.fxml"));
            Parent addPartScreen = loader.load();
            Scene addPartScene = new Scene(addPartScreen);
            Stage winAddPart = (Stage)((Node)eAddParts.getSource()).getScene().getWindow();
            winAddPart.setTitle("Add Part");
            winAddPart.setScene(addPartScene);
            winAddPart.show();
        }
        catch (IOException e) {}
    }


        @FXML
    void addProductMain(MouseEvent event) {

    }

    @FXML
    void deletePartMain(MouseEvent event) {

    }

    @FXML
    void deleteProductMain(MouseEvent event) {

    }

    @FXML
    void exitMain(MouseEvent event) {

    }

    @FXML
    void modifyPartMain(MouseEvent event) {

    }

    @FXML
    void modifyProductMain(MouseEvent event) {

    }

    @FXML
    void searchPartMain(MouseEvent event) {

    }

    @FXML
    void searchProductMain(MouseEvent event) {

    }

}
