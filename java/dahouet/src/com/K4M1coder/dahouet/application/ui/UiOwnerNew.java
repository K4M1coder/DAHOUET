package com.K4M1coder.dahouet.application.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.K4M1coder.dahouet.application.methodes.model.Club;
import com.K4M1coder.dahouet.application.methodes.model.Personne;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class UiOwnerNew extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fenettrePrincipale;
	private Control control = new Control();
	private JMenuBar menuBar;
	private JMenu mnProprio;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAdresse;
	private JTextField textFieldPhone;
	private JTextField textFieldDateNaissance;
	private JTextField textFieldMail;
	private JComboBox<Club> comboBoxListClubs;
	private JComboBox<Personne> comboBoxPersList;
	private Boolean refreshingListPers = false;
	private Personne personne;
	@SuppressWarnings("unused")
	private int selectedPers;
	private JTextField textFieldID;

	/**
	 * Create the main frame.
	 */
	public UiOwnerNew() {
		setTitle("Nouveau Proprietaire");

		// setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 366);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) // ici je surchage le
														// defaultcloseoperation
														// pour appeller une
														// fonction de
														// fermeture. plus tard
														// il faudra uttiliser
														// un cardlayout au lieu
														// de plusieurs JFrame
			{
				closeOwnerUI();
			}
		});

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnProprio = new JMenu("Proprietaire");
		menuBar.add(mnProprio);

		JMenuItem mntmRecordOwner = new JMenuItem("Enregistrer");
		mnProprio.add(mntmRecordOwner);

		mntmRecordOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ownerNewSetUI();
			}
		});

		JMenuItem mntmConcelNewOwner = new JMenuItem("Annuler");
		mnProprio.add(mntmConcelNewOwner);
		mntmConcelNewOwner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ownerModSetUI();

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

		JPanel panelMain = new JPanel();
		fenettrePrincipale.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new GridLayout(11, 3, 5, 5));

		JLabel lblID = new JLabel("id");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblID);
		
		textFieldID = new JTextField();
		panelMain.add(textFieldID);
		textFieldID.setColumns(10);

		JLabel label_30 = new JLabel("");
		panelMain.add(label_30);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblNom);

		textFieldNom = new JTextField();
		panelMain.add(textFieldNom);
		textFieldNom.setColumns(10);

		JLabel label_27 = new JLabel("");
		panelMain.add(label_27);

		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblPrnom);

		textFieldPrenom = new JTextField();
		panelMain.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);

		JLabel label_24 = new JLabel("");
		panelMain.add(label_24);

		JLabel lblAddresse = new JLabel("Addresse");
		lblAddresse.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblAddresse);

		textFieldAdresse = new JTextField();
		panelMain.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);

		JLabel label_21 = new JLabel("");
		panelMain.add(label_21);

		JLabel lblTlphone = new JLabel("Téléphone");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblTlphone);

		textFieldPhone = new JTextField();
		panelMain.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel label_18 = new JLabel("");
		panelMain.add(label_18);

		JLabel lblDateNaissance = new JLabel("Date naissance");
		lblDateNaissance.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblDateNaissance);

		textFieldDateNaissance = new JTextField();
		panelMain.add(textFieldDateNaissance);
		textFieldDateNaissance.setColumns(10);

		JLabel label_15 = new JLabel("");
		panelMain.add(label_15);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblMail);

		textFieldMail = new JTextField();
		panelMain.add(textFieldMail);
		textFieldMail.setColumns(10);

		JLabel label_12 = new JLabel("");
		panelMain.add(label_12);

		JLabel lblClub = new JLabel("Club");
		lblClub.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(lblClub);

		comboBoxListClubs = new JComboBox<Club>();
		panelMain.add(comboBoxListClubs);
		comboBoxListClubs.removeAllItems();
		ArrayList<Club> listeClubs = control.clubInit();
		for (Club club : listeClubs) {
			comboBoxListClubs.addItem(club);

		}
		;

		JLabel label_9 = new JLabel("");
		panelMain.add(label_9);

		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(label_8);

		JLabel label_7 = new JLabel("");
		panelMain.add(label_7);

		JLabel label_6 = new JLabel("");
		panelMain.add(label_6);

		JButton btnEnregistrer = new JButton("Enregistrer");
		panelMain.add(btnEnregistrer);
		btnEnregistrer.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ownerNewSetUI();
			}			
		});
		JLabel label_4 = new JLabel("");
		panelMain.add(label_4);

		JButton btnAnnuler = new JButton("Annuler");
		panelMain.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeOwnerUI();

			}
		});

		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panelMain.add(label_2);

		JLabel label_1 = new JLabel("");
		panelMain.add(label_1);

		JLabel label = new JLabel("");
		panelMain.add(label);

		JSplitPane splitPanePersonnes = new JSplitPane();
		splitPanePersonnes.setResizeWeight(1);
		fenettrePrincipale.add(splitPanePersonnes, BorderLayout.NORTH);

		JSplitPane splitPanePersEdit = new JSplitPane();
		splitPanePersEdit.setResizeWeight(.5d);
		splitPanePersonnes.setRightComponent(splitPanePersEdit);

		JButton btnModifier = new JButton("Modifier");
		splitPanePersEdit.setLeftComponent(btnModifier);

		JButton btnNouveau = new JButton("Nouveau");
		splitPanePersEdit.setRightComponent(btnNouveau);

		JSplitPane splitPanePersList = new JSplitPane();
		splitPanePersonnes.setLeftComponent(splitPanePersList);

		JLabel lblPersonne = new JLabel("Personne");
		splitPanePersList.setLeftComponent(lblPersonne);

		comboBoxPersList = new JComboBox<Personne>();
		splitPanePersList.setRightComponent(comboBoxPersList);
		comboBoxPersList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (refreshingListPers == false) {
					persLoadUI();
				}

			}
		});

		refreshingListPers = true;
		refreshListPers();
		persLoadUI();

	}

	private void refreshListPers() {
		comboBoxPersList.removeAllItems();
		ArrayList<Personne> listPers = control.persInit();

		for (Personne pers : listPers) {
			comboBoxPersList.addItem(pers);
		}
		refreshingListPers = false;
	}

	private void persLoadUI() {
		personne = (Personne) comboBoxPersList.getSelectedItem();
		selectedPers = personne.getIdPersonne();

		textFieldID.setText(Integer.toString(personne.getIdPersonne()));
		textFieldNom.setText(personne.getNom());
		textFieldPrenom.setText(personne.getPrenom());
		textFieldAdresse.setText(personne.getAddresse());
		textFieldPhone.setText(Long.toString(personne.getTelephone()));
		SimpleDateFormat dateN = new SimpleDateFormat("yyyy/MM/dd");
		textFieldDateNaissance.setText(dateN.format(personne.getDateN()));
		textFieldMail.setText(personne.getMail());
		
		
	}

	private void ownerNewSetUI() {

		int idPersonne = Integer.parseInt(textFieldID.getText()) ;
		int idPers = idPersonne;
		String nom = textFieldNom.getText();
		String prenom = textFieldPrenom.getText();
		String addresse = textFieldAdresse.getText();
		Long phone = Long.parseLong(textFieldPhone.getText());
		SimpleDateFormat dateN = new SimpleDateFormat("yyyy/MM/dd");
		String birthday = textFieldDateNaissance.getText();
		String mail = "mail.fr";
		Club club = (Club) comboBoxListClubs.getSelectedItem();
		int idClub = club.getIdClub();
		int idProprio = 0;

		Proprietaire proprio;
		try {
			proprio = new Proprietaire(idPersonne, nom, prenom, addresse, phone, dateN.parse(birthday), mail,
					idProprio, idClub, idPers);
			control.createProprio(proprio, club);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		control.initUIVoilier();
		dispose();
	}

	private void ownerModSetUI() {

	}

	private void closeOwnerUI() {
		control.initUIVoilier();
		dispose();
	}
}
