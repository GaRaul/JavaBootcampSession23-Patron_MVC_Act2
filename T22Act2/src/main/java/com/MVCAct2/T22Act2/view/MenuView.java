package com.MVCAct2.T22Act2.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.MVCAct2.T22Act2.controller.ClientController;
import com.MVCAct2.T22Act2.controller.VideoController;

import javax.swing.JLabel;
import javax.swing.JButton;

public class MenuView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ClientController clientController;
	private VideoController videoController; // objeto PersonaController que permite la relacion entre esta clase y
												// la clase PersonaController
	private JTextArea areaIntroduction;
	private JLabel lblTitle, lblSelection;
	private JButton btnRegisterClient, btnSearchClient, btnRegisterVideo, btnSearchVideo;

	/**
	 * Establece la informacion que se presentara como introduccion del sistema
	 */
	public String textoIntroduccion = "";

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana principal
	 */
	public MenuView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btnRegisterClient = new JButton();
		btnRegisterClient.setBounds(100, 280, 120, 25);
		btnRegisterClient.setText("Register Client");

		btnSearchClient = new JButton();
		btnSearchClient.setBounds(240, 280, 120, 25);
		btnSearchClient.setText("Search Client");

		btnRegisterVideo = new JButton();
		btnRegisterVideo.setText("Register Video");
		btnRegisterVideo.setBounds(100, 311, 120, 25);
		getContentPane().add(btnRegisterVideo);

		btnSearchVideo = new JButton();
		btnSearchVideo.setText("Search Video");
		btnSearchVideo.setBounds(240, 312, 120, 25);
		getContentPane().add(btnSearchVideo);

		lblTitle = new JLabel();
		lblTitle.setText("MVC DESIGN PATRON");
		lblTitle.setBounds(141, 38, 380, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 15));

		lblSelection = new JLabel();
		lblSelection.setText("CHOOSE AN OPTION");
		lblSelection.setBounds(171, 241, 250, 25);

		textoIntroduccion = "This application shows a practical example of MVC design Patron.\n\n"
				+ "The application allows to register, search, modify and delete registers from a Clients database.";

		areaIntroduction = new JTextArea();
		areaIntroduction.setBounds(50, 90, 380, 140);
		areaIntroduction.setEditable(false);
		areaIntroduction.setFont(new java.awt.Font("Verdana", 0, 14));
		areaIntroduction.setLineWrap(true);
		areaIntroduction.setText(textoIntroduccion);
		areaIntroduction.setWrapStyleWord(true);
		areaIntroduction.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED,
				null, null, null, new java.awt.Color(0, 0, 0)));

		btnRegisterClient.addActionListener(this);
		btnSearchClient.addActionListener(this);

		btnRegisterVideo.addActionListener(this);
		btnSearchVideo.addActionListener(this);

		getContentPane().add(btnSearchClient);
		getContentPane().add(btnRegisterClient);
		getContentPane().add(lblSelection);
		getContentPane().add(lblTitle);
		getContentPane().add(areaIntroduction);

		setSize(480, 386);
		setTitle("CLIENTS DATABASE");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public void setClientCoordinator(ClientController clientController) {
		this.clientController = clientController;
	}

	public void setVideoCoordinator(VideoController videoController) {
		this.videoController = videoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegisterClient) {
			clientController.showRegisterClientView();
		}
		if (e.getSource() == btnSearchClient) {
			clientController.showSearchClientView();
		}
		if (e.getSource() == btnRegisterVideo) {
			videoController.showRegisterVideoView();
		}
		if (e.getSource() == btnSearchVideo) {
			videoController.showSearchVideoView();
		}
	}
}
