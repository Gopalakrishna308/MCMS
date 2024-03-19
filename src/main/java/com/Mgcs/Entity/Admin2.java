package com.Mgcs.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin2 {

	@Id
	private long adminId;
	
	private String adminName;
	
	private  String password;
	} 