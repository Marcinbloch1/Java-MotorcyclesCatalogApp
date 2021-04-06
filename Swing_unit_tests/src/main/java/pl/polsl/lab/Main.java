package pl.polsl.lab;

import pl.polsl.lab.controller.Controller;
import pl.polsl.lab.model.MotorcyclesList;
import pl.polsl.lab.view.Gui;

import java.io.IOException;

/**
 * Main class
 * @author Marcin Bloch
 * @version 1.1.0
 */
public class Main {
    /**
     * Constructor of main
     * @param args no parameters in command line used
     * @throws IOException when there is some problem with loading file
     * @throws ClassNotFoundException when data in file doesn't provide needed information
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MotorcyclesList motorcyclesList = new MotorcyclesList();
        String[]operationsList1 = {"Category", "Brand", "Model", "ProductionYear", "EngineCapacity", "HorsePower", "MaxSpeed"};
        String dataFileName="motorcyclesData";
        Gui frame = new Gui(operationsList1);
        new Controller(frame, motorcyclesList, dataFileName);
    }
}