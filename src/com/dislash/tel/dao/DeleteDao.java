package com.dislash.tel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dislash.db.DBConnection;
import com.dislash.tel.beans.TelDir;
import com.dislash.tel.exception.ServiceException;

public class DeleteDao {

	public void deleteTel(TelDir tel) {

		Connection con;
		PreparedStatement stmt;
		DBConnection dbConn = new DBConnection();

		try {
			con = dbConn.getDBConnection();

			String sql = "DELETE FROM tel_dir WHERE id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(tel.getId()));

			stmt.executeUpdate();

			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException(ex);
		}
	}

}
