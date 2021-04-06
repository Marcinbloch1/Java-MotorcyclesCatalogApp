package pl.polsl.lab.model;

import java.io.Serializable;

/**
 * Parameters class creating parameters fields
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class Parameters implements Serializable {
    /**
     * category of motorcycle field
     */
    private final String category;
    /**
     * brand of motorcycle field
     */
    private final String brand;
    /**
     * model of motorcycle field
     */
    private final String model;
    /**
     * productionYear of motorcycle field
     */
    private final String productionYear;

    /**
     * Constructor of Parameters class
     * @param category the category of motorcycle
     * @param brand the brand of motorcycle
     * @param model the model of motorcycle
     * @param productionYear the production year of motorcycle
     */
    public Parameters(String category, String brand, String model, String productionYear){
        this.category=category;
        this.brand=brand;
        this.model=model;
        this.productionYear=productionYear;
    }

    /**
     * Getter of category field
     * @return category field
     */
    public String getCategory(){
        return category;
    }

    /**
     * Getter of brand field
     * @return brand field
     */
    public String getBrand() {return brand;}

    /**
     * Getter of model field
     * @return model field
     */
    public String getModel() {return model;}

    /**
     * Getter of productionYear field
     * @return productionYear field
     */
    public String getProductionYear() {return productionYear;}
}
