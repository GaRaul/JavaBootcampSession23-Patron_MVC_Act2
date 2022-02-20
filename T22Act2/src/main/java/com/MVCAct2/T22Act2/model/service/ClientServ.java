package com.MVCAct2.T22Act2.model.service;

import javax.swing.JOptionPane;

import com.MVCAct2.T22Act2.controller.ClientController;
import com.MVCAct2.T22Act2.model.dao.ClientDao;
import com.MVCAct2.T22Act2.model.dto.Client;

public class ClientServ {
	private ClientController clientController;
	public static boolean consultClient = false;
	public static boolean modifyClient = false;

	// Metodo de vinculación con el controller principal
	public void setClientController(ClientController clientController) {
		this.setController(clientController);		
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validateRegister(Client myClient) {
		ClientDao myClientDao;
		if (myClient.getDni().length() > 3) {
			myClientDao = new ClientDao();
			myClientDao.registerClient(myClient);
		} else {
			JOptionPane.showMessageDialog(null, "The document must have more than 3 digits", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Client validateQuery(String idClient) {
		ClientDao myClientDao;

		try {
			int id = Integer.parseInt(idClient);//mirar
			if (id >= 0 || id <= 200) {
				myClientDao = new ClientDao();
				consultClient = true;
				return myClientDao.searchClient(id);
			} else {
				JOptionPane.showMessageDialog(null, "The client's id must be between 1-200",
						"Warning", JOptionPane.WARNING_MESSAGE);
				consultClient = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Must introduce numerical data", "Error", JOptionPane.ERROR_MESSAGE);
			consultClient = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There is an Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultClient = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validateModification(Client myClient) {
		ClientDao myClientDao;
		if (myClient.getName().length() > 3) {
			myClientDao = new ClientDao();
			myClientDao.modifyClient(myClient);
			modifyClient = true;
		} else {
			JOptionPane.showMessageDialog(null, "The client's name must have more than 3 digits", "Warning",
					JOptionPane.WARNING_MESSAGE);
			modifyClient = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validateDelete(String codigo) {
		ClientDao myClientDao = new ClientDao();
		myClientDao.deleteClient(codigo);
	}

	public ClientController getClientController() {
		return clientController;
	}

	public void setController(ClientController clientController) {
		this.clientController = clientController;
	}

}
