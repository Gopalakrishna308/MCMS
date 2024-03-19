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
public class Medicine {
	@Id
	private long medicineId;
	
	private String medicineName;
	
	private long numberOfMedicine;
	

}
