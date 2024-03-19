package com.Mgcs.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mgcs.Entity.Deliver_agent;
import com.Mgcs.Exception.Deliver_AgentAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;
import com.Mgcs.Repository.IdeliveryRepository;
import com.Mgcs.Service.Ideliveryagentservice;
@Service
public class deliveryagentimpl implements Ideliveryagentservice {

	@Autowired
	private IdeliveryRepository deliveryrepos;
	
	public Deliver_agent addDeliveryBoy(Deliver_agent delivery) throws Deliver_AgentAlreadyExistsException {
 
		Optional<?>a=deliveryrepos.findById(delivery.getDeliveryId());
		if (a.isPresent())
		{
			throw new Deliver_AgentAlreadyExistsException("is ");
		}
		return 	deliveryrepos.save(delivery);
	
	}

	 
	public Deliver_agent updateAgent(Deliver_agent delivery) throws ResourceNotFoundException {
		Deliver_agent d=deliveryrepos.findById(delivery.getDeliveryId()).orElseThrow(()->
		new ResourceNotFoundException("not it"));
		d.setDeliveryName(delivery.getDeliveryName());
		d.setLoc(delivery.getLoc());
		
		return deliveryrepos.save(d);
	}

 
	public Deliver_agent deleteAgent(long agrnt) throws ResourceNotFoundException {
		Deliver_agent d=deliveryrepos.findById(agrnt).orElseThrow(()->new ResourceNotFoundException("is empity"));
		
		deliveryrepos.delete(d);
		return d;
	}

}
