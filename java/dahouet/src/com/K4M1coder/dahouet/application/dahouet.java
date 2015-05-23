package com.K4M1coder.dahouet.application;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.K4M1coder.dahouet.application.control.Control;
import com.K4M1coder.dahouet.application.ui.ConsoleMenu;

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
					Control control = new Control();
					control.initVoilierList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
