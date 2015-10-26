package org.carryli.work.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

@Entity
@Table (name = "role")
public class Role extends GrantedAuthorityImpl implements Serializable {

	public Role(String role) {
		super(role);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6450453722920863987L;

	@Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	@Column (name = "roleid")
	private Integer roleId;
	
	@Column (name = "role")
	private String role;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
