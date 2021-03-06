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
public class FightSequences {
    TOC game;
    public FightSequences() {
    }
    
     @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Tournament("Jean");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    //Action sequences
    @Test
    public void warriorDeadUsedAgain() {
        int expected = 1;
        game.enterChampion("Flimsi");
        game.fightChallenge(2);  //should be dead
        int actual = game.fightChallenge(2); //re-used ?
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorDeadUsedAgainMoney() {
        int expected = 1000-200-120-120;
        game.enterChampion("Flimsi");
        game.fightChallenge(2);  //should be dead
        game.fightChallenge(2); //re-used ?
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorWithdrawnBeforeFight() {
        int expected = 1;
        game.enterChampion("Argon");
        game.withdrawChampion("Argon");
        int actual = game.fightChallenge(2); //used ?
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorWithdrawnBeforeFightMoney() {
        int expected = 1000-900+450-120;
        game.enterChampion("Argon");
        game.withdrawChampion("Argon");
        game.fightChallenge(2);  //not available
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void defeatAchieved() {
        int expected = 3;
        game.enterChampion("Rudolf");
        game.enterChampion("Flimsi");
        game.fightChallenge(8);  //lose
        game.fightChallenge(8);  //lose
        game.fightChallenge(8);  //no one left
        int actual = game.fightChallenge(8);  //no one left
        assertEquals(expected, actual);
    }
    
    @Test
    public void defeatWithWithdrawalMoney() {
        int expected = 1000-400-200-170+100-170-170;
        game.enterChampion("Rudolf");
        game.enterChampion("Flimsi");
        game.fightChallenge(8);  //lose
        game.withdrawChampion("Flimsi");
        game.fightChallenge(8);  //no one left
        game.fightChallenge(8);  //no one left
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void defeatNotAchieved() {
        int expected = 1;
        game.enterChampion("Drabina");
        game.enterChampion("Flimsi");
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        int actual = game.fightChallenge(4);  //lose as no one available
        assertEquals(expected, actual);
    }
    
    @Test
    public void defeatNotAchievedMoney() {
        int expected = 1000-500-200-200-200-200;
        game.enterChampion("Drabina");
        game.enterChampion("Flimsi");
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

    @Test
    public void defeatAchievedAfterWithdraw() {
        int expected = 3;
        game.enterChampion("Drabina");
        game.enterChampion("Flimsi");
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.withdrawChampion("Drabina");
        game.withdrawChampion("Flimsi"); //no one in Team
        game.fightChallenge(4);  //lose as no one available
        int actual = game.fightChallenge(4);  //lose as no one available
        assertEquals(expected, actual);
    }
    
    @Test
    public void defeatAchievedAfterWithdrawMoney() {
        int expected = 1000-500-200-200-200+250+100-200-200;
        game.enterChampion("Drabina");
        game.enterChampion("Flimsi");
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.withdrawChampion("Drabina");
        game.withdrawChampion("Flimsi"); //no one in Team
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
// Add your own tests 
    
    //Tests if the player will be defeated if they fight a challenge with no team and not enough money,
    @Test
    public void testIfDefeatedSinceNoTeam() {
        int expected = 3; // 3 is returned after player is defeated
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        int actual = game.fightChallenge(4);  //Game lost as no team found and have no money left
        assertEquals(expected, actual);
    }
    
    //Tests if the player will be defeated if they fight a challenge,
    //but their final champion lost due to skill level and there was no money left
    @Test
    public void testIfDefeatedAfterLosingAChampion() {
        int expected = 3; // 3 is returned after player is defeated
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(3);  //lose as no one available
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(4); //Game lost as final champion dies and no money left
        assertEquals(expected, actual);
    }
    
    //Tests if the player status will be defeated if they fight a challenge with no team 
    //and not enough money,
    @Test
    public void testPlayerDefeatedStatus() {
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //lose as no one available
        game.fightChallenge(4);  //Game lost at this stage
        String expected = "Status: Defeated";
        String actual = game.toString();
        assertTrue(actual.contains(expected));
    }
    
    
}
