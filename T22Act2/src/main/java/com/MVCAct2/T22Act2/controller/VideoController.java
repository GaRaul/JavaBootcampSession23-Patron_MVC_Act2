package com.MVCAct2.T22Act2.controller;

import com.MVCAct2.T22Act2.model.dto.Video;
import com.MVCAct2.T22Act2.model.service.VideoServ;
import com.MVCAct2.T22Act2.view.MenuView;
import com.MVCAct2.T22Act2.view.video.RegisterVideoView;
import com.MVCAct2.T22Act2.view.video.SearchVideoView;

public class VideoController {
	
	private VideoServ videoServ;
	private MenuView myMenuView;
	private RegisterVideoView myRegisterVideoView;
	private SearchVideoView mySearchVideoView;
	
	//Metodos getter Setters de vistas
	public VideoServ getVideoServ() {
		return videoServ;
	}
	public void setVideoServ(VideoServ videoServ) {
		this.videoServ = videoServ;
	}
	public MenuView getMyMenuView() {
		return myMenuView;
	}
	public void setMyMenuView(MenuView myMenuView) {
		this.myMenuView = myMenuView;
	}
	public RegisterVideoView getMyRegisterVideoView() {
		return myRegisterVideoView;
	}
	public void setMyRegisterVideoView(RegisterVideoView myRegisterVideoView) {
		this.myRegisterVideoView = myRegisterVideoView;
	}
	public SearchVideoView getMySearchVideoView() {
		return mySearchVideoView;
	}
	public void setMySearchVideoView(SearchVideoView mySearchVideoView) {
		this.mySearchVideoView = mySearchVideoView;
	}
	
	
	//Hace visible las vistas de Registro y Consulta
    public void showRegisterVideoView() {
        myRegisterVideoView.setVisible(true);
    }
    public void showSearchVideoView() {
        mySearchVideoView.setVisible(true);
    }
	
	//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
    public void addVideo(Video myVideo) {
        videoServ.validateRegister(myVideo);
    }    
    
    public Video searchVideo(String idVideo) {
		return videoServ.validateQuery(idVideo);
	}
	
	public void modifyVideo(Video myVideo) {
		videoServ.validateModification(myVideo);
	}
	
	public void deleteVideo(String string) {
		videoServ.validateDelete(string);
	}
	
	
}
