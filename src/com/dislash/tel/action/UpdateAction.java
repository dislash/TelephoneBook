package com.dislash.tel.action;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import com.dislash.tel.beans.TelDir;
import com.dislash.tel.dao.ListDao;
import com.dislash.tel.dao.UpdateDao;
import com.dislash.tel.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Result(name = "list", value = "list.action", type = ServletRedirectResult.class) 
public class UpdateAction extends ActionSupport implements ModelDriven<Object>{

	private static final long serialVersionUID = 1L;
	TelDir telDir = new TelDir();

    public String execute() throws Exception {
		try {
			ListDao listDao = new ListDao();
			listDao.getTel(telDir);
			return "success";
		} catch (ServiceException ex) {
			addActionError(getText("db.failed", new String[]{ex.getMessage()}));
			return "error";
		}
    }

	public String update() {
		Boolean validData = true;
		try{			
			if (telDir.getName() == null || ("".equals(telDir.getName()))) {
				addActionError(getText("error.name.required"));
				validData = false;
			}

			if (telDir.getTelNo() == null || ("".equals(telDir.getTelNo()))) {
				addActionError(getText("error.telno.required"));
				validData = false;
			}

			if(!validData){
				return "error";
			}
			
			try {
				UpdateDao updateDao = new UpdateDao();
				updateDao.updateTel(telDir);
				return "list";
			} catch (ServiceException ex) {
				addActionError(getText("db.failed", new String[]{ex.getMessage()}));
				return "error";
			}
		}catch(Exception e){
			addActionError(getText("global.exception.message"));
			return "error";
		}
	}

	@Override
	public Object getModel() {
		return telDir;
	}
}
