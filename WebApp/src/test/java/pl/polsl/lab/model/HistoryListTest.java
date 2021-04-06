/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.polsl.lab.model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marcin
 */
public class HistoryListTest {
    
    public HistoryListTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getHistoryList method, of class HistoryList.
     */
    @Test
    public void testGetHistoryList() {
        System.out.println("getHistoryList");
        HistoryList instance = new HistoryList();
        List<String> expResult = null;
        List<String> result = instance.getHistoryList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToHistoryList method, of class HistoryList.
     */
    @Test
    public void testAddToHistoryList() {
        System.out.println("addToHistoryList");
        String searchedItem = "";
        HistoryList instance = new HistoryList();
        instance.addToHistoryList(searchedItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
