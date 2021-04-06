package pl.polsl.lab.view;

import pl.polsl.lab.model.MotorcyclesList;

import javax.swing.*;

/**
 * Class of project gui
 * @author Marcin Bloch
 * @version 1.1.0
 */
public class Gui extends JFrame {
    /**
     * Main panel of gui
     */
    private JPanel mainPanel;
    /**
     * Combo box of search categories
     */
    private JComboBox comboBox1;
    /**
     * Search button
     */
    private JButton searchButton;
    /**
     * Search text field
     */
    private JTextField searchField;
    /**
     * Table of content
     */
    private JTable table1;

    /**
     * Constructor of Gui.
     * Sets up all visible content
     * @param operationsList1 list of strings that represents
     *                        searching options
     */
    public Gui(String[] operationsList1){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        comboBox1.setModel(new DefaultComboBoxModel(operationsList1));
        editTable();
        this.pack();
        this.setVisible(true);
        this.setSize(1000, 700);
    }

    /**
     * Getter of searchButton
     * @return searchButton
     */
    public JButton getSearchButton() {return searchButton;}

    /**
     * Getter of ComboBox
     * @return comboBox option
     */
    public JComboBox getComboBox1() {return comboBox1;}

    /**
     * Getter of searchField
     * @return text of searchField
     */
    public JTextField getSearchField() {
        return searchField;
    }

    /**
     * Edits table to make it scrollable
     */
    private void editTable() {
        table1.getScrollableTracksViewportWidth();
        table1.getScrollableTracksViewportHeight();
    }

    /**
     * Sets the model of table
     * @param motorcyclesList list of motorcycles used
     *                        to create table view
     */
    public void setTableModel(MotorcyclesList motorcyclesList){
        table1.setModel(new Table(motorcyclesList));
    }

    /**
     * Refreshes table data model
     * @param size size of table model
     */
    public void refreshTableModel(int size){
        ((Table)table1.getModel()).fireTableRowsDeleted(size, size);
        ((Table)table1.getModel()).fireTableRowsInserted(size, size);
        ((Table)table1.getModel()).fireTableRowsUpdated(size, size);
    }
}