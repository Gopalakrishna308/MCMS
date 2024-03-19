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
public class Doctor {
	@Id
	private long docId;
	
	private String docName;
	
	private String docprof;
	

}
