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
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class UiVoilier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fenettrePrincipale;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the main frame.
	 */
	public UiVoilier() {
		setTitle("Enregistrement d'un voilier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 366);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNouveau = new JMenu("Voilier");
		menuBar.add(mnNouveau);
		
		JMenuItem mntmNouveau = new JMenuItem("Nouveau");
		mnNouveau.add(mntmNouveau);
		
		JMenuItem mntmModifier = new JMenuItem("Modifier");
		mnNouveau.add(mntmModifier);
		
		JMenuItem mntmSupprimer = new JMenuItem("Supprimer");
		mnNouveau.add(mntmSupprimer);
		
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
		splitPane.setEnabled(false);
		fenettrePrincipale.add(splitPane, BorderLayout.NORTH);
		
		JLabel lblVoiliersListe = DefaultComponentFactory.getInstance().createLabel("Voiliers");
		splitPane.setLeftComponent(lblVoiliersListe);
		
		JComboBox comboBox = new JComboBox();
		splitPane.setRightComponent(comboBox);
		
		JPanel panel_1 = new JPanel();
		fenettrePrincipale.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(10, 3, 5, 5));
		
		JLabel label_6 = DefaultComponentFactory.getInstance().createLabel(" ");
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("");
		panel_1.add(label_8);
		
		JLabel lblProprietaire = DefaultComponentFactory.getInstance().createLabel("Proprietaire");
		lblProprietaire.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblProprietaire);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_10 = new JLabel("");
		panel_1.add(label_10);
		
		JLabel label_1 = DefaultComponentFactory.getInstance().createLabel(" ");
		panel_1.add(label_1);
		
		JLabel label_12 = new JLabel("");
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("");
		panel_1.add(label_13);
		
		JLabel lblClasse = DefaultComponentFactory.getInstance().createLabel("Classe");
		lblClasse.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblClasse);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_15 = new JLabel("");
		panel_1.add(label_15);
		
		JLabel lblSerie = DefaultComponentFactory.getInstance().createLabel("Serie");
		lblSerie.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblSerie);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_17 = new JLabel("");
		panel_1.add(label_17);
		
		JLabel lblCoficient = DefaultComponentFactory.getInstance().createLabel("Co\u00E9ficient");
		lblCoficient.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblCoficient);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_19 = new JLabel("");
		panel_1.add(label_19);
		
		JLabel lblNom = DefaultComponentFactory.getInstance().createLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNom);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_21 = new JLabel("");
		panel_1.add(label_21);
		
		JLabel label_23 = new JLabel("");
		panel_1.add(label_23);
		
		JLabel label_24 = new JLabel("");
		panel_1.add(label_24);
		
		JLabel label_25 = new JLabel("");
		panel_1.add(label_25);
		
		JButton btnNouveau = new JButton("Nouveau");
		panel_1.add(btnNouveau);
		
		JButton btnModifier = new JButton("Modifier");
		panel_1.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		panel_1.add(btnSupprimer);
	}

}
