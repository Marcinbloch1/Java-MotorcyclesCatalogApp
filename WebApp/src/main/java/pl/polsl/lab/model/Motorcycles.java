package pl.polsl.lab.model;

import java.io.Serializable;

/**
 * Motorcycles class uses Parameters class
 * class to create objects of motorcycles and Performance
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class Motorcycles implements Serializable {
    /**
     * parameters attribute represents data parameters of motorcycles
     */
    private final Parameters parameters;
    /**
     * performance attribute represents data performance of motorcycles
     */
    private final Performance performance;

    /**
     * Constructor of class Motorcycles
     * @param parameters the parameters data of motorcycles
     * @param performance the performance data of motorcycles
     */
    public Motorcycles(Parameters parameters, Performance performance){
        this.parameters=parameters;
        this.performance=performance;
    }

    /**
     * Getter of parameters
     * @return parameters information
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * Getter of performance
     * @return performance information
     */
    public Performance getPerformance() {
        return performance;
    }
}
