package pl.polsl.lab.model;

import java.util.ArrayList;
import java.util.List;

/**
 * History list class
 * @author Marcin
 * @version 1.2.0
 */
public class HistoryList {
    
    /**
     * list of search history
     */
    private final List<String> historyList;

    /**
     * Constructor of history list class
     */
    public HistoryList() {
        historyList = new ArrayList<>();
    }

    /**
     * Getter of history lisst
     * @return history list
     */
    public List<String> getHistoryList() {
        return historyList;
    }

    /**
     * Adds item to list
     * @param searchedItem adds it to the list
     */
    public void addToHistoryList(String searchedItem) {
        historyList.add(searchedItem);
    }
}
