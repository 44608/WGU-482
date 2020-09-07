package View_Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddPartController  implements Initializable {


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
    private boolean OutSourced_check;

    @FXML
    private int autoid = 1;

    @FXML
    private String ErrorChecker = new String();



    @FXML
    void cancelAddPart(MouseEvent event) throws IOException {

            Stage StageAddPart = (Stage)((Button)event.getSource()).getScene().getWindow();
            Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            StageAddPart.setScene(new Scene(SceneAddPart));
            StageAddPart.show();

    }



    @FXML
    void saveAddPart(MouseEvent event) throws IOException {
        try {
            String name = addPartName_text.getText();
            int stock = Integer.parseInt(addPartInventory_text.getText());
            Double price = Double.parseDouble(addPartPrice_text.getText());
            int min = Integer.parseInt(addPartMin_text.getText());
            int max = Integer.parseInt(addPartMax_text.getText());
            String source_input = addPartDynamic_text.getText();

            if (Part.checkPartFields_logic(name,stock,price,max,min) == true)
            {Part.checkPartFields(name,stock,price,max,min);}
            else {

                {
                    /* increments autoid until a nonexistant id is found */
                    do {
                        autoid++;
                    } while (inventory.lookUpPart(autoid) != null);


                    if (OutSourced_check == true) {
                        outSourced NewOutSourcedPart = new outSourced(autoid, name, price, stock, min, max, source_input);

                        inventory.addPart(NewOutSourcedPart);
                    } else {
                        int inHouse_input = Integer.parseInt(addPartDynamic_text.getText());
                        inHouse NewInHousePart = new inHouse(autoid, name, price, stock, min, max, inHouse_input);
                        inventory.addPart(NewInHousePart);
                    }

                    Stage StageAddPart = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    Parent SceneAddPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
                    StageAddPart.setScene(new Scene(SceneAddPart));
                    StageAddPart.show();
                }
            }
        }
        catch (NumberFormatException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR!");
        alert.setHeaderText("The part was NOT added!");
        alert.setContentText("Please only input numbers for INV, Min, Max, Price");
        alert.showAndWait();
        }


            }


    @FXML
    void setTGSource(ActionEvent event) {
        if (SOURCE.getSelectedToggle() == addPartInHouse_radio) {
            addPartDynamic_label.setText("Machine ID");
            addPartDynamic_text.setPromptText("Machine ID");
        }
        else {
            addPartDynamic_label.setText("Company Name");
            addPartDynamic_text.setPromptText("Company Name");
            OutSourced_check = true;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }


}
