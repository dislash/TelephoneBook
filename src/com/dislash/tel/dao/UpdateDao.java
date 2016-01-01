package com.dislash.tel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dislash.db.DBConnection;
import com.dislash.tel.beans.TelDir;
import com.dislash.tel.exception.ServiceException;

public class UpdateDao {

	public void updateTel(TelDir tel) {

		Connection con;
		PreparedStatement stmt;
		DBConnection dbConn = new DBConnection();

		try {
			con = dbConn.getDBConnection();

			String sql = "UPDATE tel_dir SET name=?, tel_no=?, mail_address=?, memo=? WHERE id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tel.getName());
			stmt.setString(2, tel.getTelNo());
			stmt.setString(3, tel.getMailAddress());
			stmt.setString(4, tel.getMemo());
			stmt.setInt(5, Integer.parseInt(tel.getId()));

			stmt.executeUpdate();

			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException(ex);
		}
	}

}
