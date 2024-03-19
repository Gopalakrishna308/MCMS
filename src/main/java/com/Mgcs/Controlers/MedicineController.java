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

import com.Mgcs.Entity.Medicine;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Service.Imadicineservice;

@RestController
@RequestMapping("/api/MedicineController")
public class MedicineController {
	
	@Autowired
	private Imadicineservice medicinecontrol;
	
	@PostMapping("/add/ medicine")
	public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine med) throws Exception
	{
 
		if(med==null)
		{
			throw new Exception("object is null");
		}
		return new ResponseEntity<Medicine>( medicinecontrol.addMedicine(med),HttpStatus.CREATED );
		
	}
	@PutMapping("/update-medicine")
	public ResponseEntity<Medicine>updateUser(@RequestBody Medicine med) throws Exception
	{
		if(med==null)
		{
			throw new Exception("object is nuull");
		}
		return new  ResponseEntity<Medicine> (medicinecontrol.updateMedicine(med),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{medicineId}")
	public ResponseEntity<Medicine> deletemeMedicine(@PathVariable(name = "medicineId") long medicineId) throws Exception {
		if (medicineId == 0) {
			throw new Exception("doctorId Id Shouldn't be Zero..");
		} else {
			return new ResponseEntity<Medicine>(medicinecontrol. deletemeMedicine(medicineId),HttpStatus.OK  );
		}}

	@GetMapping("/view_all")
	public ResponseEntity<List<Medicine>>viewAllMedicine() throws ResourceNotFoundException
	{
		return new ResponseEntity<List<Medicine>>(medicinecontrol.viewAllMedicine(),HttpStatus.OK);
	}

	

}
