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
public class LoadChallengesTest {
    TOC game;
    private static final File savePath = new File(System.getProperty("user.dir") + "/TestFiles/");
    
    public LoadChallengesTest() {
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
    
    // Tests loading challenges to tournament from text file
    @Test
    public void testLoadChallengesFromFile() {
    	game = new Tournament("Gerron", new File(savePath, "challengesValid.txt").toString());
    	String[] challengeEnemies = {"Borg", "Huns", "Ferengi", "Vandals", "Borg", "Goths", "Franks", "Sith"};
    	assertTrue(Utility.containsText(game.getAllChallenges(), challengeEnemies));
    }
    
    // Test where one challenge data uses unparsable value for prize
    // This challenge should not be added but the rest of the data should be unaffected
    @Test
    public void testIncorrectDataType() {
    	// Vandals should not be added
    	// Vandals data: Magic,Vandals,9,two hundred
    	game = new Tournament("Gerron", new File(savePath, "challengesWithIncorrectDataType.txt").toString());
    	String[] challengeEnemies = {"Borg", "Huns", "Ferengi", "Borg", "Goths", "Franks", "Sith"};
    	String challenges = game.getAllChallenges();
    	boolean result = Utility.containsText(challenges, challengeEnemies) && !challenges.contains("Vandals");
    	assertTrue(result);
    }
    
    // Test where one challenge data uses an invalid Challenge type
    // This challenge should not be added but the rest of the data should be unaffected
    @Test
    public void testInvalidChallengeType() {
    	// Sith should not be added
    	// Sith data: Mythical,Sith,10,150
    	game = new Tournament("Gerron", new File(savePath, "challengesWithInvalidChallengeType.txt").toString());
    	String[] challengeEnemies = {"Borg", "Huns", "Ferengi", "Vandals", "Borg", "Goths", "Franks"};
    	String challenges = game.getAllChallenges();
    	boolean result = Utility.containsText(challenges, challengeEnemies) && !challenges.contains("Sith");
    	assertTrue(result);
    }
    
    // Test where one challenge data is missing some fields.
    // This challenge should not be added but the rest of the data should be unaffected
    @Test
    public void testIncompleteChallengeData() {
    	// Huns should not be added
    	// Huns data: Fight,Huns
    	game = new Tournament("Gerron", new File(savePath, "challengesWithIncompleteData.txt").toString());
    	String[] challengeEnemies = {"Borg", "Ferengi", "Vandals", "Borg", "Goths", "Franks", "Sith"};
    	String challenges = game.getAllChallenges();
    	boolean result = Utility.containsText(challenges, challengeEnemies) && !challenges.contains("Huns");
    	assertTrue(result);
    }
    
    // Tests loading challenges file that doesn't exist
    @Test
    public void testLoadMissingChallenge() {
    	game = new Tournament("Gerron", new File(savePath, "nonExistent.txt").toString());
    	String[] challengeEnemies = {"Borg", "Huns", "Ferengi", "Vandals", "Borg", "Goths", "Franks", "Sith"};
    	assertFalse(Utility.containsText(game.getAllChallenges(), challengeEnemies));
    }
    
}
