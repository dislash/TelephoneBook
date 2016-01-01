package com.dislash.tel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dislash.db.DBConnection;
import com.dislash.tel.beans.TelDir;
import com.dislash.tel.exception.ServiceException;

public class InsertDao {

	public void insertTel(TelDir tel) {

		Connection con;
		PreparedStatement stmt;
		DBConnection dbConn = new DBConnection();

		try {
			con = dbConn.getDBConnection();

			String sql = "INSERT INTO tel_dir(id, name, tel_no, mail_address, memo) VALUES(?,?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(tel.getId()));
			stmt.setString(2, tel.getName());
			stmt.setString(3, tel.getTelNo());
			stmt.setString(4, tel.getMailAddress());
			stmt.setString(5, tel.getMemo());

			stmt.executeUpdate();

			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException(ex);
		}
	}

}
