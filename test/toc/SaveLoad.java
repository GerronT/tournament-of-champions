/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author comqaam
 */
public class SaveLoad {
    TOC game;
    
    public SaveLoad() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Nick");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //just a local method to check a String for contents
    
    @Test
    public void testSaveLoad() {
        game.enterChampion("Argon");
        String result = game.toString();
        game.saveGame("testFile");
        game = new Tournament("Nick");
        game = game.loadGame("testFile");
        String actual = game.toString();
        assertEquals(result, actual);
    }
    
    @Test
    public void testLoadMultiple() {
        game.enterChampion("Argon");
        String result = game.toString();
        game.saveGame("testFile1");
        game.saveGame("testFile2");
        game = game.loadGame("testFile1");
        String actual = game.toString();
        assertEquals(result, actual);
    }
    
    @Test
    public void testLoadInvalid() {
        game.enterChampion("Argon");
        String result = game.toString();
        game = game.loadGame("noneExistant");
        String actual = game.toString();
        assertEquals(result, actual);
    }
}
