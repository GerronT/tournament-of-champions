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
 * @author jp14adn
 */
public class ChampionEnteredTest {
    TOC game;
    
    public ChampionEnteredTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Olenka");
    }
    
    @After
    public void tearDown() {
    }

    
    // TODO add test methods here.
    
     @Test
    public void checkOneChampionEnteredResult0() {
        int expected = 0;
        int actual= game.enterChampion("Flimsi");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkOneChampionEnteredTreasuryDeducted() {
        int expected = 800;
        game.enterChampion("Flimsi"); //don't store return
        int actual= game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkOneChampionEnteredInTeam() {
        game.enterChampion("Flimsi"); 
        boolean actual= game.isInPlayersTeam("Flimsi");
        assertTrue(actual);
    }
    
    @Test
    public void checkOneChampionNotInReserve() {
        game.enterChampion("Flimsi");
        String zz = game.findChampionInReserve("Flimsi"); ;
        boolean actual = !zz.contains("Flimsi");
        assertFalse(actual);
    }
    
    @Test
    public void checkOneChampionEnteredResult1() {
        int expected = 1;
        game.enterChampion("Flimsi");
        int actual = game.enterChampion("Flimsi");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNotEnoughMoney() {
        int expected = 400;
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        assertEquals(expected, game.getMoney());
    }
    
    @Test
    public void checkNotEnoughMoneyResult2() {
        int expected = 2;
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        int actual = game.enterChampion("Argon");
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNotEnoughMoneySoNotInTeam() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        boolean actual = !game.isInPlayersTeam("Argon");
        assertTrue(actual);
    }
    
    @Test
    public void checkNotEnoughMoneySoStaysInReserve() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        boolean actual = (game.getReserve()).contains("Argon");
        assertTrue(actual);
    }
    
    @Test
    public void checkNoSuchChampionEntered() {
        int expected = -1;
        int actual= game.enterChampion("Boggle");
        assertEquals(expected, actual);
    }
    @Test
    public void checkNoSuchChampionEnteredNoDeduction() {
        int expected = 1000;
        game.enterChampion("Boggle");
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkNotEnoughMoneySoStaysInreserve() {
        game.enterChampion("Flimsi");
        game.enterChampion("Ganfrank");
        game.enterChampion("Argon");
        boolean actual = (game.getReserve()).contains("Argon");
        assertTrue(actual);
    }
    
//     @Test
//     public void checkReturnValueForNotEnoughInWarchestOnNonExistentForce() {
//         int expected = 3;
//         game.enterChampion("IW1");
//         game.enterChampion("SS2");
//         game.enterChampion("WB3");
//         game.enterChampion("WB5");
//         int actual = game.enterChampion("XX3");
//         assertEquals(expected, actual);
//     }
//     
//     @Test
//     public void reactivateExistingForceHasNoEffectOnWarchest() {
//         int expected = 200;
//         game.enterChampion("IW1");
//         game.enterChampion("SS2");
//         game.enterChampion("WB3");
//         game.enterChampion("IW1");
//         int actual = game.getWarchest();
//         assertEquals(expected, actual);
//     }
//     
//     @Test
//     public void checkActivatedForceNotOnASFleetList() {
//         game.enterChampion("IW10");
//         game.enterChampion("SS2");
//         game.enterChampion("WB3");
//         boolean result = true;
//         List<String> notOnList = new ArrayList<>(Arrays.asList("IW10","SS2","WB3"));
//         String actual = game.getASFleet();
//         for (String force : notOnList) {
//             result &= !actual.contains(force);
//         }
//         assertTrue(result);
//     }
//     
//     @Test
//     public void checkForceRecallUpdatesWarchestForActivatedForce() {
//         int expected = 800;
//         game.enterChampion("WB5");
//         game.recallForce("WB5");
//         int actual = game.getWarchest();
//         assertEquals(expected, actual);
//     }
//     
//     @Test
//     public void checkForceRecallDoesNotUpdateWarchestForNonActiveForce() {
//         int expected = 800;
//         game.enterChampion("WB5");
//         game.recallForce("WB5");
//         game.recallForce("IW1");
//         int actual = game.getWarchest();
//         assertEquals(expected, actual);
//     }
//     
//     @Test
//     public void checkForceRecallDoesNotUpdateWarchestForNonExistantForce() {
//         int expected = 800;
//         game.enterChampion("WB5");
//         game.recallForce("WB5");
//         game.recallForce("XX3");
//         int actual = game.getWarchest();
//         assertEquals(expected, actual);
//     }
}
