package pl.polsl.lab.model;

import org.junit.jupiter.api.Test;

/**
 * Test of Parameters class
 * @author Marcin Bloch
 * @version 1.2.0
 */
class ParametersTest {

    /**
     * Test if creating object works with correct data provided
     */
    @Test
    public void constructorTestCorrectData(){
        new Parameters("Sport", "BMW", "M3", "2015");
    }
}