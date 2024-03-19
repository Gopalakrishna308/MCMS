package com.Mgcs.Service;

import com.Mgcs.Entity.Doctor;
import com.Mgcs.Exception.DoctorAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;

public interface IdoctorService {
	
	public Doctor addDoctoer(Doctor doctor) throws DoctorAlreadyExistsException;
	
	public Doctor updateDoctor(Doctor doctor) throws ResourceNotFoundException;
	
	public Doctor  deleteDoctor(long doctorId) throws ResourceNotFoundException;
	
	public Doctor viewAllDoctor();
 
	public Doctor viewDoctorId(long doctorId);
	
	
}
