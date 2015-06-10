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
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.K4M1coder.dahouet.application.control.Control;
import com.K4M1coder.dahouet.application.methodes.model.Club;
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

	/**
	 * Create the main frame.
	 */
	public UiOwnerNew() {
		setTitle("Nouveau Proprietaire");

		// setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 562, 366);

		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)  // ici je surchage le defaultcloseoperation pour appeller une fonction de fermeture. plus tard il faudra uttiliser un cardlayout au lieu de plusieurs jframe
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

		JPanel panel_1 = new JPanel();
		fenettrePrincipale.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(11, 3, 5, 5));

		JLabel label_32 = new JLabel("");
		label_32.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(label_32);

		JLabel label_31 = new JLabel("");
		panel_1.add(label_31);

		JLabel label_30 = new JLabel("");
		panel_1.add(label_30);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNom);

		textFieldNom = new JTextField();
		panel_1.add(textFieldNom);
		textFieldNom.setColumns(10);

		JLabel label_27 = new JLabel("");
		panel_1.add(label_27);

		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblPrnom);

		textFieldPrenom = new JTextField();
		panel_1.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);

		JLabel label_24 = new JLabel("");
		panel_1.add(label_24);

		JLabel lblAddresse = new JLabel("Addresse");
		lblAddresse.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblAddresse);

		textFieldAdresse = new JTextField();
		panel_1.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);

		JLabel label_21 = new JLabel("");
		panel_1.add(label_21);

		JLabel lblTlphone = new JLabel("Téléphone");
		lblTlphone.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblTlphone);

		textFieldPhone = new JTextField();
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel label_18 = new JLabel("");
		panel_1.add(label_18);

		JLabel lblDateNaissance = new JLabel("Date naissance");
		lblDateNaissance.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblDateNaissance);

		textFieldDateNaissance = new JTextField();
		panel_1.add(textFieldDateNaissance);
		textFieldDateNaissance.setColumns(10);

		JLabel label_15 = new JLabel("");
		panel_1.add(label_15);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblMail);

		textFieldMail = new JTextField();
		panel_1.add(textFieldMail);
		textFieldMail.setColumns(10);

		JLabel label_12 = new JLabel("");
		panel_1.add(label_12);

		JLabel lblClub = new JLabel("Club");
		lblClub.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblClub);

		comboBoxListClubs = new JComboBox<Club>();
		panel_1.add(comboBoxListClubs);
		comboBoxListClubs.removeAllItems();
		ArrayList<Club> listeClubs = control.clubInit();
		for (Club club : listeClubs) {
			comboBoxListClubs.addItem(club);

		}
		;

		JLabel label_9 = new JLabel("");
		panel_1.add(label_9);

		JLabel label_8 = new JLabel("");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(label_8);

		JLabel label_7 = new JLabel("");
		panel_1.add(label_7);

		JLabel label_6 = new JLabel("");
		panel_1.add(label_6);

		JButton btnEnregistrer = new JButton("Enregistrer");
		panel_1.add(btnEnregistrer);

		JLabel label_4 = new JLabel("");
		panel_1.add(label_4);

		JButton btnAnnuler = new JButton("Annuler");
		panel_1.add(btnAnnuler);
		btnAnnuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeOwnerUI();

			}
		});

		JLabel label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(label_2);

		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);

		JLabel label = new JLabel("");
		panel_1.add(label);

	}

	private void ownerNewSetUI() {

		int idPersonne = 0, idPers= idPersonne;
		String nom=textFieldNom.getText();
		String prenom=textFieldPrenom.getText();
		String addresse=textFieldAdresse.getText();
		Long phone=Long.parseLong(textFieldPhone.getText());
		SimpleDateFormat dateN = new SimpleDateFormat("yyyy/MM/dd");
		String birthday = textFieldDateNaissance.getText();
		String mail="mail.fr";		
		Club club = (Club) comboBoxListClubs.getSelectedItem();
		int idClub=club.getIdClub();
		int idProprio=0;
		
		@SuppressWarnings("unused")
		Proprietaire proprio;
		try {
			proprio = new Proprietaire(idPersonne, nom,	prenom,	addresse, phone, dateN.parse(birthday),	mail, idProprio, idClub, idPers);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		control.initVoilierList();
		dispose();
	}

	private void ownerModSetUI() {

	}
	
	private void closeOwnerUI(){
		control.initVoilierList();
		dispose();
	}
}
