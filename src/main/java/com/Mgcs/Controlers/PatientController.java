package com.Mgcs.Controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mgcs.Entity.Patient;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Service.Ipatientservice;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	private Ipatientservice  patientControoler;
	
	@PostMapping("/add/ Patient")
	public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) throws Exception
	{
 
		if(patient==null)
		{
			throw new Exception("object is null");
		}
		return new ResponseEntity<Patient>(  patientControoler.addPatient(patient),HttpStatus.CREATED );
		
	}
	@PutMapping("/update-patient")
	public ResponseEntity<Patient>updateUser(@RequestBody Patient patient) throws Exception
	{
		if(patient==null)
		{
			throw new Exception("object is nuull");
		}
		return new  ResponseEntity<Patient> ( patientControoler.updatePatient(patient),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<Patient> deletemeMedicine(@PathVariable(name = "patientId") long patientId) throws Exception {
		if (patientId == 0) {
			throw new Exception("doctorId Id Shouldn't be Zero..");
		} else {
			return new ResponseEntity<Patient>( patientControoler.deletePatient(patientId),HttpStatus.OK  );
		}}

	@GetMapping("/view_all")
	public ResponseEntity<List<Patient>>viewAllMedicine() throws ResourceNotFoundException
	{
		return new ResponseEntity<List<Patient>>( patientControoler.viewAllPatient(),HttpStatus.OK);
	}

	
	

	
}
