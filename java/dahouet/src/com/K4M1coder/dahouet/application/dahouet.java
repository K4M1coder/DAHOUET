package com.K4M1coder.dahouet.application;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.K4M1coder.dahouet.application.ui.Console;
import com.K4M1coder.dahouet.application.ui.MainFrame;

public class dahouet {

	/**
	 * Initialize application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// //////////////////////////////////////////////////////////////////////////////////////

		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		new dahouet();

		// //////////////////////////////////////////////////////////////////////////////////////

		Console.menu();

	}

	/**
	 * Launch the application GUI.
	 */
	public dahouet() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
