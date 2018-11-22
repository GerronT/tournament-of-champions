/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toc;

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
public class ChampionWithdrawnTest {
    TOC game;
    public ChampionWithdrawnTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("OO");
        game.enterChampion("Ganfrank");
        game.enterChampion("Elblond");
        game.enterChampion("Neon");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void withdrawChampionTestResult0(){
        int expected = 0;
        int actual = game.withdrawChampion("Neon");
        assertEquals(expected, actual);
    }
    
    @Test
    public void withdrawChampionTestMoneyAdded(){
        int expected = 1000 -(400+150+300)+ 300/2;
        game.withdrawChampion("Neon");
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void withdrawnChampionNotInTeam(){
        game.withdrawChampion("Neon");
        boolean actual = game.isInPlayersTeam("Neon");
        assertFalse(actual);
    }
    
    @Test
    public void withdrawnChampionInReserve(){
        game.withdrawChampion("Neon");
        String list = game.getReserve();
        boolean actual = list.contains("Neon");
        assertTrue(actual);
    }
    
    @Test
    public void withdrawChampionTestResult2(){
        int expected = 2;
        int actual = game.withdrawChampion("Flimsi");
        assertEquals(expected, actual);
    }
    
    @Test
    public void withdrawChampionTestResult2Money(){
        int expected = 150;
        game.withdrawChampion("Flimsi");
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void withdrawNoSuchChampionTestResult2(){
        int expected = 2;
        int actual = game.withdrawChampion("Boggle");
        assertEquals(expected, actual);
    }
    
    @Test
    public void withdrawNoSuchChampionTestMoney(){
        int expected = 150;
        game.withdrawChampion("Boggle");
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
        
    @Test
    public void withdrawnNoSuchChampionNotInTeam(){
        game.withdrawChampion("Boggle");
        boolean actual = game.isInPlayersTeam("Boggle");
        assertFalse(actual);
    }
    
    @Test
    public void withdrawnNoSuchChampionNotInReserve(){
        game.withdrawChampion("Boggle");
        String list = game.getReserve();
        boolean actual = list.contains("Boggle");
        assertFalse(actual);
    }
    //can't yet do test for withdraw dead champion
}
