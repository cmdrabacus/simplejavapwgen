package de.abacus.pwgen.launch;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import de.abacus.pwgen.frames.MainWindow;

public class PasswortGenerator {

	public static void main(String[] args) throws Exception {

		String metalLaf = "javax.swing.plaf.metal.MetalLookAndFeel";

		MainWindow mainframe = new MainWindow();

		UIManager.setLookAndFeel(metalLaf);
		SwingUtilities.updateComponentTreeUI(mainframe);

		mainframe.pack();
		mainframe.setVisible(true);

	}

}
