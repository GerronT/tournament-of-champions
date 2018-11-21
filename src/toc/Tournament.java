package toc;
import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the WAM
 * system as required for 6COM1037 - Oct 2018
 * 
 * @author A.A.Marczyk 
 * @version 16/10/18
 */

public class Tournament implements TOC 
{
    private String playerName;
    private int treasury = 1000;
    
    private String fileName = "tournament";
    
    private ArrayList<Champion> champions = new ArrayList<Champion>();
    private ArrayList<Challenge> challenges = new ArrayList<Challenge>();

//**************** TOC ************************** 
    /** Constructor requires the name of the player
     * @param player the name of the player
     */  
    public Tournament(String pl)
    {
    	this.playerName = pl;
    	setupChampions();
    	setupChallenges();
    }
    
    /** Constructor requires the name of the player and the
     * name of the file storing challenges
     * @param player the name of the player
     * @param filename name of file storing challenges
     */  
    public Tournament(String pl, String filename)  //Task 3
    {
    	this(pl);
    	this.fileName = filename;
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    {
        return "";
    }
    
    
    /** returns true if Treasury <=0 and the player's team has no champions 
     * which can be deentered. 
     * @return true if Treasury <=0 and the player's team has no champions 
     * which can be retired. 
     */
    public boolean isDefeated()
    {
    	boolean foundChampion = false;
    	for (Champion champion : champions) {
    		if (champion.getStatus().equals("Entered"))
    			foundChampion = true;
    	}
    	
    	if (treasury <= 0 && foundChampion) 
    		return true;
    	
        return false;
    }
    
    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney()
    {
        return treasury;
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {   
    	String ss = "";
		for (Champion champion : champions) {
			if (champion.getStatus().equals("Waiting"))
				ss += champion.getChampionDetails() + "\n";
		}
		return ss;
    }
    
    /** Returns details of champion in reserves with the given name
     * @return details of champion in reserves with the given name
     **/
    public String findChampionInReserve(String nme)
    {
    	for (Champion champion : champions) {
    		if (champion.getStatus().equals("Waiting"))
    			if (champion.getChampionName().equalsIgnoreCase(nme))
    				return champion.getChampionDetails() + "\n";
		}
    	return "No Champion found with the name \"" + nme + "\"";
    }
    
    /** Returns details of any champion with the given name
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
    	for (Champion champion : champions) {
    			if (champion.getChampionName().equalsIgnoreCase(nme))
    				return champion.getChampionDetails() + "\n";
		}
    	return "No Champion found with the name \"" + nme + "\"";
    }     
    
     /** Returns whether champion exists, or not
     * @param champion's name
     * @return true if champion in the game, false otherwise
     */
    public boolean isChampion(String nme)
    {
    	for (Champion champion : champions) {
			if (champion.getChampionName().equalsIgnoreCase(nme))
				return true;
    	}
    	
        return false;
    }
 
    // ***************** Team champions ************************   
    /** Allows a champion to be entered for the player's team, if there 
     * is enough money in the Treasury for the commission fee.The champion's 
     * state is set to "active"
     * @param nme represents the name of the champion
     * @return 0 if champion is entered in the player's team, 1 if champion 
     * is not in reserve, 2 if not enough money in the treasury, -1 if there
     * is no such champion 
     **/       
    public int enterChampion(String nme)
    {
		for (Champion champion : champions) {
			if (champion.getChampionName().equals(nme)) {
				if (!champion.getStatus().equals("Waiting"))
					return 1;
				int champEF = champion.getEntryFee();
				if (treasury >= champEF) {
					treasury -= champEF;
					champion.setStatus("Entered");
					return 0;
				} else {
					return 2;
				}
			}
		}
		
		return -1;
    }
        
    /** Returns true if the champion with the name is in 
     * the player's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the player's team, false otherwise.
     **/
    public boolean isInPlayersTeam(String nme)
    {
    	for (Champion champion: champions) {
    		if (champion.getStatus().equals("Entered"))
    			return true;
    	}
        return false;
    }
    
    /** Removes a champion from the team to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is withdrawn to reserves
     * 1 - if champion not withdrawn because dead
     * 2 - if champion not withdrawn because not in team
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int withdrawChampion(String nme)
    {
    	for (Champion champion : champions) {
    		if (champion.getChampionName().equalsIgnoreCase(nme)) {
    			if (champion.getStatus().equals("Dead")) {
    				return 1;
    			} else if (champion.getStatus().equals("Waiting")) {
    				return 2;
    			} else {
    				treasury += (champion.getEntryFee() / 2);
    				champion.setStatus("Waiting");
    				return 0;
    			}
    		}
    	}
    	
    	return -1;

    }
    
   
    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam()
    {
    	int champCount = 0;
    	String ss = "";
		for (Champion champion : champions) {
			if (champion.getStatus().equals("Entered")) {
				ss += champion.getChampionDetails() + "\n";
				champCount ++;
			}
		}
		
		return champCount > 0 ? ss : "No champions entered";

    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the referchale number of the challenge
     * @return true if the referchale number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         for (Challenge challenge : challenges) {
        	 if (challenge.getChallengeNo() == num)
        		 return true;
         }
         return false;
     }
     
    /** Retrieves the challenge represented by the challenge 
      * number.Finds a champion from the team which can challenge the 
      * challenge. The results of fighting an challenge will be 
      * one of the following:  
      * 0 - challenge won, add challenge reward to the treasury, 
      * 1 - challenge lost as no suitable champion is  available, deduct
      * the challenge reward from treasury 
      * 2 - challenge lost on battle skills  - deduct challenge reward from
      * treasury and record champion as "dead"
      * 3 - If a challenge is lost and player completely defeated (no money and 
      * no champions to withdraw) 
      * -1 - no such challenge 
      * @param chalNo is the number of the challenge
      * @return an int showing the result(as above) of fighting the challenge
      */  
    public int fightChallenge(int chalNo)
    {   
        for (Challenge challenge: challenges) {
            if (challenge.getChallengeNo() == chalNo) {
                String challengeType = challenge.getType();
                for (Champion champion : champions) {
                    if (champion.getStatus().equalsIgnoreCase("entered")) {
                        boolean allowed = false;
                        if (challengeType.equals("Magic")) {
                            allowed = champion.getChallengeAuthorisation()[0];
                        } else if (challengeType.equals("Fight")) {
                            allowed = champion.getChallengeAuthorisation()[1];
                        } else if (challengeType.equals("Mystery")) {
                            allowed = champion.getChallengeAuthorisation()[2];
                        }
                        if (allowed) {
                            if (champion.getSkillLevel() >= challenge.getSkillReq()) {
                                return 0;
                            } else {
                                return 2;
                            }
                        }
                    }
		}
            }
        }
        return -1;
    }

    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {
        for (Challenge challenge: challenges) {
            if (challenge.getChallengeNo() == num) {
                return challenge.toString();
            }
        }
        return "Challenge not found";
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {   
        String toReturn = "";
        for (Challenge challenge: challenges) {
            toReturn += challenge.toString();
        }
        return toReturn;
    }
    

    //****************** private methods *******************
    //*******************************************************************************
    private void setupChampions()
    {
    	champions.add(new Wizard("Ganfrank", 7, true, "transmuation"));
		champions.add(new Wizard("Rudolf", 6, true, "invisibility"));
		champions.add(new Warrior("Elblond", 150, "sword"));
		champions.add(new Warrior("Flimsi", 200, "bow"));
		champions.add(new Dragon("Drabina", false));
		champions.add(new Dragon("Golum", false));
		champions.add(new Warrior("Argon", 900, "mace"));
		champions.add(new Wizard("Neon", 2, false, "translocation"));
		champions.add(new Dragon("Xenon", true));
    }
     
    private void setupChallenges()
    {
        challenges.add(new Challenge(1, "Magic", "Borg", 3, 100));
        challenges.add(new Challenge(2, "Fight", "Huns", 3, 120));
        challenges.add(new Challenge(3, "Mystery", "Ferengi", 3, 150));
        challenges.add(new Challenge(4, "Magic", "Vandal", 9, 200));
        challenges.add(new Challenge(5, "Mystery", "Borg" , 7, 90));
        challenges.add(new Challenge(6, "Fight", "Goth", 8, 45));
        challenges.add(new Challenge(7, "Magic", "Frank", 10, 200));
        challenges.add(new Challenge(8, "Fight", "Sith", 10, 170));
        challenges.add(new Challenge(9, "Mystery", "Cardashian", 9, 300));
    }
        
   
//    // These methods are not needed until Task 4.4
//    // ***************   file write/read  *********************
//     /** Writes whole game to the specified file using serialisation
//      * @param fname name of file to which game is saved
//      */
//     public void saveGame(String fname)
//     {    // use serialisation
//     
//     /** reads all information about the game from the specified file 
//      * and returns 
//      * @param fname name of file storing the game
//      * @return the game (as an Player object)
//      */
//     public Tournament loadGame(String fname)
//     {   // uses object serialisation 
//         return null;
//     } 
//     
//     /** reads information about challenges from the specified file
//      * and stores them 
//      * @param fileName name of file storing challenges
//      */
//     private void loadChallenges(String fileName);
    
}



