package com.MVCAct2.T22Act2.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.MVCAct2.T22Act2.model.connection.MysqlConnection;
import com.MVCAct2.T22Act2.model.dto.Client;

public class ClientDao {

	public void registerClient(Client myClient) {
		MysqlConnection conex = new MysqlConnection();

		try {
			Statement st = conex.getConnection().createStatement();
			String sql = "INSERT INTO Client (dni, name, surname, address, date) VALUES ('" + myClient.getDni() + "','" + myClient.getName() + "', '" + myClient.getSurname() + "', '" + myClient.getAddress() + "', '"+ myClient.getLocalDate() + "');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Client added", "Information", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed insertion");
		}
	}

	public Client searchClient(int id) {
		MysqlConnection conex = new MysqlConnection();
		Client client = new Client();
		boolean existe = false;
		try {
			String sql = "SELECT * FROM Client where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while (res.next()) {
				existe = true;
				client.setId(res.getInt(id));
				client.setName(res.getString("Name"));
				client.setSurname(res.getString("Surname"));
				client.setDni(res.getString("Dni"));
				client.setAddress(res.getString("Address"));
				client.setLocalDate(res.getString("Date"));
			}
			res.close();
			conex.desconectar();
			System.out.println(sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			System.out.println(e);
		}

		if (existe) {
			return client;
		} else
			return null;
	}

	public void modifyClient(Client myClient) {

		MysqlConnection conex = new MysqlConnection();
		try {
			String consulta = "UPDATE Client SET Dni = ?, Name = ? , Surname = ? , Address = ? , Date = ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);

			estatuto.setString(1, myClient.getDni());
			estatuto.setString(2, myClient.getName());
			estatuto.setString(3, myClient.getSurname());
			estatuto.setString(4, myClient.getAddress());
			estatuto.setString(5, myClient.getLocalDate());
			estatuto.setInt(6, myClient.getId());
			estatuto.executeUpdate();

			JOptionPane.showMessageDialog(null, " Modification Done", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(consulta);

		} catch (SQLException e) {

			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Modification Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void deleteClient(String id) {
		MysqlConnection conex = new MysqlConnection();
		try {
			String sql = "DELETE FROM Client WHERE id='" + id + "'";
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
