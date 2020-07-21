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
import io.smallrye.reactive.messaging.annotations.Blocking;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

@ApplicationScoped
public class TripMessageProcessor {

	
    @Incoming("paymentstatus")
    @Merge
    @Blocking
    public  void process(String paymentString) {
	    	try{
		System.out.println("Payment status string is :" + paymentString);
		JSONObject jo = (JSONObject)new JSONParser().parse(paymentString);
	    	System.out.println("Trip Id is " + jo.get("tripId"));
	    	UUID tripId = UUID.fromString(((String)jo.get("tripId")));
	        Trip trip = Trip.findById(tripId);
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(trip);
		System.out.println("Trip Details are :" + trip);
	    	String paymentstatus = (String)jo.get("status");
	    	trip.update("tripStatus",  paymentstatus);
		}catch(org.json.simple.parser.ParseException e){
		e.printStackTrace();
		}
	}
}
