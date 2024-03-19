package com.Mgcs.Controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mgcs.Entity.Doctor;
import com.Mgcs.Service.IdoctorService;

@RestController
@RequestMapping("/api/docter")
public    class doctorControler {
	@Autowired
	private IdoctorService docse;
	
	@PostMapping("/add/doctor")
	public ResponseEntity<Doctor> addDoctoer(@RequestBody Doctor doctor) throws Exception
	{
 
		if(doctor==null)
		{
			throw new Exception("object is null");
		}
		return new ResponseEntity<Doctor>(docse.addDoctoer(doctor),HttpStatus.CREATED);
		
	}
	@PutMapping("/update-doctor")
	public ResponseEntity<Doctor>updateDoctor(@RequestBody Doctor doctor) throws Exception
	{
		if(doctor==null)
		{
			throw new Exception("object is nuull");
		}
		return new  ResponseEntity<Doctor>(docse.updateDoctor(doctor),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{doctorId}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable(name = "doctorId") long doctorId) throws Exception {
		if (doctorId == 0) {
			throw new Exception("doctorId Id Shouldn't be Zero..");
		} else {
			return new ResponseEntity<Doctor>(docse.deleteDoctor(doctorId), HttpStatus.OK);
		}}
	

}
	
	
	


