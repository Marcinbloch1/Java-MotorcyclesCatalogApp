package pl.polsl.lab.controller;

import pl.polsl.lab.MyException;
import pl.polsl.lab.model.MotorcyclesList;
import pl.polsl.lab.view.Gui;

import java.io.IOException;

/**
 * Class of controller
 * @author Marcin Bloch
 * @version 1.1.0
 */
public class Controller {
    /**
     * Motorcycles list. Represents list of searched objects
     */
    private final MotorcyclesList motorcyclesList;
    /**
     * Gui of application
     */
    private final Gui gui;

    /**
     * Constructor of controller.
     * @param gui represents gui of application
     * @param motorcyclesList represents list of searched motorcycles
     * @param dataFileName name of data file
     * @throws IOException when there is some problem with loading file
     * @throws ClassNotFoundException when data in file doesn't provide needed information
     */
    public Controller(Gui gui, MotorcyclesList motorcyclesList, String dataFileName) throws IOException, ClassNotFoundException {
        this.gui=gui;
        this.motorcyclesList=motorcyclesList;
        motorcyclesList.loadData(dataFileName);
        setMotorcyclesList(motorcyclesList);
        multiListener();
    }

    /**
     * Listener of user input
     */
    public void multiListener() {
        gui.getSearchButton().addActionListener(e -> {
            String option=(String)gui.getComboBox1().getSelectedItem();
            String searchText=gui.getSearchField().getText();
            try {
                motorcyclesList.getSearchedMotorcycledList(option, searchText);
            } catch (MyException ex) {
                System.out.println(ex.getMessage());
            }
            gui.refreshTableModel(motorcyclesList.getMotorcyclesList().size());
        });
    }

    /**
     * Sets table model
     * @param motorcyclesList represents list of searched motorcycles
     */
    public void setMotorcyclesList(MotorcyclesList motorcyclesList){
        gui.setTableModel(motorcyclesList);
    }
}