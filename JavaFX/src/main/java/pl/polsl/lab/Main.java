package pl.polsl.lab;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.polsl.lab.controller.Controller;
import pl.polsl.lab.controller.TableController;
import pl.polsl.lab.model.MotorcyclesList;

/**
 * Main class
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class Main extends Application {

    /**
     * Start of javafx application
     * @param primaryStage primary stage of gui
     * @throws Exception when unexpected error
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        String dataFileName="motorcyclesData";
        ObservableList<String> comboBoxOptions =
                FXCollections.observableArrayList(
                        "Category",
                        "Brand",
                        "Model",
                        "ProductionYear",
                        "EngineCapacity",
                        "HorsePower",
                        "MaxSpeed"
                );

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
        Parent root = loader.load();
        TableController ctrl = loader.getController();
        new Controller(new MotorcyclesList(), ctrl, dataFileName, comboBoxOptions);
        primaryStage.setTitle("Motorcycles Catalog");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * Constructor of main
     * @param args no parameters in command line used
     */
    public static void main(String[] args) {
        launch(args);
    }
}
