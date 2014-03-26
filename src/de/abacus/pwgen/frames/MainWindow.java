package de.abacus.pwgen.frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import de.abacus.pwgen.listeners.BtnGenerateListener;
import de.abacus.pwgen.listeners.ExitItemListener;
import de.abacus.pwgen.listeners.SaveItemListener;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 8078112488921384842L;

	private MainWindow mainframe;

	private JTextField tflength;
	private JTextArea pwoutput;
	private JButton btnGenerate;
	private JLabel lengthDescription;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem saveItem;
	private JMenuItem exitItem;

	public MainWindow() {

		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());

		setTitle("Passwort - Generator V0.2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		file = new JMenu("Datei");

		saveItem = new JMenuItem("speichern");
		exitItem = new JMenuItem("beenden");

		menuBar.add(file);

		file.add(saveItem);
		file.add(exitItem);

		lengthDescription = new JLabel("Laenge:");
		JPanel lengthDescriptionhwrapper = new JPanel(new FlowLayout(0, 0,
				FlowLayout.LEADING));
		lengthDescriptionhwrapper.add(lengthDescription);

		setTflength(new JTextField(5));
		getTflength().requestFocus();

		JPanel tflengthwrapper = new JPanel(new FlowLayout(0, 0,
				FlowLayout.LEADING));
		tflengthwrapper.add(getTflength());

		setPwoutput(new JTextArea(10, 20));
		getPwoutput().setEditable(false);

		JScrollPane pwscroll = new JScrollPane(getPwoutput(),
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		btnGenerate = new JButton("Start");

		cp.add(menuBar, BorderLayout.NORTH);
		cp.add(pwscroll, BorderLayout.WEST);
		cp.add(lengthDescriptionhwrapper, BorderLayout.CENTER);
		cp.add(tflengthwrapper, BorderLayout.EAST);
		cp.add(btnGenerate, BorderLayout.SOUTH);

		BtnGenerateListener genClass = new BtnGenerateListener(this);
		btnGenerate.addActionListener(genClass);

		ExitItemListener exitClass = new ExitItemListener();
		exitItem.addActionListener(exitClass);

		SaveItemListener saveClass = new SaveItemListener(this);
		saveItem.addActionListener(saveClass);

	}

	public MainWindow getMainframe() {
		return mainframe;
	}

	public void setMainframe(MainWindow mainframe) {
		this.mainframe = mainframe;
	}

	public JTextArea getPwoutput() {
		return pwoutput;
	}

	public void setPwoutput(JTextArea pwoutput) {
		this.pwoutput = pwoutput;
	}

	public JTextField getTflength() {
		return tflength;
	}

	public void setTflength(JTextField tflength) {
		this.tflength = tflength;
	}

}
