package toc;

import java.io.*;
/**
 * This interface specifies the behaviour expected from WAVES
 * as required for 6COM1037 Cwk Assignment - Oct 2018
 * 
 * @author A.A.Marczyk 
 * @version 05/09/18
 */
 
public interface TOC extends Serializable 
{
 //**************** TOC **************************  
    
    /**Returns a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * @return a String representation of the state of the game,
     * including the name of the player, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString();
    
    
    /** returns true if Treasury <=0 and the player's team has no 
     * champions which can be withdrawn. 
     * @return true if Treasury <=0 and the player's team has no 
     * champions which can be decommissioned. 
     */
    public boolean isDefeated();
    
    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney();
    
    
    /**Returns a String representation of all champions in reserve
     * @return a String representation of all champions in reserve
     **/
    public String getReserve();
    
    
    /** Returns details of champion in reserve with the given name
     * @return details of champion in reserve with the given name
     **/
    public String findChampionInReserve(String nme);
    
    
    /** Returns details of any champion with the given name
     * @return details of any champion with the given name
     **/
    public String getChampionDetails(String nme);
    
    /** Returns whether champion exists, or not
     * @param champion's name
     * @return true if champion in the game, false otherwise
     */
    public boolean isChampion(String nme);
    
 // ***************** Champions Team************************   
    /** Allows a champion to be entered for the player's team, if there 
     * is enough money in the Treasury for the commission fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the player's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme);
    
        
    /** Returns true if the champion with the name is in 
     * the player's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the player's team, false otherwise.
     **/
    public boolean isInPlayersTeam(String nme);
    
    
    /** Removes a champion from the team to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is withdrawn to reserves
     * 1 - if champion not withdrawn because dead
     * 2 - if champion not withdrawn because not in team
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int withdrawChampion(String nme);
        
        
    /**Returns a String representation of the champions in the player's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the player's team
     **/
    public String getTeam();
    
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the number of the challenge
     * @return true if the number represents a challenge
     **/
     public boolean isChallenge(int num);
     
     
     /** Retrieves the challenge represented by the challenge 
      * number.Finds a champion from the team which can challenge the 
      * challenge. The results of fighting an challenge will be 
      * one of the following:  
      * 0 - challenge won, add reward to the treasury, 
      * 1 - challenge lost as no suitable champion is  available, deduct
      * the reward from treasury 
      * 2 - challenge lost on battle skills  - deduct reward from
      * treasury and record champion as "dead"
      * 3 - If a challenge is lost and player completely defeated (no money and 
      * no champions to withdraw) 
      * -1 - no such challenge 
      * @param chalNo is the number of the challenge
      * @return an int showing the result(as above) of fighting the challenge
      */ 
    public int fightChallenge(int chalNo);
    

    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num);
    
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges();
 
//     // These methods are not needed until Task 4.4
//     // ***************   file write/read  *********************
//     /** Writes whole game to the specified file using serialisation
//      * @param fname name of file to which game is saved
//      */
//     public void saveGame(String fname);
//     
//     /** reads all information about the game from the specified file 
//      * and returns an TOC reference to a Tournament object
//      * @param fname name of file storing the game
//      * @return the game (as a Tournament object)
//      */
//     public TOC loadGame(String fname);
//     
//     /** reads information about challenges from the specified file
//      * and stores them 
//      * @param fileName name of file storing the challenges
//      */
//     private void loadChallenges(String fileName);
}
