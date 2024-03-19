package com.Mgcs.Service;

import java.util.List;

import com.Mgcs.Entity.Medicine;
import com.Mgcs.Exception.MadicineAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;

public interface Imadicineservice {
	
	public Medicine addMedicine(Medicine med) throws MadicineAlreadyExistsException;
	
	public Medicine updateMedicine(Medicine med) throws ResourceNotFoundException;
	
	public Medicine deletemeMedicine (long medicineId) throws ResourceNotFoundException;
	
	public List<Medicine> viewAllMedicine() throws ResourceNotFoundException;
	

}
