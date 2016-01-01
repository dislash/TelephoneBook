package com.dislash.tel.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.dislash.tel.beans.TelDir;
import com.dislash.tel.dao.DeleteDao;
import com.dislash.tel.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Result(name = "list", value = "list.action", type = ServletRedirectResult.class) 
public class DeleteAction extends ActionSupport implements ModelDriven<Object>{

	private static final long serialVersionUID = 1L;
	TelDir telDir = new TelDir();

    public String execute() {
		try {
			DeleteDao deleteDao = new DeleteDao();
			deleteDao.deleteTel(telDir);
			return "list";
		} catch (ServiceException ex) {
			addActionError(getText("db.failed", new String[]{ex.getMessage()}));
			return "list";
		}
    }

	@Override
	public Object getModel() {
		return telDir;
	}
}
