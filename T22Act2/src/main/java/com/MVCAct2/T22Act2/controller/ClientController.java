package com.MVCAct2.T22Act2.controller;

import com.MVCAct2.T22Act2.model.dto.Client;
import com.MVCAct2.T22Act2.model.service.ClientServ;
import com.MVCAct2.T22Act2.view.*;
import com.MVCAct2.T22Act2.view.client.RegisterClientView;
import com.MVCAct2.T22Act2.view.client.SearchClientView;

public class ClientController {
	
	private ClientServ clientServ;
	private MenuView myMenuView;
	private RegisterClientView myRegisterClientView;
	private SearchClientView mySearchClientView;
	
	//Metodos getter Setters de vistas
	public ClientServ getClientServ() {
		return clientServ;
	}

	public void setClientServ(ClientServ clientServ) {
		this.clientServ = clientServ;
	}

	public MenuView getMyMenuView() {
		return myMenuView;
	}

	public void setMyMenuView(MenuView myMenuView) {
		this.myMenuView = myMenuView;
	}

	public RegisterClientView getMyRegisterClientView() {
		return myRegisterClientView;
	}

	public void setMyRegisterClientView(RegisterClientView myRegisterClientView) {
		this.myRegisterClientView = myRegisterClientView;
	}

	public SearchClientView getMySearchClientView() {
		return mySearchClientView;
	}

	public void setMySearchClientView(SearchClientView mySearchClientView) {
		this.mySearchClientView = mySearchClientView;
	}
	
	//Hace visible las vistas de Registro y Consulta
    public void showRegisterClientView() {
        myRegisterClientView.setVisible(true);
    }
    public void showSearchClientView() {
        mySearchClientView.setVisible(true);
    }
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
    public void addClient(Client myClient) {
        clientServ.validateRegister(myClient);
    }    
    
    public Client searchClient(String idClient) {
		return clientServ.validateQuery(idClient);
	}
	
	public void modifyClient(Client myClient) {
		clientServ.validateModification(myClient);
	}
	
	public void deleteClient(String idClient) {
		clientServ.validateDelete(idClient);
	}
	
	
}
