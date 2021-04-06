package pl.polsl.lab.model;

import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.lab.db.DatabaseProvider;
import pl.polsl.lab.exception.MyException;

/**
 * Class represents list of objects of Motorcycles class
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class MotorcyclesList implements Serializable {
    /**
     * motorcyclesList attribute represents list of motorcycles
     * that will be used to display searched data
     */
    private List<Motorcycles> motorcyclesList;
    /**
     * motorcyclesOriginalList represents list of motorcycles.
     * It is always the whole data
     */
    private List<Motorcycles> motorcyclesOriginalList;

    /**
     * Constructor of class
     */
    public MotorcyclesList() {
    }

    /**
     * getter of motorcyclesList
     * @return list of motorcycles
     */
    public List<Motorcycles> getMotorcyclesList() {
        return motorcyclesList;
    }

    /**
     * Loading data into motorcycles list
     * @throws MyException
     */
    public void loadData() throws MyException, Exception{
       motorcyclesOriginalList = new ArrayList<>();
        
        ResultSet motorcyclesResultSet = DatabaseProvider.query("select * from params join performance on params.id=performance.paramsid");
        
        while(motorcyclesResultSet.next()){
            motorcyclesOriginalList.add(new Motorcycles(new Parameters(motorcyclesResultSet.getString("category"), 
            motorcyclesResultSet.getString("brand"), motorcyclesResultSet.getString("model"), 
            motorcyclesResultSet.getString("productionyear")), 
            new Performance(motorcyclesResultSet.getDouble("enginecapacity"), 
            motorcyclesResultSet.getInt("horsepower"), motorcyclesResultSet.getInt("maxspeed"))));
        }

        motorcyclesList = new ArrayList<>(motorcyclesOriginalList);
    }

    /**
     * Finds proper data and assigns it to list
     * @param option the choice of data category which will be used to
     *               search specific data category. Choice is made by user
     * @param searchText text that user typed in. It will be used to find element
     * @throws MyException throws exception if list is empty
     */
    public void getSearchedMotorcycledList(String option, String searchText) throws MyException{
        motorcyclesList.clear();
        if(option == null){
            throw new MyException("Category cannot be null");
        }
        switch(option){
            case "Category":
                findByCategory(searchText);
                break;
            case "Brand":
                findByBrand(searchText);
                break;
            case "Model":
                findByModel(searchText);
                break;
            case "ProductionYear":
                findByProductionYear(searchText);
                break;
            case "EngineCapacity":
                findByEngineCapacity(searchText);
                break;
            case "HorsePower":
                findByHorsePower(searchText);
                break;
            case "MaxSpeed":
                findByMaxSpeed(searchText);
                break;
            default:
                throw new MyException("There is no such category");
        }
        if(motorcyclesList.isEmpty()){
            throw new MyException("There is no such item");
        }
    }

    /**
     * Finds specific motorcycles by MaxSpeed and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByMaxSpeed(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> String.valueOf(motorcycles.getPerformance().getMaxSpeed()).contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }

    /**
     * Finds specific motorcycles by HorsePower and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByHorsePower(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> String.valueOf(motorcycles.getPerformance().getHorsePower()).contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }

    /**
     * Finds specific motorcycles by EngineCapacity and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByEngineCapacity(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> String.valueOf(motorcycles.getPerformance().getEngineCapacity()).contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }

    /**
     * Finds specific motorcycles by ProductionYear and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByProductionYear(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> motorcycles.getParameters().getProductionYear().contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }

    /**
     * Finds specific motorcycles by Model and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByModel(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> motorcycles.getParameters().getModel().contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }

    /**
     * Finds specific motorcycles by Brand and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByBrand(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> motorcycles.getParameters().getBrand().contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }

    /**
     * Finds specific motorcycles by Category and adds it to motorcyclesList
     * @param searchText text that user typed in. It will
     *                   be used to find element
     */
    private void findByCategory(String searchText) {
        motorcyclesOriginalList.stream()
                .filter(motorcycles -> motorcycles.getParameters().getCategory().contains(searchText))
                .forEach(motorcycles -> motorcyclesList.add(motorcycles));
    }
}