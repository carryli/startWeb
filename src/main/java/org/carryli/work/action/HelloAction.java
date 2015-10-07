package org.carryli.work.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8921052277879339766L;
	private String username = "rootun";
	private String admin = "rootadmin";
	private String adminName = "rootadminname";
	private String password = "rootpwd";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(admin+" "+adminName+" " + password+" "+username);
		return SUCCESS;
	}
	
}
