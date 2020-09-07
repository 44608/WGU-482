package View_Controller;

import Model.Part;
import Model.inHouse;
import Model.inventory;
import Model.outSourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import static Model.inventory.deletePart;
import static Model.inventory.lookUpPart;


public class ModifyPartController implements Initializable {

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
    private boolean OutSourced_check;

    @FXML
    void modifyPartCancel(MouseEvent event) throws IOException {
        try{
            Stage StageAddPart = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();
        }
        catch (IOException e) {}
    }

    @FXML
    void modifyPartSave(MouseEvent event) throws IOException {
        try {
            int id = Integer.parseInt(modifyPartID_auto.getText());
            String name = modifyPartName_text.getText();
            int stock = Integer.parseInt(modifyPartINV_text.getText());
            Double price = Double.parseDouble(modifyPartPrice_text.getText());
            int min = Integer.parseInt(modifyPartMin_text.getText());
            int max = Integer.parseInt(modifyPartMax_text.getText());
            String source_input = modifyPartDynamic_text.getText();

            if (Part.checkPartFields_logic(name,stock,price,max,min) == true)
            {Part.checkPartFields(name,stock,price,max,min);}
            else {

                    if (OutSourced_check == true) {

                        outSourced NewOutSourcedPart = new outSourced(id, name, price, stock, min, max, source_input);

                        inventory.updatePart(id,NewOutSourcedPart);
                    } else {
                        int inHouse_input = Integer.parseInt(modifyPartDynamic_text.getText());

                        inHouse NewInHousePart = new inHouse(id, name, price, stock, min, max, inHouse_input);

                        inventory.updatePart(id,NewInHousePart);
                    }

                    Stage StageAddPart = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                    StageAddPart.setScene(new Scene(SceneAddPart));
                    StageAddPart.show();

            }
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR!!!");
            alert.setHeaderText("The part was NOT Modified!!");
            alert.setContentText("Please only input numbers into INV, MIN, MAX, PRICE");
            alert.showAndWait();
        }


    }

    @FXML
    void setTGSource(ActionEvent event) {
        if (SOURCE.getSelectedToggle() == modifyPartInHouse_radio) {
            modifyPartDynamic_label.setText("Machine ID");
            modifyPartDynamic_text.setPromptText("Machine ID");
        }
        else {
            modifyPartDynamic_label.setText("Company Name");
            modifyPartDynamic_text.setPromptText("Company Name");
            OutSourced_check = true;
        }
    }

    public void loadSelected (Part modifyPart)
    {

        int selectedPart_ID = modifyPart.getId();
        modifyPartID_auto.setText(String.valueOf(selectedPart_ID));
        modifyPartName_text.setText(modifyPart.getName());
        modifyPartINV_text.setText(Integer.toString(modifyPart.getStock()));
        modifyPartPrice_text.setText(Double.toString(modifyPart.getPrice()));
        modifyPartMax_text.setText(Integer.toString(modifyPart.getMax()));
        modifyPartMin_text.setText(Integer.toString(modifyPart.getMin()));
        if (modifyPart  instanceof inHouse) {
            SOURCE.selectToggle(modifyPartInHouse_radio);
            modifyPartDynamic_text.setText(Integer.toString(((inHouse) modifyPart).getMachineID()));
            OutSourced_check= false;
        }
        else {
            SOURCE.selectToggle(modifyPartOutsourced_radio);
            modifyPartDynamic_text.setText(((outSourced) modifyPart ).getCompanyName());
            modifyPartDynamic_label.setText("Company Name");

            OutSourced_check = true;
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }



}
