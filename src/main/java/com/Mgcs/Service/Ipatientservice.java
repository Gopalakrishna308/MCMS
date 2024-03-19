package com.Mgcs.Service;

import java.util.List;

import com.Mgcs.Entity.Patient;
import com.Mgcs.Exception.PatientAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;

public interface Ipatientservice {

	public Patient addPatient(Patient patient) throws PatientAlreadyExistsException;
	
	public  Patient updatePatient(Patient patient) throws ResourceNotFoundException;
	
	public Patient deletePatient(long patientId) throws ResourceNotFoundException;
	
	public List< Patient> viewAllPatient() throws ResourceNotFoundException;
	
}
