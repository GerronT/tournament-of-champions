package toc;
import java.io.*;
import java.util.*;
/**
 * Task 2 - provide command line interface for testing
 * 
 * @author A.A.Marczyk
 * @version 20/10/18
 */
public class GameUI
{
    private static Tournament tr ;
    private static Scanner myIn = new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice;
        String playerName;
        String output = "";
        int result = -1; 
        try
        {
            System.out.println("Enter player's name");
            String s = myIn.nextLine();
            //myIn.nextLine();
            tr = new Tournament(s); // create
            choice = 100;
            while (choice != 0 )
            {
                choice = getMenuItem();
                if (choice == 1)
                {
                    System.out.println(tr.getReserve());
                }
                else if (choice == 2)
                {
                    // code omitted
                	System.out.println(tr.getTeam());
                }
                else if (choice == 3)
                {
                    // code omitted
                	System.out.println("Enter Champion name");
                	String champName = myIn.nextLine(); 
                	System.out.println(tr.getChampionDetails(champName));
                } 
                else if (choice == 4)
                {   
                    System.out.println("Enter Champion name");
                    String nme = (myIn.nextLine()).trim();
                    result = tr.enterChampion(nme);
                    if (result ==0)
                    {
                        output = nme + " entered in team";
                    }
                    else if (result ==1)
                    {
                        output = nme + " not in reserve";
                    }
                    else if (result ==2)
                    {
                        output = "Not enough money in treasury ";
                    }
                    else
                    {
                        output = "No such champion";
                    }
                    System.out.println("\n" + output + "\nTreasury = £" + tr.getMoney());
                }
                else if (choice == 5)
                {
                    System.out.println("Enter number of the challenge");
                    String chal = myIn.nextLine();
                    int number = Integer.parseInt(chal);
                    if (tr.isChallenge(number))
                    {
                        result = tr.fightChallenge(number);
                    }
                    if (result ==0)
                    {
                        output = "Challenge won";
                    }
                    else if (result ==1)
                    {
                        output = "Challenge lost as no champion available";
                    }
                    else if (result ==2)
                    {
                        output = "Challenge lost on battle skill";
                    }
                    else if (result ==3)
                    {
                        output = "Challenge lost. You lose the game ";
                    }
                    else 
                    {
                        output = "No such challenge";
                    }
                    System.out.println("\n" + output + "\nTreasury = £" + tr.getMoney());
                }
                else if (choice==6)
                {
                    System.out.println("Enter Champion name");
                    String nme = (myIn.nextLine()).trim();
                    if(tr.isChampion(nme)) //responsible client
                    {
                        result = tr.withdrawChampion(nme);
                        // code omitted
                        // display message appropriate to result
                        if (result == 0) {
                        	output = nme + " is withdrawn from the team";
                        } else if (result == 1) {
                        	output = nme + " is dead and cannot be withdrawn";
                        } else if (result == 2) {
                        	output = nme + " is already in reserved";
                        }
                    }
                    else 
                    {
                        output = "\nNo such champion ";
                    }
                    System.out.println(output+"\nTreasury = £" + tr.getMoney());
                }  
                else if (choice==7)
                {
                    System.out.println(tr.toString());
                }
//                 else if (choice == 8) // Task 4.4 only
//                 {
//                     System.out.println("Write to file");
//                     tr.saveGame("olenka.txt");
//                 }
//                 else if (choice == 9) // Task 4.4 only
//                 {
//                     System.out.println("Restore from file");
//                     Tournament tr2= tr.loadGame("olenka.txt");
//                     System.out.println(tr2.toString());               
//                 }
            }     
        }
        catch (IOException e) {System.out.println (e);}   
        System.out.println("Thank-you");
    }
    
    private static int getMenuItem()throws IOException
    {   int choice = 100;  
        System.out.println("\nMain Menu");
        System.out.println("0. Quit");
        System.out.println("1. List champions in reserve");
        System.out.println("2. List champions in players team"); 
        System.out.println("3. View a champion");
        System.out.println("4. Enter champion into player's team");
        System.out.println("5. Fight an challenge");
        System.out.println("6. Withdraw a champion");
        System.out.println("7. View game state");
//         System.out.println("8. Save this game");
//         System.out.println("9. Load this game");
       
        
        while (choice < 0 || choice  > 9)
        {
            System.out.println("Enter the number of your choice");
            choice =  myIn.nextInt();
        }
        myIn.nextLine();
        return choice;        
    }  
}