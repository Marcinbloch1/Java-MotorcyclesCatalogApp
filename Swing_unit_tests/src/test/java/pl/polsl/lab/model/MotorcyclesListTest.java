package pl.polsl.lab.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pl.polsl.lab.MyException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test of MotorcyclesList class
 * @author Marcin Bloch
 * @version 1.0.0
 */
class MotorcyclesListTest {
    /**
     * Motorcycles list field
     */
    private MotorcyclesList motorcyclesList;

    /**
     * Loading data to list before every test
     * @throws IOException when there is some problem with loading file
     * @throws ClassNotFoundException when data in file doesn't provide needed information
     */
    @BeforeEach
    public void setUp() throws IOException, ClassNotFoundException {
        motorcyclesList = new MotorcyclesList();
        motorcyclesList.loadData("motorcyclesData");
    }

    /**
     * Loading data with correct file
     */
    @Test
    public void loadDataCorrectFileName() {
        motorcyclesList.getMotorcyclesList().clear();
        try{
            motorcyclesList.loadData("motorcyclesData");
        } catch (IOException | ClassNotFoundException e) {
            fail("An exception shouldn't be thrown because of correct file");
        }
    }

    /**
     * Loading data with nonexistent file
     */
    @Test
    public void loadDataWrongFileName() {
        try{
            motorcyclesList.loadData("motor");
            fail("An exception should be thrown because of nonexistent file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loading data with correct file but without needed object in this file
     */
    @Test
    public void loadDataWrongData() {
        try{
            motorcyclesList.loadData("motorcyclesDataEmptyFile");
            fail("An exception should be thrown because of wrong data in the file");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Providing empty list which causes exception
     */
    @Test
    public void getSearchedMotorcycledListEmptyList() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Category", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting searched motorcycles but with wrong category
     * Should thrown exception
     */
    @Test
    public void getSearchedMotorcycledListWrongCategory() {
        try{
            motorcyclesList.getSearchedMotorcycledList("WrongCategory", "Sport");
            fail("An exceptions should be thrown due to wrong category name");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting searched motorcycles with correct category
     */
    @Test
    public void getSearchedMotorcycledListCorrect() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Category", "Sport");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Checks if every category works
     * @param option category provided to test
     */
    @ParameterizedTest
    @ValueSource(strings = {"Category", "Brand", "Model", "ProductionYear", "EngineCapacity", "HorsePower", "MaxSpeed"})
    void getSearchedMotorcycleListCorrectOptions(String option) {
        try{
            motorcyclesList.getSearchedMotorcycledList(option, "");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByCategoryWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Category", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByBrandWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Brand", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByModelWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Model", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByProductionYearWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("ProductionYear", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByEngineCapacityWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("EngineCapacity", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByHorsePowerWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("HorsePower", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Wrong search data provided
     */
    @Test
    public void findByMaxSpeedWrongData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("MaxSpeed", "NotExisting");
            fail("An exception should be thrown due to empty search list");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByCategoryCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Category", "Sport");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByBrandCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Brand", "BMW");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByModelCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("Model", "0D02");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByProductionYearCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("ProductionYear", "2014");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByEngineCapacityCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("EngineCapacity", "999.0");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByHorsePowerCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("HorsePower", "160");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * Correct search data provided
     */
    @Test
    public void findByMaxSpeedCorrectData() {
        try{
            motorcyclesList.getSearchedMotorcycledList("MaxSpeed", "312");
        } catch (MyException e) {
            fail("An exceptions shouldn't be thrown because of correct data input");
        }
    }

    /**
     * After every test motorcycles list is set to null
     */
    @AfterEach
    public void tearDown() {
        motorcyclesList = null;
    }
}