package toc;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/10/18
 */
public class GameGUI 
{
    private TOC gp = new Tournament("Fred");
    private JFrame myFrame = new JFrame("Game GUI");
    private Container contentPane = myFrame.getContentPane();
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton fightBtn = new JButton("Fight Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        contentPane.setLayout(new BorderLayout());
        contentPane.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        contentPane.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(fightBtn);
        eastPanel.add(viewBtn);
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
        JMenu fileMenu = new JMenu("Champions");
        menubar.add(fileMenu);
        
        JMenuItem listChampionItem = new JMenuItem("List reserve Champions");
        listChampionItem.addActionListener(new ListChampionHandler());
        fileMenu.add(listChampionItem);

        JMenuItem listTeamItem = new JMenuItem("List players team");
        listTeamItem.addActionListener(new ListTeamHandler());
        fileMenu.add(listTeamItem);
        
        JMenuItem enter = new JMenuItem("Enter Champion");
        enter.addActionListener(new EnterHandler());
        fileMenu.add(enter);
        
        JMenuItem withdraw = new JMenuItem("Withdraw Champion");
        withdraw.addActionListener(new WithdrawHandler());
        fileMenu.add(withdraw);
        
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
            output = "\n" + output + "\nTreasury = £" + gp.getMoney();
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
    
}
   
