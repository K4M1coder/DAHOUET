package com.K4M1coder.dahouet.application.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;

public class UiVoilier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fenettrePrincipale;

	/**
	 * Create the main frame.
	 */
	public UiVoilier() {
		setTitle("Enregistrement d'un voilier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNouveau = new JMenu("Voilier");
		menuBar.add(mnNouveau);
		
		JMenuItem mntmNouveau = new JMenuItem("nouveau");
		mnNouveau.add(mntmNouveau);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmPropos = new JMenuItem("\u00E0 propos");
		menu.add(mntmPropos);
		fenettrePrincipale = new JPanel();
		fenettrePrincipale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(fenettrePrincipale);
		fenettrePrincipale.setLayout(new BorderLayout(0, 0));
		
		JToolBar StatusBar = new JToolBar();
		StatusBar.setFloatable(false);
		fenettrePrincipale.add(StatusBar, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		StatusBar.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblStatus = DefaultComponentFactory.getInstance().createLabel("Status");
		panel.add(lblStatus, BorderLayout.WEST);
		
		JLabel lblProgression = DefaultComponentFactory.getInstance().createLabel("Progression : ");
		lblProgression.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblProgression, BorderLayout.CENTER);
		
		JProgressBar progressBar = new JProgressBar();
		panel.add(progressBar, BorderLayout.EAST);
		
		JSplitPane splitPane = new JSplitPane();
		fenettrePrincipale.add(splitPane, BorderLayout.NORTH);
		
		JLabel lblVoiliersListe = DefaultComponentFactory.getInstance().createLabel("Voiliers");
		splitPane.setLeftComponent(lblVoiliersListe);
		
		JComboBox comboBox = new JComboBox();
		splitPane.setRightComponent(comboBox);
	}

}
