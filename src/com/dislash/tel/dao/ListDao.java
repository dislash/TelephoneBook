package com.dislash.tel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dislash.db.DBConnection;
import com.dislash.tel.beans.TelDir;
import com.dislash.tel.exception.ServiceException;

public class ListDao {
	public ArrayList<TelDir> listTel() {

		Connection con;
		PreparedStatement stmt;
		ResultSet rs;
		DBConnection dbConn = new DBConnection();
		ArrayList<TelDir> list = new ArrayList<TelDir>();

		try {
			con = dbConn.getDBConnection();

			String sql = "SELECT id, name, tel_no, mail_address, memo FROM tel_dir";
			stmt = con.prepareStatement(sql);
		    rs = stmt.executeQuery();
		    while(rs.next()) {
		    	TelDir tel = new TelDir();
		    	tel.setId(rs.getString(1));
		    	tel.setName(rs.getString(2));
		    	tel.setTelNo(rs.getString(3));
		    	tel.setMailAddress(rs.getString(4));
		    	tel.setMemo(rs.getString(5));
		    	list.add(tel);
		    }
			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException(ex);
		}
		return list;
	}

	public TelDir getTel(TelDir tel) {

		Connection con;
		PreparedStatement stmt;
		ResultSet rs;
		DBConnection dbConn = new DBConnection();

		try {
			con = dbConn.getDBConnection();

			String sql = "SELECT id, name, tel_no, mail_address, memo FROM tel_dir WHERE id= ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(tel.getId()));

		    rs = stmt.executeQuery();
		    while(rs.next()) {
		    	tel.setId(rs.getString(1));
		    	tel.setName(rs.getString(2));
		    	tel.setTelNo(rs.getString(3));
		    	tel.setMailAddress(rs.getString(4));
		    	tel.setMemo(rs.getString(5));
		    }
			dbConn.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace(); 
			throw new ServiceException(ex);
		}
		return tel;
	}
}
