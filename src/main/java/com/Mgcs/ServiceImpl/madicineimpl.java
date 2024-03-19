package com.Mgcs.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mgcs.Entity.Medicine;
import com.Mgcs.Exception.MadicineAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Repository.ImadicineRepository;
import com.Mgcs.Service.Imadicineservice;
@Service
public class madicineimpl implements Imadicineservice {

	@Autowired
	private ImadicineRepository madicinerepos;
	
	@Override
	public Medicine addMedicine(Medicine med) throws MadicineAlreadyExistsException {
		 Optional<Medicine>m1=madicinerepos.findById(med.getMedicineId());
		 
		 if(m1==null)
		 {
			throw new MadicineAlreadyExistsException("already present");
			
		 }
	return	 madicinerepos.save(med);
	 
	}

	@Override
	public Medicine updateMedicine(Medicine med) throws ResourceNotFoundException {
		Medicine m1=madicinerepos.findById(med.getMedicineId()).orElseThrow(()-> new ResourceNotFoundException("is impity"));	 

		m1.setNumberOfMedicine(med.getNumberOfMedicine());
	
		return  madicinerepos.save(m1) ;
	}

	@Override
	public Medicine deletemeMedicine(long medicineId) throws ResourceNotFoundException {
	Medicine m1=madicinerepos.findById(medicineId).orElseThrow(()-> new ResourceNotFoundException("is empity"));
	
	madicinerepos.delete(m1);
			
		return  m1;
	}

	@Override
	public List<Medicine>  viewAllMedicine() throws ResourceNotFoundException {
		List<Medicine>  m2=madicinerepos.findAll();
		if (m2==null)
		{
			throw new ResourceNotFoundException("is empity");
		}
		return m2;
	}

}
