/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tournament.of.champions;

/**
 *
 * @author Iblob
 */
public interface TOC {
    int getMoney (Player p);
    void addMoney (Player p);
    void addChampion (Champion c);
    void removeChampion (int champId);
    void setChampState (String state, Champion c);
    void startChallenge (int Challenge);
    String getGameState ();
    String getAllChampions ();
    String getTeam ();
    String getAllChallenges ();
}
