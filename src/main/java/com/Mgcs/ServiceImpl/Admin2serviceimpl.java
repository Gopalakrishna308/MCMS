package com.Mgcs.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mgcs.Entity.Admin2;
import com.Mgcs.Exception.Admin2AlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Repository.IAdmin2Repository;
import com.Mgcs.Service.IAdmin2Service;
@Service
public class Admin2serviceimpl implements IAdmin2Service {

	@Autowired
	private IAdmin2Repository adminrepos;
	@Override
	public Admin2 addadmin(Admin2 admin) throws Admin2AlreadyExistsException {
		Optional<Admin2> a=adminrepos.findById(admin.getAdminId());
		if(a==null)
		{
			throw new Admin2AlreadyExistsException("already is present");
		}
		return  adminrepos.save(admin);
		 
	}

	@Override
	public Admin2 updateadmin(Admin2 admin) throws ResourceNotFoundException {
		 Admin2 a=adminrepos.findById(admin.getAdminId()).orElseThrow(()-> new 
				 ResourceNotFoundException("object is null"));
		 a.setAdminName(admin.getAdminName());
		 a.setPassword(admin.getPassword());
		return adminrepos.save(a);
	}

	@Override
	public Admin2 deleteadmin(long adminId) throws ResourceNotFoundException {
		 Admin2 a=adminrepos.findById(adminId).orElseThrow(()-> new 
				 ResourceNotFoundException("admin is not thre"));
		 
		 
		  adminrepos.delete(a);
		  return a;
	}

	@Override
	public List<Admin2>viewAlladmin() throws ResourceNotFoundException {
		List<Admin2> a2=adminrepos.findAll();
		if(a2==null)
		{
			throw new ResourceNotFoundException("List is null");
			
		}
		else
		{
			return a2;
		}
		 
	}

}
