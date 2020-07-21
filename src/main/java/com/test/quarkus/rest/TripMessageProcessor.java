package com.test.quarkus.rest;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.smallrye.reactive.messaging.annotations.Merge;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import io.smallrye.reactive.messaging.annotations.Merge;

@ApplicationScoped
public class TripMessageProcessor {

	
    @Incoming("paymentstatus")
    @Merge
    public  void process(String paymentString) {
		System.out.println("Payment status string is :" + paymentString);
	
	}
}
