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
import com.MVCAct2.T22Act2.model.service.VideoServ;

public class SearchVideoView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private VideoController videoController; // objeto personaController que permite la relacion entre esta clase y la
												// clase personaController
	private JLabel lblWindowTitle;
	private JTextField textId, textTitle, textDirector, textClientId;
	private JLabel lblId, lblTitle, lblDirector, lblClientId;
	private JButton btnSave, btnCancel, btnSearch, btnModify, btnDelete;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de busqueda
	 */
	public SearchVideoView() {

		btnSave = new JButton();
		btnSave.setBounds(32, 220, 120, 25);
		btnSave.setText("Register");
		btnSave.setEnabled(false);

		btnCancel = new JButton();
		btnCancel.setBounds(170, 245, 120, 25);
		btnCancel.setText("Cancel");

		btnSearch = new JButton();
		btnSearch.setBounds(151, 80, 100, 25);
		btnSearch.setText("Search");

		btnDelete = new JButton();
		btnDelete.setBounds(300, 220, 120, 25);
		btnDelete.setText("Delete");
		btnDelete.setEnabled(false);

		btnModify = new JButton();
		btnModify.setBounds(170, 220, 120, 25);
		btnModify.setText("Modify");

		lblWindowTitle = new JLabel();
		lblWindowTitle.setText("MANAGE VIDEOS");
		lblWindowTitle.setBounds(137, 27, 380, 30);
		lblWindowTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblId = new JLabel();
		lblId.setText("Id");
		lblId.setBounds(20, 80, 80, 25);
		getContentPane().add(lblId);

		lblTitle = new JLabel();
		lblTitle.setText("Title");
		lblTitle.setBounds(20, 120, 80, 25);
		getContentPane().add(lblTitle);

		lblDirector = new JLabel();
		lblDirector.setText("Director");
		lblDirector.setBounds(245, 120, 80, 25);
		getContentPane().add(lblDirector);

		lblClientId = new JLabel();
		lblClientId.setText("Client Id");
		lblClientId.setBounds(199, 160, 80, 25);
		getContentPane().add(lblClientId);

		textId = new JTextField();
		textId.setBounds(61, 80, 80, 25);
		getContentPane().add(textId);

		textTitle = new JTextField();
		textTitle.setBounds(61, 120, 155, 25);
		getContentPane().add(textTitle);

		textDirector = new JTextField();
		textDirector.setBounds(300, 120, 144, 25);
		textDirector.setEditable(false);
		getContentPane().add(textDirector);

		textClientId = new JTextField();
		textClientId.setBounds(255, 160, 189, 25);
		textClientId.setEditable(false);
		getContentPane().add(textClientId);

		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);

		getContentPane().add(btnCancel);
		getContentPane().add(btnSearch);
		getContentPane().add(btnModify);
		getContentPane().add(btnDelete);
		getContentPane().add(btnSave);
		getContentPane().add(lblWindowTitle);
		limpiar();

		setSize(480, 320);
		setTitle("Search Video");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	public void setCoordinador(VideoController videoController) {
		this.videoController = videoController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Video myVideo = new Video();
				myVideo.setId(Integer.parseInt(textId.getText()));
				myVideo.setTitle(textTitle.getText());
				myVideo.setDirector(textDirector.getText());
				myVideo.setClientId(Integer.parseInt(textClientId.getText()));

				videoController.modifyVideo(myVideo);

				if (VideoServ.modifyVideo == true) {
					habilita(true, true, true, true, true, false, true, false);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Data insert Error", "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == btnSearch) {
			Video myVideo = videoController.searchVideo(textId.getText());

			if (myVideo != null) {
				showVideo(myVideo);
			} else if (VideoServ.consultVideo == true) {
				JOptionPane.showMessageDialog(null, "Video doesn't exist", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == btnModify) {
			habilita(true, true, true, true, true, true, true, true);

		}

		if (e.getSource() == btnDelete) {
			if (!textId.getText().equals("")) {
				int respuesta = JOptionPane.showConfirmDialog(this, "Are you sure to delete a video?", "Confirmation",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION) {
					videoController.deleteVideo(textId.getText());
					limpiar();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Insert title", "Information", JOptionPane.WARNING_MESSAGE);
			}

		}
		if (e.getSource() == btnCancel) {
			this.dispose();
		}

	}

	/**
	 * permite cargar los datos de la persona consultada
	 * 
	 * @param myClient
	 */
	private void showVideo(Video myVideo) {
		textTitle.setText(myVideo.getTitle());
		textDirector.setText(myVideo.getDirector() + "");
		textClientId.setText(myVideo.getClientId() + "");

		habilita(true, true, false, false, false, false, true, false);
	}

	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar() {
		textId.setText("");
		textTitle.setText("");
		textDirector.setText("");
		textClientId.setText("");

		habilita(true, true, false, false, false, false, false, false);
	}

	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * 
	 * @param id
	 * @param title
	 * @param director
	 * @param clientId
	 * @param dni
	 * @param date
	 * @param bSearch
	 * @param bSave
	 * @param bModify
	 * @param bDelete
	 */
	public void habilita(boolean id, boolean bSearch, boolean title, boolean director, boolean clientId, boolean bSave,
			boolean bModify, boolean bDelete) {
		textId.setEditable(id);
		textTitle.setEditable(title);
		textDirector.setEditable(director);
		textClientId.setEditable(clientId);

		btnSearch.setEnabled(bSearch);
		btnSave.setEnabled(bSave);
		btnModify.setEnabled(bModify);
		btnDelete.setEnabled(bDelete);
	}

}
