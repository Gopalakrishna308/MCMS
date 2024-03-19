package com.Mgcs.Service;

import java.util.List;

import com.Mgcs.Entity.Admin2;
import com.Mgcs.Exception.Admin2AlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;

public interface IAdmin2Service {
	
	public Admin2 addadmin(Admin2 admin) throws Admin2AlreadyExistsException  ;
	
	public Admin2 updateadmin(Admin2 admin) throws ResourceNotFoundException ;
	
	public Admin2 deleteadmin(long adminId) throws ResourceNotFoundException  ;
	
	public List<Admin2> viewAlladmin() throws ResourceNotFoundException;
	 
	

}
