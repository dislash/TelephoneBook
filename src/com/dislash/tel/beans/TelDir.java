package com.dislash.tel.beans;

public class TelDir {
	private String id;
	private String name;
	private String telNo;
	private String mailAddress;
	private String memo;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "TelDir [id=" + id + ", name=" + name + ", telNo=" + telNo
				+ ", mailAddress=" + mailAddress + ", memo=" + memo + "]";
	}

}
