package com.MVCAct2.T22Act2.view.video;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.MVCAct2.T22Act2.controller.VideoController;
import com.MVCAct2.T22Act2.model.dto.Video;

public class RegisterVideoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VideoController videoController; // objeto personaController que permite la relacion entre esta clase y la
												// clase PersonaController
	private JLabel lblWindowTitle;
	private JTextField textTitle, textDirector, textClientId;

	private JLabel lblTitle, lblDirector, lblClientId;
	private JButton btnSave, btnCancel;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de registro
	 */
	public RegisterVideoView() {

		btnSave = new JButton();
		btnSave.setBounds(109, 242, 120, 25);
		btnSave.setText("Register");

		btnCancel = new JButton();
		btnCancel.setBounds(250, 242, 120, 25);
		btnCancel.setText("Cancel");

		lblWindowTitle = new JLabel();
		lblWindowTitle.setText("NEW VIDEO");
		lblWindowTitle.setBounds(173, 21, 380, 30);
		lblWindowTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblTitle = new JLabel();
		lblTitle.setText("Title");
		lblTitle.setBounds(20, 120, 80, 25);
		getContentPane().add(lblTitle);

		lblDirector = new JLabel();
		lblDirector.setText("Director");
		lblDirector.setBounds(230, 120, 80, 25);
		getContentPane().add(lblDirector);

		lblClientId = new JLabel();
		lblClientId.setText("Client Id");
		lblClientId.setBounds(20, 160, 80, 25);
		getContentPane().add(lblClientId);

		textTitle = new JTextField();
		textTitle.setBounds(80, 120, 125, 25);
		getContentPane().add(textTitle);

		textClientId = new JTextField();
		textClientId.setBounds(80, 156, 47, 25);
		getContentPane().add(textClientId);

		textDirector = new JTextField();
		textDirector.setBounds(295, 120, 125, 25);
		getContentPane().add(textDirector);

		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
		getContentPane().add(lblWindowTitle);
		limpiar();
		setSize(480, 325);
		setTitle("Register Video");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	private void limpiar() {
		textTitle.setText("");
		textDirector.setText("");
		textClientId.setText("");
	}

	public void setCoordinator(VideoController videoController) {
		this.videoController = videoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Video myVideo = new Video();
				myVideo.setTitle(textTitle.getText());
				myVideo.setDirector(textDirector.getText());
				myVideo.setClientId(Integer.parseInt(textClientId.getText()));

				videoController.addVideo(myVideo);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Insert data Error", "Error", JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}
	}

}
