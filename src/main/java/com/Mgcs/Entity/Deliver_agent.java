package com.Mgcs.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deliver_agent {
	
	
	 
	@Id
	private long deliveryId;
	 
	private String loc;
	private String deliveryName;
	
	

}
