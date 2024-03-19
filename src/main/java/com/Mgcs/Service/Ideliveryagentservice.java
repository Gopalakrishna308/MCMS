package com.Mgcs.Service;

import com.Mgcs.Entity.Deliver_agent;
import com.Mgcs.Exception.Deliver_AgentAlreadyExistsException;
import com.Mgcs.Exception.ResourceNotFoundException;

public interface Ideliveryagentservice {

	public Deliver_agent addDeliveryBoy(Deliver_agent delivery) throws Deliver_AgentAlreadyExistsException;
	
	
	public Deliver_agent updateAgent(Deliver_agent delivery) throws ResourceNotFoundException;
	
	public Deliver_agent deleteAgent(long agrnt) throws ResourceNotFoundException;
	  
	
	
	
}
