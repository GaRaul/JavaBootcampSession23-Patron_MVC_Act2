package com.MVCAct2.T22Act2.view.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import com.MVCAct2.T22Act2.controller.ClientController;
import com.MVCAct2.T22Act2.model.dto.Client;

public class RegisterClientView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ClientController clientController; // objeto personaController que permite la relacion entre esta clase y la
												// clase PersonaController
	private JLabel lblTitle;
	private JTextField textName, textSurname, textAddress, textDni;

	private JLabel lblName, lblSurname, lblAddress, lblDni, lblDate, lblLocalDate, lblIdSelected;
	private JButton btnSave, btnCancel;

	/**
	 * constructor de la clase donde se inicializan todos los componentes de la
	 * ventana de registro
	 */
	public RegisterClientView() {

		btnSave = new JButton();
		btnSave.setBounds(109, 242, 120, 25);
		btnSave.setText("Register");

		btnCancel = new JButton();
		btnCancel.setBounds(250, 242, 120, 25);
		btnCancel.setText("Cancel");

		lblTitle = new JLabel();
		lblTitle.setText("NEW CLIENT");
		lblTitle.setBounds(173, 21, 380, 30);
		lblTitle.setFont(new java.awt.Font("Verdana", 1, 18));

		lblName = new JLabel();
		lblName.setText("Name");
		lblName.setBounds(20, 120, 80, 25);
		getContentPane().add(lblName);

		lblSurname = new JLabel();
		lblSurname.setText("Surname");
		lblSurname.setBounds(230, 120, 80, 25);
		getContentPane().add(lblSurname);
		
		lblAddress = new JLabel();
		lblAddress.setText("Address");
		lblAddress.setBounds(20, 160, 80, 25);
		getContentPane().add(lblAddress);

		lblDni = new JLabel();
		lblDni.setText("Dni");
		lblDni.setBounds(123, 80, 37, 25);
		getContentPane().add(lblDni);
		
		lblDate = new JLabel();
		lblDate.setText("Date:");
		lblDate.setBounds(313, 80, 34, 25);
		getContentPane().add(lblDate);
		
		lblLocalDate = new JLabel();
		lblLocalDate.setBounds(357, 80, 69, 25);
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedLocalDate = localDate.format(formatter);
		lblLocalDate.setText(formattedLocalDate.toString());
		getContentPane().add(lblLocalDate);

		lblIdSelected = new JLabel();
		lblIdSelected.setBounds(54, 80, 46, 25);
		getContentPane().add(lblIdSelected);

		textName = new JTextField();
		textName.setBounds(80, 120, 125, 25);
		getContentPane().add(textName);

		textAddress = new JTextField();
		textAddress.setBounds(80, 156, 340, 25);
		getContentPane().add(textAddress);

		textSurname = new JTextField();
		textSurname.setBounds(295, 120, 125, 25);
		getContentPane().add(textSurname);

		textDni = new JTextField();
		textDni.setBounds(156, 80, 125, 25);
		getContentPane().add(textDni);
		
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		getContentPane().add(btnCancel);
		getContentPane().add(btnSave);
		getContentPane().add(lblTitle);
		limpiar();
		setSize(480, 325);
		setTitle("Register Client");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}

	private void limpiar() {
//		textId.setText("");
		textName.setText("");
		textSurname.setText("");
		textAddress.setText("");
		textDni.setText("");
	}

	public void setCoordinator(ClientController clientController) {
		this.clientController = clientController;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			try {
				Client myClient = new Client();
				myClient.setName(textName.getText());
				myClient.setSurname(textSurname.getText());
				myClient.setAddress(textAddress.getText());
				myClient.setDni(textDni.getText());
				myClient.setLocalDate(lblLocalDate.getText().toString());

				clientController.addClient(myClient);
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
