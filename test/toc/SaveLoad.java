/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    
    //Tests if a saved file when loaded maintains the changed state.
    @Test
    public void testSaveLoad() {
        File xx = new File("testFile");
        game.enterChampion("Argon");
        String result = game.toString();
        game.saveGame(xx.toString());
        game = new Tournament("Nick");
        game = game.loadGame(xx.toString());
        String actual = game.toString();
        xx.delete();
        assertEquals(result, actual);
    }
    
    //tests that nothing is changed if a non-existent file is attempted to be loaded.
    @Test
    public void testLoadMissingSaveFile() {
        game.enterChampion("Argon");
        String result = game.toString();
        game = game.loadGame("noneExistent");
        String actual = game.toString();
        assertEquals(result, actual);
    }
}
