package com.dislash.tel.action;

import java.util.ArrayList;

import com.dislash.tel.beans.TelDir;
import com.dislash.tel.dao.ListDao;
import com.dislash.tel.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	ArrayList<TelDir> list;

    public String execute() {
		try {
			ListDao listDao = new ListDao();
			list = listDao.listTel();
			return "success";
		} catch (ServiceException ex) {
			addActionError(getText("db.failed", new String[]{ex.getMessage()}));
			return "error";
		}
    }

	public ArrayList<TelDir> getList() {
		return list;
	}

	public void setList(ArrayList<TelDir> list) {
		this.list = list;
	}
}
