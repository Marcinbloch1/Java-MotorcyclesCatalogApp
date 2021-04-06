package pl.polsl.lab.controller;

import javafx.collections.ObservableList;
import pl.polsl.lab.model.MotorcyclesList;

import java.io.IOException;

/**
 * Class of controller
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class Controller {
    /**
     * Constructor of controller.
     * @param motorcyclesList represents list of searched motorcycles
     * @param tableController controller of table view
     * @param dataFileName name of data file
     * @param comboBoxOptions available combo box options
     * @throws IOException when there is some problem with loading file
     * @throws ClassNotFoundException when data in file doesn't provide needed information
     */
    public Controller(MotorcyclesList motorcyclesList, TableController tableController,
                      String dataFileName, ObservableList<String> comboBoxOptions)
            throws IOException, ClassNotFoundException {
        tableController.setComboBoxOptions(comboBoxOptions);
        motorcyclesList.loadData(dataFileName);
        tableController.setModel(motorcyclesList);
    }
}