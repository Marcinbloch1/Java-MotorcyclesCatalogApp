package pl.polsl.lab.model;

import org.junit.jupiter.api.Test;
import pl.polsl.lab.MyException;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test of Performance class
 * @author Marcin Bloch
 * @version 1.2.0
 */
class PerformanceTest {

    /**
     * Test if exception is thrown when provided negative value of engine capacity
     */
    @Test
    void constructorTestNegativeValueEngineCapacity() {
        try{
            new Performance(-100.0, 100, 100);
            fail("An exception should be thrown because of negative engine capacity value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided negative value of horse power
     */
    @Test
    void constructorTestNegativeValueHorsePower() {
        try{
            new Performance(100.0, -100, 100);
            fail("An exception should be thrown because of negative horse power value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided negative value of max speed
     */
    @Test
    void constructorTestNegativeValueMaxSpeed() {
        try{
            new Performance(100.0, 100, -100);
            fail("An exception should be thrown because of negative max speed value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided zero value of engine capacity
     */
    @Test
    void constructorTestZeroValueEngineCapacity() {
        try{
            new Performance(0.0, 100, 100);
            fail("An exception should be thrown because of zero engine capacity value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided zero value of horse power
     */
    @Test
    void constructorTestZeroValueHorsePower() {
        try{
            new Performance(100.0, 0, 100);
            fail("An exception should be thrown because of zero horse power value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided zero value of max speed
     */
    @Test
    void constructorTestZeroValueMaxSpeed() {
        try{
            new Performance(100.0, 100, 0);
            fail("An exception should be thrown because of zero max speed value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if creating object works with correct data provided
     */
    @Test
    void constructorTestCorrectData() {
        try{
            new Performance(100.0, 100, 100);
        } catch (MyException e) {
            fail("An exception shouldn't be thrown because of correct data");
        }
    }

    /**
     * Test if exception is thrown when provided null engine capacity
     */
    @Test
    void constructorTestNullEngineCapacity() {
        try{
            new Performance(null, 100, 100);
            fail("An exception should be thrown because of null engine capacity value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided null horse power
     */
    @Test
    void constructorTestNullHorsePower() {
        try{
            new Performance(100.0, null, 100);
            fail("An exception should be thrown because of null horse power value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test if exception is thrown when provided null max speed
     */
    @Test
    void constructorTestNullMaxSpeed() {
        try{
            new Performance(100.0, 100, null);
            fail("An exception should be thrown because of null max speed value");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}