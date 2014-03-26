package de.abacus.pwgen.listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import de.abacus.pwgen.frames.MainWindow;

public class SaveItemListener implements ActionListener
{
    
    private MainWindow mainframe;
    
    public SaveItemListener(MainWindow mainframe)
    {
        
        this.mainframe = mainframe;
    }
    
    
    @Override
	public void actionPerformed(ActionEvent save)
    {
        if (mainframe.getPwoutput().getText().equals(""))
        {
            JOptionPane.showMessageDialog(mainframe,"Es wurden noch keine Passw�rter generiert.", "Fehler!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                
                String[] pwlines = mainframe.getPwoutput().getText().split("\n");
                JFileChooser pwfc = new JFileChooser();
                pwfc.showSaveDialog(mainframe.getPwoutput());
                File savepasswords = pwfc.getSelectedFile();
                
                FileWriter pwwriter = new FileWriter(savepasswords, false);
                
                for (int i = 0; i < pwlines.length; i++)
                {
                    pwwriter.write(pwlines[i] + "\n" );
                }
                
                
                pwwriter.flush();
                pwwriter.close();
                
                
            }
            catch(Exception ex)
            {
                
                JOptionPane.showMessageDialog(mainframe, "Speichern abgebrochen. Grund: " + ex, "", 0);
            }
        }
    }
}