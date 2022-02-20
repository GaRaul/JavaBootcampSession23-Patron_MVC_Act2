package com.MVCAct2.T22Act2.model.service;

import javax.swing.JOptionPane;

import com.MVCAct2.T22Act2.controller.VideoController;
import com.MVCAct2.T22Act2.model.dao.VideoDao;
import com.MVCAct2.T22Act2.model.dto.Video;

public class VideoServ {
	private VideoController videoController;
	public static boolean consultVideo = false;
	public static boolean modifyVideo = false;

	// Metodo de vinculación con el controller principal
	public void setVideoController(VideoController videoController) {
		this.setController(videoController);		
	}

	// Metodo que valida los datos de Registro antes de pasar estos al DAO
	public void validateRegister(Video myVideo) {
		VideoDao myVideoDao;
		if (myVideo.getTitle().length() > 1) {
			myVideoDao = new VideoDao();
			myVideoDao.registerVideo(myVideo);
		} else {
			JOptionPane.showMessageDialog(null, "The video title must have more than 1 character", "Warning",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Metodo que valida los datos de consulta antes de pasar estos al DAO
	public Video validateQuery(String idVideo) {
		VideoDao myVideoDao;

		try {
			int id = Integer.parseInt(idVideo);//mirar
			if (id >= 0 || id <= 200) {
				myVideoDao = new VideoDao();
				consultVideo = true;
				return myVideoDao.searchVideo(id);
			} else {
				JOptionPane.showMessageDialog(null, "The video's id must be between 1-200",
						"Warning", JOptionPane.WARNING_MESSAGE);
				consultVideo = false;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Must introduce numerical data", "Error", JOptionPane.ERROR_MESSAGE);
			consultVideo = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There is an Error", "Error", JOptionPane.ERROR_MESSAGE);
			consultVideo = false;
		}

		return null;
	}

	// Metodo que valida los datos de Modificación antes de pasar estos al DAO
	public void validateModification(Video myVideo) {
		VideoDao myVideoDao;
		if (myVideo.getTitle().length() > 3) {
			myVideoDao = new VideoDao();
			myVideoDao.modifyVideo(myVideo);
			modifyVideo = true;
		} else {
			JOptionPane.showMessageDialog(null, "The video's title must have more than 3 digits", "Warning",
					JOptionPane.WARNING_MESSAGE);
			modifyVideo = false;
		}
	}

	// Metodo que valida los datos de Eliminación antes de pasar estos al DAO
	public void validateDelete(String idVideo) {
		VideoDao myVideoDao = new VideoDao();
		myVideoDao.deleteVideo(idVideo);
	}

	public VideoController getVideoController() {
		return videoController;
	}

	public void setController(VideoController videoController) {
		this.videoController = videoController;
	}

}
