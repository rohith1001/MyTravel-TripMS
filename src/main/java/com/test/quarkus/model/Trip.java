package com.test.quarkus.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Trip extends PanacheEntityBase { 

    @Id
    @GeneratedValue
    UUID id; 

    String userId;
    Date tripBookingDate;
    String tripType; //one-way, round-trip or multi-city

    public UUID getTripId() {
        return this.id;
    }

    public String getUserId() {
		return this.userId;
	}

    public void setuserId(String userId) {
		this.userId = userId;
	}

    public Date getTripBookingDate() {
        return this.tripBookingDate;
    }

    public void setTripBookingDate(Date tripBookingDate) {
        this.tripBookingDate = tripBookingDate;
    }

    public String getTripType() {
		return this.tripType;
	}

    public void setTripType(String tripType) {
		this.tripType = tripType;
    }

}