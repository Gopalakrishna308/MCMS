package com.Mgcs.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mgcs.Entity.Patient;
import com.Mgcs.Exception.PatientAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Repository.IpatientRepository;
import com.Mgcs.Service.Ipatientservice;
@Service
public class patientimpl implements Ipatientservice {

	 @Autowired
	 private IpatientRepository patirepos;
	 
	@Override
	public Patient addPatient(Patient patient) throws PatientAlreadyExistsException {
		 Optional<Patient> a1=patirepos.findById(patient.getPatientId());
		 if(a1==null)
		 {
			 throw new PatientAlreadyExistsException("is present");
		 }
		   return patirepos.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) throws ResourceNotFoundException {
		 Patient p1=patirepos.findById(patient.getPatientId()).orElseThrow(()-> new ResourceNotFoundException("is impity"));
		 p1.setAge(patient.getAge());
		 p1.setPatientName(patient.getPatientName());
		return patirepos.save(p1);
	}

	@Override
	public Patient deletePatient(long patientId) throws ResourceNotFoundException {
		Patient p1=patirepos.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("is impity"));
		
		patirepos.delete(p1);
		return p1  ;
	}

	@Override
	public List< Patient> viewAllPatient() throws ResourceNotFoundException {
		List< Patient>p1=patirepos.findAll();
		if(p1==null)
		{
			throw new ResourceNotFoundException("List is empity");
			
		}
		else
		{
			return p1;
		}
		 
		  
	}

}
