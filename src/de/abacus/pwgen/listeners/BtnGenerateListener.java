package de.abacus.pwgen.listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Random;

import javax.swing.JOptionPane;

import de.abacus.pwgen.frames.MainWindow;

public class BtnGenerateListener extends WindowAdapter implements ActionListener
{
	
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");    
    
	private MainWindow mainframe;
	private Random randompwgen;
	private String uncastedlength;
    
    public BtnGenerateListener(MainWindow mainframe)
    {
        this.mainframe = mainframe;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        int pwcastlength = 0;
        
        if (mainframe.getTflength().getText().equals(""))
        {
            
            JOptionPane.showMessageDialog(mainframe,"Geben Sie bitte eine Zahl ein.", "", 0);
            mainframe.getTflength().setText("");
            mainframe.getTflength().requestFocus();
            return;
        }
        else
        {
            
            try
            {
                uncastedlength = String.valueOf(mainframe.getTflength().getText());
                pwcastlength = new Integer(uncastedlength);
                
            }
            catch (IllegalArgumentException ex)
            {
                
                JOptionPane.showMessageDialog(mainframe,"Geben Sie bitte eine Zahl ein.", "", 0);
                mainframe.getTflength().setText("");
                mainframe.getTflength().requestFocus();
            }
        }
        
        
        randompwgen = new Random();
        
        String[] possibilities =
        {
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n",
            "o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I",
            "J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","0","1","2","3","4","5",
            "6","7","8","9","!","@","�","$","%","^","&","*","~","`","<",">","/","?","|","[","]","+","=","-"
        };
        
             
        int a = pwcastlength;
        int b;
        
        while (a > 0)
        {     
            
            b = randompwgen.nextInt(possibilities.length);           
            a = a - 1;
            mainframe.getPwoutput().append(possibilities[b]);            
        }
        
        mainframe.getPwoutput().append(LINE_SEPARATOR);       
        
    }
    
}