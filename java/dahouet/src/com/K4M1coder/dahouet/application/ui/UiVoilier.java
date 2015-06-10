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
	private JSplitPane splitPane;
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

		splitPane = new JSplitPane();
		splitPane.setVisible(true);
		fenettrePrincipale.add(splitPane, BorderLayout.NORTH);

		JLabel lblVoiliersListe = DefaultComponentFactory.getInstance().createLabel("Voiliers");
		splitPane.setLeftComponent(lblVoiliersListe);

		comboBoxListeVoiliers = new JComboBox<Voilier>();
		splitPane.setRightComponent(comboBoxListeVoiliers);

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

		JPanel panel_1 = new JPanel();
		fenettrePrincipale.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(11, 3, 5, 5));

		JLabel label_6 = new JLabel("");
		panel_1.add(label_6);

		JLabel label_7 = new JLabel("");
		panel_1.add(label_7);

		JLabel label_8 = new JLabel("");
		panel_1.add(label_8);

		JLabel lblNomVoilier = new JLabel("Nom");
		lblNomVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNomVoilier);

		textField_NomVoilier = new JTextField();
		panel_1.add(textField_NomVoilier);
		textField_NomVoilier.setColumns(10);

		JLabel label = new JLabel("");
		panel_1.add(label);

		JLabel lblProprietaireVoilier = new JLabel("Proprietaire");
		panel_1.add(lblProprietaireVoilier);
		lblProprietaireVoilier.setHorizontalAlignment(SwingConstants.RIGHT);

		comboBoxListeProprietaires = new JComboBox<Proprietaire>();
		panel_1.add(comboBoxListeProprietaires);
		comboBoxListeProprietaires.removeAllItems();
		ArrayList<Proprietaire> listeProprietaires = control.proprioInit();
		for (Proprietaire proprio : listeProprietaires) {
			comboBoxListeProprietaires.addItem(proprio);

		}
		;

		btnNouvProp = new JButton("Nouveau");
		panel_1.add(btnNouvProp);
		btnNouvProp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				control.initOwnerNew();

			}
		});

		JLabel label_12 = new JLabel("");
		panel_1.add(label_12);

		JLabel label_24 = new JLabel("");
		panel_1.add(label_24);

		JLabel label_13 = new JLabel("");
		panel_1.add(label_13);

		JLabel lblSerieVoilier = new JLabel("Serie");
		lblSerieVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblSerieVoilier);

		comboBoxListeSeries = new JComboBox<Serie>();
		panel_1.add(comboBoxListeSeries);
		comboBoxListeSeries.removeAllItems();
		ArrayList<Serie> listeSeries = control.serieInit();
		for (Serie serie : listeSeries) {
			comboBoxListeSeries.addItem(serie);
		}
		;


		JLabel label2 = new JLabel("");
		panel_1.add(label2);

		JLabel lblClasseVoilier = new JLabel("Classe");
		lblClasseVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblClasseVoilier);

		comboBoxListeClasses = new JComboBox<Classe>();
		panel_1.add(comboBoxListeClasses);
		refreshListClasses();
		
		comboBoxListeSeries.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshListClasses();
			}
		});

		JLabel label3 = DefaultComponentFactory.getInstance().createLabel("");
		panel_1.add(label3);

		JLabel lblCoeficientVoilier = new JLabel("Co\u00E9ficient");
		lblCoeficientVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblCoeficientVoilier);

		textField_CoefVoilier = new JTextField();
		panel_1.add(textField_CoefVoilier);
		textField_CoefVoilier.setColumns(10);

		JLabel label_19 = new JLabel("");
		panel_1.add(label_19);

		JLabel lblNumVoileVoilier = new JLabel("voile N°");
		lblNumVoileVoilier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNumVoileVoilier);

		textfield_numVoileVoilier = new JTextField();
		textfield_numVoileVoilier.setEditable(false);
		panel_1.add(textfield_numVoileVoilier);
		textfield_numVoileVoilier.setColumns(10);

		JLabel label_23 = new JLabel("");
		panel_1.add(label_23);

		JLabel label_25 = new JLabel("");
		panel_1.add(label_25);

		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);

		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);

		btnNouveau = new JButton("Nouveau");
		panel_1.add(btnNouveau);
		btnNouveau.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierNewSetUI();
			}
		});

		btnModifier = new JButton("Modifier");
		panel_1.add(btnModifier);
		btnModifier.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierModSetUI();
			}
		});

		btnSupprimer = new JButton("Supprimer");
		panel_1.add(btnSupprimer);
		btnSupprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				voilierSupr();
			}
		});

		btnCreer = new JButton("Créer");
		panel_1.add(btnCreer);
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
		panel_1.add(btnEnreg);
		btnEnreg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshingListVoiliers = true;
				refreshListeVoiliers();
				voiliersListSetUI();

			}
		});

		btnAnnule = new JButton("Annuler");
		panel_1.add(btnAnnule);
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
		splitPane.setVisible(false);
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
		splitPane.setVisible(true);
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
		splitPane.setVisible(true);
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
