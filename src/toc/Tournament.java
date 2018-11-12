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
    

//**************** TOC ************************** 
    /** Constructor requires the name of the player
     * @param player the name of the player
     */  
    public Tournament(String pl)
    {
    }
    
    /** Constructor requires the name of the player and the
     * name of the file storing challenges
     * @param player the name of the player
     * @param filename name of file storing challenges
     */  
    public Tournament(String pl, String filename)  //Task 3
    {
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
        return false;
    }
    
    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney()
    {
        return 0;
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {    
        return "";
    }
    
    /** Returns details of champion in reserves with the given name
     * @return details of champion in reserves with the given name
     **/
    public String findChampionInReserve(String nme)
    {
         return "";
    }
    
    
    /** Returns details of any champion with the given name
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
        return "";
    }     
    
     /** Returns whether champion exists, or not
     * @param champion's name
     * @return true if champion in the game, false otherwise
     */
    public boolean isChampion(String nme)
    {
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
        return -1;
    }
    
   
    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam()
    {
        return "";
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the referchale number of the challenge
     * @return true if the referchale number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
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
        return "";
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        return "";
    }
    

    //****************** private methods *******************
    //*******************************************************************************
    private void setupChampions()
    {
    }
     
    private void setupChallenges()
    {
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



