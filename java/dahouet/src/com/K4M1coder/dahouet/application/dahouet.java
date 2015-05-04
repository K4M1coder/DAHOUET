package com.K4M1coder.dahouet.application;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.K4M1coder.dahouet.application.ui.ConsoleMenu;
import com.K4M1coder.dahouet.application.ui.UiVoilierList;

public class dahouet {

	/**
	 * Initialize application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// // set look and feel

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		new dahouet();

		// // launch console for testing

		ConsoleMenu.menu();

	}

	/**
	 * Launch the application GUI.
	 */
	public dahouet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UiVoilierList frame = new UiVoilierList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
