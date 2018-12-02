package toc;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/10/18
 */
public class GameGUI 
{
    private Tournament gp;
    private JFrame myFrame = new JFrame("Game GUI");
    private Container contentPane = myFrame.getContentPane();
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();
    
    private JScrollPane listingScrPane;
    private JTextArea dialogBox = new JTextArea(20, 20);
    private JScrollPane msgBoxScrPane;
    
    private static final File savePath = new File(System.getProperty("user.dir") + "/SaveFiles/");

    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
        String playerName = JOptionPane.showInputDialog("Enter player name: ");
        gp = new Tournament(playerName);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {   
        contentPane.setLayout(new BorderLayout());
        // set scroll bar for the listings
        listingScrPane = new JScrollPane(listing);
        msgBoxScrPane = new JScrollPane(dialogBox);
        contentPane.add(listingScrPane);
        listing.setVisible(false);
        contentPane.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(fightBtn);
        fightBtn.addActionListener(new FightHandler());
        eastPanel.add(viewBtn);
        viewBtn.addActionListener(new ViewStateHandler());
        eastPanel.add(clearBtn);
        clearBtn.addActionListener(new ClearHandler());
        eastPanel.add(quitBtn);
        fightBtn.setVisible(true);
        viewBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);
        
        JMenuItem saveGameItem = new JMenuItem("Save");
        saveGameItem.addActionListener(new SaveGameHandler());
        fileMenu.add(saveGameItem);

        JMenuItem loadGameItem = new JMenuItem("Load");
        loadGameItem.addActionListener(new LoadGameHandler());
        fileMenu.add(loadGameItem);
        
        // create the Champion menu
        JMenu championMenu = new JMenu("Champions");
        menubar.add(championMenu);
        
        JMenuItem listChampionItem = new JMenuItem("List reserve Champions");
        listChampionItem.addActionListener(new ListChampionHandler());
        championMenu.add(listChampionItem);

        JMenuItem listTeamItem = new JMenuItem("List players team");
        listTeamItem.addActionListener(new ListTeamHandler());
        championMenu.add(listTeamItem);
        
        JMenuItem enter = new JMenuItem("Enter Champion");
        enter.addActionListener(new EnterHandler());
        championMenu.add(enter);
        
        JMenuItem withdraw = new JMenuItem("Withdraw Champion");
        withdraw.addActionListener(new WithdrawHandler());
        championMenu.add(withdraw);

    }


    
    private class ListChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getReserve();
            listing.setText(xx);
            
        }
    }
    
    private class ListTeamHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getTeam();
            listing.setText(xx);
        }
    }
    
    private class FightHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
        	int result = -1;
        	String output = "";
            String chal = JOptionPane.showInputDialog("Enter number of the challenge");
            int number = Integer.parseInt(chal);
            if (gp.isChallenge(number))
            {
                result = gp.fightChallenge(number);
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
            JOptionPane.showMessageDialog(myFrame, "\n" + output + "\nTreasury = �" + gp.getMoney());        
        }
    }
    
    private class ViewStateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
        	listing.setVisible(true);
            String xx = gp.toString();
            listing.setText(xx);         
        }
    }
    
    private class ClearHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText("");
            listing.setVisible(false);            
        }
    }

    private class EnterHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String output = "";
            String nme = JOptionPane.showInputDialog("Champion name ?: ");
            result = gp.enterChampion(nme);
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
            output = "\n" + output + "\nTreasury = �" + gp.getMoney();
            JOptionPane.showMessageDialog(myFrame,output);    
        }
    }
    private class WithdrawHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String output = "";
            String nme = JOptionPane.showInputDialog("Champion name ?: ");
            if(gp.isChampion(nme))
            {
                result = gp.withdrawChampion(nme);
                if (result ==0)
                {
                    output = "\n" + nme + " withdrawn";
                }
                else if (result ==1)
                {
                    output = "\n" + nme + " not withdrawn as dead" ;
                }
                else if (result ==2)
                {
                    output = "\n" + nme + " not withdrawn as not in team" ;
                }
            }
            else 
            {
                output = "\nNo such champion ";
            }

            output = output+"\nTreasury = £" + gp.getMoney();
            JOptionPane.showMessageDialog(myFrame,output);    
        }
    }
    
    private class ViewChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "";
            String inputValue = JOptionPane.showInputDialog("Champion name ?: ");
            result = gp.getChampionDetails(inputValue);
            JOptionPane.showMessageDialog(myFrame,result);    
        }
    }
    
   
    private class ClearButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {            
            listing.setVisible(false);
            clearBtn.setVisible(false);
        }
    }
    
    private class SaveGameHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {            
        	String saveFile = JOptionPane.showInputDialog("Enter the name of your save file: ");

        	if (!savePath.exists()) {
        		savePath.mkdir();
        	}
        	
            gp.saveGame(new File(savePath, saveFile).toString());
            JOptionPane.showMessageDialog(myFrame, "Game saved successfully!");
        }
    }
    
    private class LoadGameHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {            
            if (!savePath.exists()) {
            	JOptionPane.showMessageDialog(myFrame,"No Save files exists yet");
        	} else {
        		String loadFile = JOptionPane.showInputDialog("Here's the list of save files found:\n" + Utility.listFiles(savePath) + "\nEnter the name of the save file to load: ");
            
        		// output save files in save directory
        		Tournament gp2= gp.loadGame(new File(savePath, loadFile).toString());
        		// overwrite current game if save file loaded correctly
        		if (gp2 != null) {
        			gp = gp2;
        			dialogBox.setText("Save file State: \n" + gp2.toString());
        			JOptionPane.showMessageDialog(myFrame, msgBoxScrPane); 
        			JOptionPane.showMessageDialog(myFrame,"Game loaded successfully!");
        		} else {
        			JOptionPane.showMessageDialog(myFrame,"Game failed to load");
        		}
        	}
        }
    }
    
}
   
