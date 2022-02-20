package com.MVCAct2.T22Act2.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.MVCAct2.T22Act2.model.connection.MysqlConnection;
import com.MVCAct2.T22Act2.model.dto.Video;

public class VideoDao {

	public void registerVideo(Video myVideo) {
		MysqlConnection conex = new MysqlConnection();

		try {
			Statement st = conex.getConnection().createStatement();
			String sql = "INSERT INTO Video (title, director, clientId) VALUES ('" + myVideo.getTitle() + "','"
					+ myVideo.getDirector() + "', '" + myVideo.getClientId() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Video added", "Information", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed insertion");
		}
	}

	public Video searchVideo(int id) {
		MysqlConnection conex = new MysqlConnection();
		Video video = new Video();
		boolean existe = false;
		try {
			String sql = "SELECT * FROM Video where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				video.setId(res.getInt(id));
				video.setTitle(res.getString("Title"));
				video.setDirector(res.getString("Director"));
				video.setClientId(res.getInt("ClientId"));
			}
			res.close();
			conex.desconectar();
			System.out.println(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			System.out.println(e);
		}

		if (existe) {
			return video;
		} else
			return null;
	}

	public void modifyVideo(Video myVideo) {

		MysqlConnection conex = new MysqlConnection();
		try {
			String consulta = "UPDATE Video SET Title = ?, Director = ? , ClientId = ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setString(1, myVideo.getTitle());
			estatuto.setString(2, myVideo.getDirector());
			estatuto.setInt(3, myVideo.getClientId());
			estatuto.setInt(4, myVideo.getId());
			estatuto.executeUpdate();

			JOptionPane.showMessageDialog(null, " Modification Done", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);

		} catch (SQLException e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Modification Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteVideo(String idVideo) {
		MysqlConnection conex = new MysqlConnection();
		try {
			String sql = "DELETE FROM Video WHERE id='" + idVideo + "'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, " Delete Done", "Information", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Delete Error");
		}
	}
}
