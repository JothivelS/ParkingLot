package com.skillenza.parkinglotjava;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "parkinglots", uniqueConstraints=
@UniqueConstraint(columnNames = {"lot", "vehicleNumber"}))
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class ParkingLot {
	
    //your code goes here
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private Date createdAt;
	private Date updatedAt;
	private int lot;
	private long parkingAmount;
	private int parkingDuration;
	private int vehicleNumber;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getLot() {
		return lot;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public long getParkingAmount() {
		return parkingAmount;
	}
	public void setParkingAmount(long parkingAmount) {
		this.parkingAmount = parkingAmount;
	}
	public int getParkingDuration() {
		return parkingDuration;
	}
	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	
	
    
}
