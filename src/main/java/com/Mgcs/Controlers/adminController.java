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

import com.Mgcs.Entity.Admin2;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Service.IAdmin2Service;
@RestController
@RequestMapping("/api/Admin")
 
public class adminController {
	
	@Autowired
	private IAdmin2Service admincontrol;
	
	
	@PostMapping("/add/Admin")
	public ResponseEntity<Admin2> adduser(@RequestBody Admin2 admin) throws Exception
	{
 
		if(admin==null)
		{
			throw new Exception("object is null");
		}
		return new ResponseEntity<Admin2>(admincontrol.addadmin(admin),HttpStatus.CREATED );
		
	}
	@PutMapping("/update-Admin")
	public ResponseEntity<Admin2>updateAdmin(@RequestBody Admin2 admin) throws Exception
	{
		if(admin==null)
		{
			throw new Exception("object is nuull");
		}
		return new  ResponseEntity<Admin2> (admincontrol.updateadmin(admin),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{adminId}")
	public ResponseEntity<Admin2> deleteadmin(@PathVariable(name = "adminId") long adminId) throws Exception {
		if (adminId == 0) {
			throw new Exception("doctorId Id Shouldn't be Zero..");
		} else {
			return new ResponseEntity<Admin2>(admincontrol.deleteadmin(adminId),HttpStatus.OK  );
		}}

	@GetMapping("/view_all")
	public ResponseEntity<List<Admin2>>viewAlladmin() throws ResourceNotFoundException
	{
		return new ResponseEntity<List<Admin2>>(admincontrol.viewAlladmin(),HttpStatus.OK);
	}



}
	
