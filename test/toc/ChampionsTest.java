/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aam
 */
public class ChampionsTest {
    TOC game;
    
    public ChampionsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Ola");
    }
    
    @After
    public void tearDown() {
    }

     
    //a local method to check a String for contents - not a test as no @test
    private boolean containsText(String text, String[] str) {
        boolean result = true;
        for (String temp : str) {
            result = result && (text.toLowerCase()).contains(temp.toLowerCase());
        }
        return result;
    }
    
    @Test
    public void isChampionTest()
    {
        boolean actual = game.isChampion("Flimsi");
        assertTrue(actual);
    }
    
    @Test
    public void getChampionDetailsTest(){
        String details = game.getChampionDetails("Argon");
        String[] xx = {"Argon","9", "900", "mace","Warrior"};
        boolean actual = containsText(details,xx );
        assertTrue(actual);
    }
    
    @Test
    public void championInReserveGanfrankDisplayed() {
        String result = game.getReserve();
        String[] xx = {"Ganfrank","true", "7", "400","transmutation", "Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveRudolfDisplayed() {
        String result = game.getReserve();
        String[] xx = {"Rudolf", "true", "6", "400","invisibility","Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveElblondDisplayed() {
        String result = game.getReserve();
        String[] xx = {"Elblond", "1", "150","sword", "Warrior"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }    
    
    @Test
    public void ChampionInReserveDrabinaDisplayed() {
        String result = game.getReserve();
        String[] xx = {"Drabina", "7", "500","false", "Dragon"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveGolumDisplayed() {
        String result = game.getReserve();
        String[] xx = {"Golum", "7", "500","true"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    @Test
    public void ChampionInReserveNeonDisplayed() {
        String result = game.getReserve();
        String[] xx = {"Neon","2", "false", "300","translocation", "Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    //Why were those chosen? You can add more but is it worth it ?

    //Tests that the get team method returns members of the team correctly.
    @Test
    public void ChampionInTeamNeonDisplayed() {
        game.enterChampion("Neon");
        String result = game.getTeam();
        String[] xx = {"Neon","2", "false", "300","translocation", "Wizard"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }
    
    // Test champion found in reserve
    @Test
    public void checkFoundChampionInReserve() {
        String result = game.findChampionInReserve("Flimsi");
        String[] xx = {"Flimsi","2", "200","bow", "Warrior"};
        boolean actual= containsText(result,xx );
        assertTrue(actual);
    }
    
    // Test champion not found in the entire game
    @Test
    public void checkNotFoundInvalidChampion() {
        String result = game.getChampionDetails("invalidChamp");
        String xx = "No Champion found with the name \"invalidChamp\"";
        assertTrue(result.equals(xx));
    }
    
    // Test champion doesn't exist
    @Test
    public void checkChampionNotFound() {
        boolean result = game.isChampion("Jerry");
        assertFalse(result);
    }

}
