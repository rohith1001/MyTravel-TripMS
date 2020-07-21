package com.test.quarkus.rest;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.smallrye.reactive.messaging.annotations.Merge;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.smallrye.reactive.messaging.annotations.Merge;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import com.test.quarkus.model.Trip;
import java.util.UUID;

@ApplicationScoped
public class TripMessageProcessor {

	
    @Incoming("paymentstatus")
    @Merge
    public  void process(String paymentString) {
		System.out.println("Payment status string is :" + paymentString);
		JSONObject jo = (JSONObject)new JSONParser().parse(paymentString);
	    	
	    	UUID tripId = UUID.fromString(((String)jo.get("tripId"));
	        Trip trip = Trip.findById(tripId);
	    	String paymentstatus = (String)jo.get("status");
	    	trip.update("tripStatus",  paymentstatus);
	}
}
