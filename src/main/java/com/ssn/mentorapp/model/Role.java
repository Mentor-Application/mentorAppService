package com.ssn.mentorapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
public class Role {

	@Id
	private String roleId;
	
	
	private ERole roleName;


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public ERole getRoleName() {
		return roleName;
	}


	public void setRoleName(ERole roleName) {
		this.roleName = roleName;
	}
	
	
	
}
