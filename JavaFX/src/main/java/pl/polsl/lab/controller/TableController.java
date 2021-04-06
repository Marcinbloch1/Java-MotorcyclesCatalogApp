package pl.polsl.lab.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pl.polsl.lab.MyException;
import pl.polsl.lab.model.Motorcycles;
import pl.polsl.lab.model.MotorcyclesList;

/**
 * Class of table view controller
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class TableController {

    /**
     * Motorcycles list. Represents list of searched objects
     */
    private MotorcyclesList motorcyclesList;

    /**
     * Combo box of search categories
     */
    @FXML
    private ComboBox<String> comboBox;

    /**
     * Search text field
     */
    @FXML
    private TextField searchField;

    /**
     * Table of content
     */
    @FXML
    private TableView<Motorcycles> table;

    /**
     * Category column
     */
    @FXML
    private TableColumn<Motorcycles, String> categoryColumn;

    /**
     * Brand column
     */
    @FXML
    private TableColumn<Motorcycles, String> brandColumn;

    /**
     * Model column
     */
    @FXML
    private TableColumn<Motorcycles, String> modelColumn;

    /**
     * Production year column
     */
    @FXML
    private TableColumn<Motorcycles, String> productionYearColumn;

    /**
     * Engine capacity column
     */
    @FXML
    private TableColumn<Motorcycles, Double> engineCapacityColumn;

    /**
     * Horse power column
     */
    @FXML
    private TableColumn<Motorcycles, Integer> horsePowerColumn;

    /**
     * Max speed column
     */
    @FXML
    private TableColumn<Motorcycles, Integer> maxSpeedColumn;

    /**
     * Sets combo box options
     * @param comboBoxOptions available combo box options
     */
    public void setComboBoxOptions(ObservableList<String> comboBoxOptions) {
        comboBox.setItems(comboBoxOptions);
        comboBox.setValue("Category");
    }

    /**
     * Sets data from model to table
     * @param motorcyclesList represents list of searched motorcycles
     */
    public void setModel(MotorcyclesList motorcyclesList) {
        this.motorcyclesList = motorcyclesList;
        ObservableList<Motorcycles> data = FXCollections.observableArrayList(motorcyclesList.getMotorcyclesList());

        categoryColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getParameters().getCategory()));
        brandColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getParameters().getBrand()));
        modelColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getParameters().getModel()));
        productionYearColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getParameters().getProductionYear()));
        engineCapacityColumn.setCellValueFactory(param-> new SimpleObjectProperty<>(param.getValue().getPerformance().getEngineCapacity()));
        horsePowerColumn.setCellValueFactory(param->new SimpleObjectProperty<>(param.getValue().getPerformance().getHorsePower()));
        maxSpeedColumn.setCellValueFactory(param->new SimpleObjectProperty<>(param.getValue().getPerformance().getMaxSpeed()));
        table.setItems(data);

        //table.getItems().setAll(motorcyclesList);
    }

    /**
     * Finds proper data and assigns it to list
     */
    public void getSearchedMotorcyclesList(){
        String option = comboBox.getValue();
        String searchText = searchField.getText();
        try {
            motorcyclesList.getSearchedMotorcycledList(option, searchText);
        } catch (MyException ex) {
            ex.exceptionAlert(ex.getMessage());
        }
        refreshTable();
    }

    /**
     * Refresh data in table
     */
    private void refreshTable() {
        ObservableList<Motorcycles> data = FXCollections.observableArrayList(motorcyclesList.getMotorcyclesList());
        table.setItems(data);
    }
}