package com.K4M1coder.dahouet.application;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.K4M1coder.dahouet.application.methodes.Controls;
import com.K4M1coder.dahouet.application.methodes.utils.Lire;
import com.K4M1coder.dahouet.application.ui.MainUI;

public class dahouet {

	/**
	 * Initialize application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = false;
		int mainAct;

		// //////////////////////////////////////////////////////////////////////////////////////

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		new dahouet();

		// //////////////////////////////////////////////////////////////////////////////////////

		do {
			do {
				System.out.print("\n1- Création de villes et capitales\n"
						+ "2- Liste des villes et capitales des pays\n"
						+ "3- Liste des villes et capitales d'un pays\n"
						+ "4- Liste des pays\n" + "5- sauvegarde liste\n"
						+ "6- restaure liste\n" + "7- FIN\n");
				mainAct = Lire.i();
			} while (!Controls.intchx(mainAct, 1, 8));
			switch (mainAct) {
			case 1:

				run = true;
				break;
			case 2:

				run = true;
				break;
			case 3:

				run = true;
				break;
			case 4:

				run = true;
				break;
			case 5:

				run = true;
				break;
			case 6:

				run = true;
				break;
			case 7:
				run = false;
				break;
			case 8:

				run = true;
				break;
			}
		} while (run == true);
		System.exit(0);
	}

	/**
	 * Launch the application GUI.
	 */
	public dahouet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
