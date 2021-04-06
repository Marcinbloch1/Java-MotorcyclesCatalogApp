package pl.polsl.lab.model;

import pl.polsl.lab.MyException;

import java.io.Serializable;

/**
 * Performance class creating performance fields
 * @author Marcin Bloch
 * @version 1.1.0
 */
public class Performance implements Serializable {
    /**
     * engine capacity of motorcycle field
     */
    private final Double engineCapacity;
    /**
     * horse power of motorcycle field
     */
    private final Integer horsePower;
    /**
     * max speed of motorcycle field
     */
    private final Integer maxSpeed;

    /**
     * Constructor of Performance class
     * @param engineCapacity the engineCapacity of motorcycle
     * @param horsePower the horse power of motorcycle
     * @param maxSpeed the max speed of motorcycle
     */
    /**
     * Constructor of Performance class
     * @param engineCapacity the engineCapacity of mo
     * @param horsePower the horse power of motorcycle
     * @param maxSpeed the max speed of motorcycle
     * @throws MyException when provided data is incorrect
     */
    public Performance(Double engineCapacity, Integer horsePower, Integer maxSpeed) throws MyException {
        checkProvidedData(engineCapacity, horsePower, maxSpeed);
        this.engineCapacity=engineCapacity;
        this.horsePower=horsePower;
        this.maxSpeed=maxSpeed;
    }

    /**
     * Check if provided data is correct
     * @param engineCapacity the engineCapacity of mo
     * @param horsePower the horse power of motorcycle
     * @param maxSpeed the max speed of motorcycle
     * @throws MyException when provided data is incorrect
     */
    private void checkProvidedData(Double engineCapacity, Integer horsePower, Integer maxSpeed) throws MyException {
        if(engineCapacity <= 0){
            throw new MyException("Engine capacity cannot be equal or less than 0");
        }
        else if(horsePower <= 0){
            throw new MyException("Horse power cannot be equal or less than 0");
        }
        else if(maxSpeed <= 0){
            throw new MyException("Max speed cannot be equal or less than 0");
        }
    }

    /**
     * Getter of engineCapacity field
     * @return engineCapacity field
     */
    public Double getEngineCapacity() {
        return engineCapacity;
    }

    /**
     * Getter of horsePower fie
     * @return horsePower field
     */
    public Integer getHorsePower() {
        return horsePower;
    }

    /**
     * Getter of maxSpeed fie
     * @return maxSpeed field
     */
    public Integer getMaxSpeed() {
        return maxSpeed;
    }
}
