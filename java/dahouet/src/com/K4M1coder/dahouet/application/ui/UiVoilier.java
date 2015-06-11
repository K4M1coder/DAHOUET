package com.K4M1coder.dahouet.application.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.K4M1coder.dahouet.application.control.Control;
import com.K4M1coder.dahouet.application.methodes.model.Classe;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.K4M1coder.dahouet.application.methodes.model.Serie;
import com.K4M1coder.dahouet.application.methodes.model.Voilier;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class UiVoilier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fenettrePrincipale;
	private JTextField textField_CoefVoilier;
	private JTextField textField_NomVoilier;
	private JTextField textfield_numVoileVoilier;
	private JComboBox<Voilier> comboBoxListeVoiliers;
	private JComboBox<Proprietaire> comboBoxListeProprietaires;
	private JComboBox<Classe> comboBoxListeClasses;
	private JComboBox<Serie> comboBoxListeSeries;
	private JButton btnNouveau;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JButton btnNouvProp;
	private JButton btnCreer;
	private JButton btnEnreg;
	private JButton btnAnnule;
	private Control control = new Control();
	private JSplitPane splitPaneListVoiliers;
	private JMenuBar menuBar;
	private JMenu mnVoilier;
	private int selectedVoilier;
	private Voilier voilier;
	private Boolean refreshingListVoiliers = false; // todo : add refresh button

	/**
	 * Create the main frame.
	 */
	public UiVoilier() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 366);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnVoilier = new JMenu("Voilier");
		menuBar.add(mnVoilier);

		JMenuItem mntmVoilierNouveauVoilier = new JMenuItem("Nouveau");
		mnVoilier.add(mntmVoilierNouveauVoilier);

		mntmVoilierNouveauVoilier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voilierNewSetUI();
			}
		});

		JMenuItem mntmVoilierModifierVoilier = new JMenuItem("Modifier");
		mnVoilier.add(mntmVoilierModifierVoilier);
		mntmVoilierModifierVoilier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				voilierModSetUI();

			}
		});

		JMenuItem mntmVoilierSupprimerVoilier = new JMenuItem("Supprimer");
		mnVoilier.add(mntmVoilierSupprimerVoilier);
		mntmVoilierSupprimerVoilier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				voilierSupr();

			}
		});

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

		splitPaneListVoiliers = new JSplitPane();
		splitPaneListVoiliers.setVisible(true);
		fenettrePrincipale.add(splitPaneListVoiliers, BorderLayout.NORTH);

		JLabel lblVoiliersListe = DefaultComponentFactory.getInstance().createLabel("Voiliers");
		splitPaneListVoiliers.setLeftComponent(lblVoiliersListe);

		comboBoxListeVoiliers = new JComboBox<Voilier>();
		splitPaneListVoiliers.setRightComponent(comboBoxListeVoiliers);

		comboBoxListeVoiliers.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (refreshingListVoiliers == false) {
					voilierLoadUI();
				}
			}
		});

		refreshingListVoiliers = true;
		refreshListeVoiliers();

		JPanel panelMain = new JPanel();
		fenettrePrincipale.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(11, 3, 5, 5));

		JLabel label_6 = new JLabel("");
		panelMain.add(label_6);

		JLabel label_7 = new JLabel("");
		panelMain.add(label_7);

		JLabel label_8 = new JLabel("");
		panelMain.add(label_8);

		JLabel lblNomVoilier = new JLabel("Nom");
		lblNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblNomVoilier);

		textField_NomVoilier = new JTextField();
		panelMain.add(textField_NomVoilier);
		textField_NomVoilier.setColumns(10);

		JLabel label = new JLabel("");
		panelMain.add(label);

		JLabel lblProprietaireVoilier = new JLabel("Proprietaire");
		panelMain.add(lblProprietaireVoilier);
		lblProprietaireVoilier.setHorizontalAlignment(SwingConstants.RIGHT);

		comboBoxListeProprietaires = new JComboBox<Proprietaire>();
		panelMain.add(comboBoxListeProprietaires);
		comboBoxListeProprietaires.removeAllItems();
		ArrayList<Proprietaire> listeProprietaires = control.proprioInit();
		for (Proprietaire proprio : listeProprietaires) {
			comboBoxListeProprietaires.addItem(proprio);

		}
		;

		btnNouvProp = new JButton("Nouveau");
		panelMain.add(btnNouvProp);
		btnNouvProp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				control.initUIOwner();

			}
		});

		JLabel label_12 = new JLabel("");
		panelMain.add(label_12);

		JLabel label_24 = new JLabel("");
		panelMain.add(label_24);

		JLabel label_13 = new JLabel("");
		panelMain.add(label_13);

		JLabel lblSerieVoilier = new JLabel("Serie");
		lblSerieVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblSerieVoilier);

		comboBoxListeSeries = new JComboBox<Serie>();
		panelMain.add(comboBoxListeSeries);
		comboBoxListeSeries.removeAllItems();
		ArrayList<Serie> listeSeries = control.serieInit();
		for (Serie serie : listeSeries) {
			comboBoxListeSeries.addItem(serie);
		}
		;


		JLabel label2 = new JLabel("");
		panelMain.add(label2);

		JLabel lblClasseVoilier = new JLabel("Classe");
		lblClasseVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblClasseVoilier);

		comboBoxListeClasses = new JComboBox<Classe>();
		panelMain.add(comboBoxListeClasses);
		refreshListClasses();
		
		comboBoxListeSeries.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshListClasses();
			}
		});

		JLabel label3 = DefaultComponentFactory.getInstance().createLabel("");
		panelMain.add(label3);

		JLabel lblCoeficientVoilier = new JLabel("Co\u00E9ficient");
		lblCoeficientVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblCoeficientVoilier);

		textField_CoefVoilier = new JTextField();
		panelMain.add(textField_CoefVoilier);
		textField_CoefVoilier.setColumns(10);

		JLabel label_19 = new JLabel("");
		panelMain.add(label_19);

		JLabel lblNumVoileVoilier = new JLabel("voile N°");
		lblNumVoileVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblNumVoileVoilier);

		textfield_numVoileVoilier = new JTextField();
		textfield_numVoileVoilier.setEditable(false);
		panelMain.add(textfield_numVoileVoilier);
		textfield_numVoileVoilier.setColumns(10);

		JLabel label_23 = new JLabel("");
		panelMain.add(label_23);

		JLabel label_25 = new JLabel("");
		panelMain.add(label_25);

		JLabel label_2 = new JLabel("");
		panelMain.add(label_2);

		JLabel label_3 = new JLabel("");
		panelMain.add(label_3);

		btnNouveau = new JButton("Nouveau");
		panelMain.add(btnNouveau);
		btnNouveau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierNewSetUI();
			}
		});

		btnModifier = new JButton("Modifier");
		panelMain.add(btnModifier);
		btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierModSetUI();
			}
		});

		btnSupprimer = new JButton("Supprimer");
		panelMain.add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierSupr();
			}
		});

		btnCreer = new JButton("Créer");
		panelMain.add(btnCreer);
		btnCreer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilier = new Voilier(0, 0, Double.parseDouble(textField_CoefVoilier.getText()), comboBoxListeClasses
						.getSelectedItem().toString(), textField_NomVoilier.getText(), Integer
						.parseInt(textfield_numVoileVoilier.getText()));
				control.createVoilier(voilier, (Proprietaire) comboBoxListeProprietaires.getSelectedItem());
				refreshingListVoiliers = true;
				refreshListeVoiliers();
				voiliersListSetUI();
			}
		});

		btnEnreg = new JButton("Enregistrer");
		panelMain.add(btnEnreg);
		btnEnreg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshingListVoiliers = true;
				refreshListeVoiliers();
				voiliersListSetUI();

			}
		});

		btnAnnule = new JButton("Annuler");
		panelMain.add(btnAnnule);
		btnAnnule.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierLoadUI();
				voiliersListSetUI();
			}
		});

		voilierLoadUI();
		voiliersListSetUI();

	}

	private void refreshListeVoiliers() {
		comboBoxListeVoiliers.removeAllItems();
		ArrayList<Voilier> listVoiliers = control.voilierInit();

		for (Voilier voilier : listVoiliers) {
			comboBoxListeVoiliers.addItem(voilier);
		}
		refreshingListVoiliers = false;
	}
	
	private void refreshListClasses() {
		comboBoxListeClasses.removeAllItems();
		ArrayList<Classe> listeClasses = control.classeInit();
		for (Classe classe : listeClasses) {
			if (classe.getSerieClasse().equals(comboBoxListeSeries.getSelectedItem().toString())) {
				comboBoxListeClasses.addItem(classe);
			}
		}
		;
	}

	private void voilierLoadUI() {

		voilier = (Voilier) comboBoxListeVoiliers.getSelectedItem();
		selectedVoilier = voilier.getIdvoilier();

		textField_NomVoilier.setText(voilier.getName());

		ArrayList<Proprietaire> listProprietaires = control.proprioInit();
		Proprietaire proprio = (Proprietaire) listProprietaires.get(voilier.getOwner() - 1);
		String targetProp = proprio.toString();
		for (int i = 0; i < comboBoxListeProprietaires.getItemCount(); i++) {
			Proprietaire comboProp = comboBoxListeProprietaires.getItemAt(i);
			if (targetProp.equals(comboProp.toString())) {
				comboBoxListeProprietaires.setSelectedIndex(i);
				i = comboBoxListeProprietaires.getItemCount();
			}
		}

		ArrayList<Classe> classeVoilier = control.classeInit();
		String serie = null;
		for (Classe classe : classeVoilier) {
			String serieClasse = classe.getSerieClasse();
			if (classe.getNomClasse().equals(voilier.getClasse())) {
				serie = serieClasse;
			}
		}
		String targetSerie = serie.toString();
		for (int i = 0; i < comboBoxListeSeries.getItemCount(); i++) {
			Serie comboSerie = comboBoxListeSeries.getItemAt(i);
			if (targetSerie.equals(comboSerie.toString())) {
				comboBoxListeSeries.setSelectedIndex(i);
				i = comboBoxListeSeries.getItemCount();
			}
		}
		
		String targetClasse = voilier.getClasse();
		for (int i = 0; i < comboBoxListeClasses.getItemCount(); i++) {
			Classe comboClasse = comboBoxListeClasses.getItemAt(i);
			if (targetClasse.equals(comboClasse.toString())) {
				comboBoxListeClasses.setSelectedIndex(i);
				i = comboBoxListeClasses.getItemCount();
			}
		}

		textField_CoefVoilier.setText(Double.toString(voilier.getCoef()));

		textfield_numVoileVoilier.setText(Integer.toString(voilier.getNum()));
	}

	private void voilierNewSetUI() {
		splitPaneListVoiliers.setVisible(false);
		textField_NomVoilier.setText("");
		textField_NomVoilier.setEditable(true);
		comboBoxListeProprietaires.setEnabled(true);
		comboBoxListeSeries.setSelectedIndex(0);
		comboBoxListeSeries.setEnabled(true);
		comboBoxListeClasses.setSelectedIndex(0);
		comboBoxListeClasses.setEnabled(true);
		textField_CoefVoilier.setText("0.0");
		textField_CoefVoilier.setEditable(true);
		textfield_numVoileVoilier.setText("");
		textfield_numVoileVoilier.setEditable(true);
		btnModifier.setVisible(false);
		btnNouveau.setVisible(false);
		btnSupprimer.setVisible(false);
		mnVoilier.setEnabled(false);
		btnNouvProp.setVisible(true);
		btnCreer.setVisible(true);
		btnEnreg.setVisible(false);
		btnAnnule.setVisible(true);
		setTitle("Nouveau Voiliers");
	}

	private void voilierModSetUI() {
		splitPaneListVoiliers.setVisible(true);
		textField_NomVoilier.setEditable(true);
		comboBoxListeVoiliers.setEnabled(false);
		comboBoxListeProprietaires.setEnabled(true);
		comboBoxListeSeries.setEnabled(true);
		comboBoxListeClasses.setEnabled(true);
		textField_CoefVoilier.setEditable(true);
		textfield_numVoileVoilier.setEditable(true);
		btnModifier.setVisible(false);
		btnNouveau.setVisible(false);
		btnSupprimer.setVisible(false);
		mnVoilier.setEnabled(false);
		btnNouvProp.setVisible(true);
		btnCreer.setVisible(false);
		btnEnreg.setVisible(true);
		btnAnnule.setVisible(true);
		setTitle("Modification du Voiliers ID:" + selectedVoilier);
	}

	private void voiliersListSetUI() {
		splitPaneListVoiliers.setVisible(true);
		comboBoxListeVoiliers.setEnabled(true);
		comboBoxListeVoiliers.setSelectedIndex(selectedVoilier - 1);
		textField_NomVoilier.setEditable(false);
		comboBoxListeProprietaires.setEnabled(false);
		comboBoxListeSeries.setEnabled(false);
		comboBoxListeClasses.setEnabled(false);
		textField_CoefVoilier.setEditable(false);
		textfield_numVoileVoilier.setEditable(false);
		btnModifier.setVisible(true);
		btnNouveau.setVisible(true);
		btnSupprimer.setVisible(true);
		mnVoilier.setEnabled(true);
		btnNouvProp.setVisible(false);
		btnCreer.setVisible(false);
		btnEnreg.setVisible(false);
		btnAnnule.setVisible(false);
		setTitle("Liste Voiliers");
	}

	private void voilierSupr() {
		voilierLoadUI();
		voiliersListSetUI();
	}

}
