package com.Mgcs.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mgcs.Entity.Doctor;
import com.Mgcs.Exception.DoctorAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Repository.IdoctorRepository;
import com.Mgcs.Service.IdoctorService;
@Service
public class doctorimpl implements IdoctorService {

	@Autowired
	private  IdoctorRepository doc;
	@Override
	public Doctor addDoctoer(Doctor doctor) throws DoctorAlreadyExistsException {
		 Optional<Doctor>  a=doc.findById(doctor.getDocId());
		 if(a.isPresent())
		 {
			 throw new DoctorAlreadyExistsException("doctor is present"); 
		 }
		return doc.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) throws ResourceNotFoundException {
	 Doctor d=doc.findById(doctor.getDocId()).orElseThrow(()-> new ResourceNotFoundException("no data"));
	 d.setDocName(doctor.getDocName());

	 d.setDocprof(doctor.getDocprof());
		return doc.save(d);
	}

	@Override
	public Doctor deleteDoctor(long doctorId) throws ResourceNotFoundException {
		Doctor d=doc.findById(doctorId).orElseThrow(()-> new  ResourceNotFoundException("no date "));
		
		doc.delete(d);
		return d;
	}

	@Override
	public Doctor viewAllDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor viewDoctorId(long doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

}
