package View_Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class ModifyPartController {

    @FXML
    private AnchorPane modifyPart_pane;

    @FXML
    private RadioButton modifyPartOutsourced_radio;

    @FXML
    private ToggleGroup SOURCE;

    @FXML
    private RadioButton modifyPartInHouse_radio;

    @FXML
    private TextField modifyPartName_text;

    @FXML
    private TextField modifyPartPrice_text;

    @FXML
    private TextField modifyPartID_auto;

    @FXML
    private TextField modifyPartINV_text;

    @FXML
    private TextField modifyPartMax_text;

    @FXML
    private TextField modifyPartDynamic_text;

    @FXML
    private TextField modifyPartMin_text;

    @FXML
    private Button modifyPartCancel_button;

    @FXML
    private Button modifyPartSave_button;

    @FXML
    private Label modifyPartDynamic_label;

    @FXML
    void modifyPartCanel(MouseEvent event) {

    }

    @FXML
    void modifyPartSave(MouseEvent event) {

    }

}
