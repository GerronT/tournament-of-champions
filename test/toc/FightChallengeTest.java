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
 * @author aam
 */
public class FightChallengeTest {
    TOC game;
    
    public FightChallengeTest() {
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
    
//Wizards    
    // Wizard facing magic
    @Test
    public void wizardFacingMagicWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicWinsMoney() {
        int expected = 1000-400+100;
        game.enterChampion("Ganfrank");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Neon");
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMagicLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
      
    @Test
    public void wizardLosingIsDead() {
        game.enterChampion("Neon");
        game.fightChallenge(1);
        boolean actual = game.getChampionDetails("Neon").toLowerCase().contains("dead");
        assertTrue(actual);
    }
    
    //checking withdrawal of dead champion
    @Test
    public void cantWithdrawDead() {
        int expected = 1;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        int actual= game.withdrawChampion("Neon");
        assertEquals(actual,expected);
    }
    
    @Test
    public void cantWithdrawDeadMoneyNotAffected() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        game.withdrawChampion("Neon");
        int actual= game.getMoney();
        assertEquals(actual,expected);
    }

    @Test
    public void wizardFacingNoSuchMagic() {
        int expected = -1;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(10);
        assertEquals(expected, actual);
    } 
    
    // Wizard facing fight
    @Test
    public void wizardFacingFightWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
    
   @Test
    public void wizardFacingFightWinsMoneyAdded() {
        int expected = 1000-400+120;
        game.enterChampion("Ganfrank");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    } 
    
    @Test
    public void wizardFacingFightLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Neon");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingFightLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-100;
        game.enterChampion("Neon");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    // Wizard facing mystery
    @Test
    public void wizardFacingMysteryWins() {
        int expected = 0;
        game.enterChampion("Ganfrank");
        int actual = game.fightChallenge(3);
        assertEquals(expected, actual);
    }
    
   @Test
    public void wizardFacingMysteryWinsMoneyAdded() {
        int expected = 1000-400+150;
        game.enterChampion("Ganfrank");
        game.fightChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    } 
    
    @Test
    public void wizardFacingMysteryLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Neon");
        int actual = game.fightChallenge(3);
        assertEquals(expected, actual);
    }
    
    @Test
    public void wizardFacingMysteryLosesOnSkillMoneyDeducted() {
        int expected = 1000-300-150;
        game.enterChampion("Neon");
        game.fightChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
   
//Warriors
    //Warrior facing magic - not allowed
    @Test
    public void warriorFacingMagicNotAllowed() {
        int expected = 1;
        game.enterChampion("Argon");
        game.fightChallenge(1);
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingMagicNotAllowedMoneyDeducted() {
        int expected = 0;
        game.enterChampion("Argon");
        game.fightChallenge(1);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
  
    //Warrior facing fight
    @Test
    public void warriorFacingFightAllowedWins() {
        int expected = 0;
        game.enterChampion("Argon");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
      
    @Test
    public void warriorFacingFightAllowedWinsMoneyAdded() {
        int expected = 220;
        game.enterChampion("Argon");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingFightAllowedLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Flimsi");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingFightAllowedLosesMoneyDeducted() {
        int expected = 680;
        game.enterChampion("Flimsi");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    //Warrior facing mystery - not allowed
    @Test
    public void warriorFacingMysteryNotAllowed() {
        int expected = 1;
        game.enterChampion("Argon");
        game.fightChallenge(3);
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void warriorFacingMysteryNotAllowedMoneyDeducted() {
        int expected = -50;
        game.enterChampion("Argon");
        game.fightChallenge(3);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    //Dragons - write your own tests
    
  //Dragon facing magic - not allowed
    @Test
    public void dragonFacingMagicNotAllowed() {
        int expected = 1;
        game.enterChampion("Xenon");
        game.fightChallenge(1);
        int actual = game.fightChallenge(1);
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void DragonFacingMagicNotAllowedMoneyDeducted() {
        int expected = 300;
        game.enterChampion("Xenon");
        game.fightChallenge(4);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
  
  //Dragon facing fight
    @Test
    public void dragonFacingFightAllowedWins() {
        int expected = 0;
        game.enterChampion("Xenon");
        int actual = game.fightChallenge(2);
        assertEquals(expected, actual);
    }
      
    @Test
    public void dragonFacingFightAllowedWinsMoneyAdded() {
        int expected = 1000 - 500 + 120;
        game.enterChampion("Drabina");
        game.fightChallenge(2);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingFightAllowedLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Golum");
        int actual = game.fightChallenge(6);
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingFightAllowedLosesMoneyDeducted() {
        int expected = 455;
        game.enterChampion("Golum");
        game.fightChallenge(6);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
  //Dragon facing Mystery
    @Test
    public void dragonFacingMysteryLosesIfNotTalks() {
        int expected = 1;
        game.enterChampion("Drabina");
        int actual = game.fightChallenge(5);
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingMysteryLosesIfNotTalksMoneyDeducted() {
        int expected = 410;
        game.enterChampion("Drabina");
        game.fightChallenge(5);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingMysteryWinsIfTalksMoney() {
        int expected = 0;
        game.enterChampion("Golum");
        int actual = game.fightChallenge(5);
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingMysteryWinsIfTalksMoneyAdded() {
        int expected = 590;
        game.enterChampion("Golum");
        game.fightChallenge(5);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingMysteryLosesOnSkill() {
        int expected = 2;
        game.enterChampion("Golum");
        int actual = game.fightChallenge(9);
        assertEquals(expected, actual);
    }
    
    @Test
    public void dragonFacingMysteryLosesOnSkillMoneyDeducted() {
        int expected = 200;
        game.enterChampion("Golum");
        game.fightChallenge(9);
        int actual = game.getMoney();
        assertEquals(expected, actual);
    }

}
