package com.MVCAct2.T22Act2;

import com.MVCAct2.T22Act2.controller.ClientController;
import com.MVCAct2.T22Act2.controller.VideoController;
import com.MVCAct2.T22Act2.model.service.ClientServ;
import com.MVCAct2.T22Act2.model.service.VideoServ;
import com.MVCAct2.T22Act2.view.*;
import com.MVCAct2.T22Act2.view.client.RegisterClientView;
import com.MVCAct2.T22Act2.view.client.SearchClientView;
import com.MVCAct2.T22Act2.view.video.RegisterVideoView;
import com.MVCAct2.T22Act2.view.video.SearchVideoView;

/**
 * Hello world!
 *
 */
public class App 
{
	ClientServ myClientServ;
	VideoServ myVideoServ;
	MenuView myMenuView;
	SearchClientView mySearchClientView;
	RegisterClientView myRegisterClientView;
	SearchVideoView mySearchVideoView;
	RegisterVideoView myRegisterVideoView;
	ClientController clientController;
	VideoController videoController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		App miPrincipal=new App();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		myMenuView=new MenuView();
		
		myRegisterClientView=new RegisterClientView();
		mySearchClientView= new SearchClientView();
		myClientServ=new ClientServ();
		clientController= new ClientController();
		
		myRegisterVideoView=new RegisterVideoView();
		mySearchVideoView= new SearchVideoView();
		myVideoServ=new VideoServ();
		videoController= new VideoController();
		
		/*Se establecen las relaciones entre clases*/
		myMenuView.setClientCoordinator(clientController);
		myMenuView.setVideoCoordinator(videoController);
		
		myRegisterClientView.setCoordinator(clientController);
		mySearchClientView.setCoordinador(clientController);
		myClientServ.setClientController(clientController);
		
		myRegisterVideoView.setCoordinator(videoController);
		mySearchVideoView.setCoordinador(videoController);
		myVideoServ.setVideoController(videoController);
		
		/*Se establecen relaciones con la clase coordinador*/
		clientController.setMyMenuView(myMenuView);
		clientController.setMyRegisterClientView(myRegisterClientView);
		clientController.setMySearchClientView(mySearchClientView);
		clientController.setClientServ(myClientServ);
		
		videoController.setMyMenuView(myMenuView);
		videoController.setMyRegisterVideoView(myRegisterVideoView);
		videoController.setMySearchVideoView(mySearchVideoView);
		videoController.setVideoServ(myVideoServ);
				
		myMenuView.setVisible(true);
	}

}
