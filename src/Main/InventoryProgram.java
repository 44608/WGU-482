package Main;
import java.io.IOException;
import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class InventoryProgram extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/MainScreen.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Requirement G:a compatible feature suitable to your application that would extend functionality to the next version if you were to update the application
     * A future feature to add on to this project would be data persistence. This could mean tying the application to an relational database or just have the ability to ingest and write back to a file locally.
     * @param args
     */
    public static void main(String[] args) {
        inHouse inhouse_part1 = new inHouse(1, "Giant Wrench", 9.99, 1,  1, 5, 42069);
        outSourced outSourced_part1 = new outSourced(2, "Red Hammer", 420.20, 2, 1, 3, "Hammer Time!");
        outSourced outSourced_part2 = new outSourced(3, "Purple Time Modulator", 69.99, 6, 2, 45, "Purple Corp LLC");

        product flux_capacitor = new product(11, "Flux Capacitor", 4999.99, 1000, 0, 9999);
        product time_machine = new product(12, "Time Machine", 3.99, 1, 0, 1);

        inventory.addPart(inhouse_part1);
        inventory.addPart(outSourced_part1);
        inventory.addPart(outSourced_part2);
        inventory.addProducts(flux_capacitor);
        inventory.addProducts(time_machine);

        launch(args);
    }
}
