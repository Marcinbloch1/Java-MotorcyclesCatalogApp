package pl.polsl.lab.view;
import pl.polsl.lab.model.MotorcyclesList;
import javax.swing.table.AbstractTableModel;

/**
 * Table class creating table and setting up the data
 * @author Marcin Bloch
 * @version 1.1.0
 */
public class Table extends AbstractTableModel {
    /**
     * list of searched motorcycles
     */
    private final MotorcyclesList motorcyclesList;

    /**
     * Constructor of Table class
     * @param motorcyclesList list of motorcycles searched
     */
    public Table(MotorcyclesList motorcyclesList) {
        this.motorcyclesList = motorcyclesList;
    }

    /**
     * sets the amount of rows from size of the list
     * @return the size of list and then sets rows
     */
    @Override
    public int getRowCount() {
        return motorcyclesList.getMotorcyclesList().size();
    }

    /**
     * sets the amount of columns
     * @return sets the amount of columns - 8
     */
    @Override
    public int getColumnCount() {
        return 8;
    }

    /**
     * sets the data of rows
     * @param rowIndex index of current row
     * @param columnIndex index of current column
     * @return setting data in specific row and column
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getParameters().getCategory();
            case 2:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getParameters().getBrand();
            case 3:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getParameters().getModel();
            case 4:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getParameters().getProductionYear();
            case 5:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getPerformance().getEngineCapacity();
            case 6:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getPerformance().getHorsePower();
            case 7:
                return motorcyclesList.getMotorcyclesList().get(rowIndex).getPerformance().getMaxSpeed();
            default:
                return "";
        }
    }

    /**
     * sets columns name
     * @param column index of column
     * @return setting names for specific columns
     */
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Nr";
            case 1: return "Category";
            case 2: return "Brand";
            case 3: return "Model";
            case 4: return "Year";
            case 5: return "EngineCap [cm^3]";
            case 6: return "HP [KM]";
            case 7: return "MaxSpeed [km/h]";
            default: return "";
        }
    }
}
