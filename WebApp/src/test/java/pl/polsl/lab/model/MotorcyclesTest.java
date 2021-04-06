package pl.polsl.lab.model;

import org.junit.jupiter.api.Test;
import pl.polsl.lab.exception.MyException;

/**
 * Test of Motorcycles class
 * @author Marcin Bloch
 * @version 1.2.0
 */
class MotorcyclesTest {

    /**
     * Test if creating object works with correct data provided
     * @throws MyException when incorrect data provided
     */
    @Test
    public void constructorTestCorrectData() throws MyException {
        new Motorcycles(new Parameters("Sport", "BMW", "M3", "2015"),
                new Performance(100.0, 100, 100));
    }
}