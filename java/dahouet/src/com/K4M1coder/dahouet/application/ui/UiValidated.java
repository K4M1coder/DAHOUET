package com.K4M1coder.dahouet.application.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class UiValidated extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;

	
	public UiValidated() {
		setBounds(100, 100, 278, 166);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		 btnNewButton = new JButton("Ok");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton.setBounds(97, 93, 63, 23);
		contentPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Acction réussie");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel.setBounds(42, 36, 184, 23);
		contentPanel.add(lblNewLabel);
	}
}
