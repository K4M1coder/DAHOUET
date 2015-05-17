package com.K4M1coder.dahouet.application.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class UiVoilierList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fenettrePrincipale;
	private JTextField textField_ClasseVoilier;
	private JTextField textField_SerieVoilier;
	private JTextField textField_CoefVoilier;
	private JTextField textField_ProprietaireVoilier;
	private JTextField textField_NomVoilier;

	/**
	 * Create the main frame.
	 */
	@SuppressWarnings("rawtypes")
	public UiVoilierList() {
		setTitle("Voiliers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 366);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnVoilier = new JMenu("Voilier");
		menuBar.add(mnVoilier);
		
		JMenuItem mntmVoilierNouveauVoilier = new JMenuItem("Nouveau");
		mnVoilier.add(mntmVoilierNouveauVoilier);
		
		JMenuItem mntmVoilierModifierVoilier = new JMenuItem("Modifier");
		mnVoilier.add(mntmVoilierModifierVoilier);
		
		JMenuItem mntmVoilierSupprimerVoilier = new JMenuItem("Supprimer");
		mnVoilier.add(mntmVoilierSupprimerVoilier);
		
		JMenu mnAide = new JMenu("?");
		menuBar.add(mnAide);
		
		JMenuItem mntmAideAPropos = new JMenuItem("\u00E0 propos");
		mnAide.add(mntmAideAPropos);
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
		
		JComboBox comboBoxListeVoiliers = new JComboBox();
		splitPane.setRightComponent(comboBoxListeVoiliers);
		
		JPanel panel_1 = new JPanel();
		fenettrePrincipale.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(10, 3, 5, 5));
		
		JLabel label_6 = DefaultComponentFactory.getInstance().createLabel(" ");
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("");
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("");
		panel_1.add(label_8);
		
		JLabel lblNomVoilier = DefaultComponentFactory.getInstance().createLabel("Nom");
		lblNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNomVoilier);
		
		textField_NomVoilier = new JTextField();
		textField_NomVoilier.setEditable(false);
		panel_1.add(textField_NomVoilier);
		textField_NomVoilier.setColumns(10);
		
		JLabel label = DefaultComponentFactory.getInstance().createLabel("");
		panel_1.add(label);
		
		JLabel lblProprietaireVoilier = DefaultComponentFactory.getInstance().createLabel("Proprietaire");
		panel_1.add(lblProprietaireVoilier);
		lblProprietaireVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textField_ProprietaireVoilier = new JTextField();
		textField_ProprietaireVoilier.setEditable(false);
		panel_1.add(textField_ProprietaireVoilier);
		textField_ProprietaireVoilier.setColumns(10);
		
		JLabel label_1 = DefaultComponentFactory.getInstance().createLabel(" ");
		panel_1.add(label_1);
		
		JLabel label_12 = new JLabel("");
		panel_1.add(label_12);
		
		JLabel label_24 = new JLabel("");
		panel_1.add(label_24);
		
		JLabel label_13 = new JLabel("");
		panel_1.add(label_13);
		
		JLabel lblClasseVoilier = DefaultComponentFactory.getInstance().createLabel("Classe");
		lblClasseVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblClasseVoilier);
		
		textField_ClasseVoilier = new JTextField();
		textField_ClasseVoilier.setEditable(false);
		panel_1.add(textField_ClasseVoilier);
		textField_ClasseVoilier.setColumns(10);
		
		JLabel label_15 = new JLabel("");
		panel_1.add(label_15);
		
		JLabel lblSerieVoilier = DefaultComponentFactory.getInstance().createLabel("Serie");
		lblSerieVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblSerieVoilier);
		
		textField_SerieVoilier = new JTextField();
		textField_SerieVoilier.setEditable(false);
		panel_1.add(textField_SerieVoilier);
		textField_SerieVoilier.setColumns(10);
		
		JLabel label_17 = new JLabel("");
		panel_1.add(label_17);
		
		JLabel lblCoeficientVoilier = DefaultComponentFactory.getInstance().createLabel("Co\u00E9ficient");
		lblCoeficientVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblCoeficientVoilier);
		
		textField_CoefVoilier = new JTextField();
		textField_CoefVoilier.setEditable(false);
		panel_1.add(textField_CoefVoilier);
		textField_CoefVoilier.setColumns(10);
		
		JLabel label_19 = new JLabel("");
		panel_1.add(label_19);
		
		JLabel label_21 = new JLabel("");
		panel_1.add(label_21);
		
		JLabel label_23 = new JLabel("");
		panel_1.add(label_23);
		
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
