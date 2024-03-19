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

import com.Mgcs.Entity.Deliver_agent;
import com.Mgcs.Service.Ideliveryagentservice;

@RestController
@RequestMapping("/api/deleveryagent")
public class deliveryagentcontroler {
	
	@Autowired
	private Ideliveryagentservice deliverycontrol;
	

	@PostMapping("/add/deleveryagent")
	public ResponseEntity<Deliver_agent> addDeliveryBoy(@RequestBody Deliver_agent delivery) throws Exception
	{
 
		if(delivery==null)
		{
			throw new Exception("object is null");
		}
		return new ResponseEntity<Deliver_agent>(deliverycontrol.addDeliveryBoy(delivery),HttpStatus.CREATED);
		
	}
	@PutMapping("/update-deleveryagent")
	public ResponseEntity<Deliver_agent>updateAgent(@RequestBody Deliver_agent delivery) throws Exception
	{
		if(delivery==null)
		{
			throw new Exception("object is nuull");
		}
		return new  ResponseEntity<Deliver_agent>( deliverycontrol.updateAgent(delivery),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{agrnt}")
	public ResponseEntity<Deliver_agent> deleteAgent(@PathVariable(name = "agrnt") long agrnt) throws Exception {
		if (agrnt == 0) {
			throw new Exception("doctorId Id Shouldn't be Zero..");
		} else {
			return new ResponseEntity<Deliver_agent>( deliverycontrol.deleteAgent(agrnt),HttpStatus.OK);
		}}


}
