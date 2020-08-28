package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AddPartController  {


    @FXML
    private AnchorPane addPart_pane;

    @FXML
    private RadioButton addPartOutSourced_radio;

    @FXML
    private ToggleGroup SOURCE;

    @FXML
    private RadioButton addPartInHouse_radio;

    @FXML
    private TextField addPartName_text;

    @FXML
    private TextField addPartPrice_text;

    @FXML
    private TextField addPartID_auto;

    @FXML
    private TextField addPartInventory_text;

    @FXML
    private TextField addPartMax_text;

    @FXML
    private TextField addPartDynamic_text;

    @FXML
    private TextField addPartMin_text;

    @FXML
    private Button addPartCancel_button;

    @FXML
    private Button addPartSave_button;

    @FXML
    private Label addPartDynamic_label;

    @FXML
    void cancelAddPart(MouseEvent event) {

    }

    @FXML
    void saveAddPart(MouseEvent event) {

    }

}
