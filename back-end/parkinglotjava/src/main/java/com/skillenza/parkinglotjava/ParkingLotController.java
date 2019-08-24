package com.skillenza.parkinglotjava;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ParkingLotController {

    // your code goes here
	
	 private ParkingLotRepository parkingLotRepository;
	 
	 public ParkingLotController(ParkingLotRepository parkingLotRepository) {
		 this.parkingLotRepository = parkingLotRepository;
	 }

	    @GetMapping("/parkings")
	    public List<ParkingLot> getParkings() {
	        return (List<ParkingLot>) parkingLotRepository.findAll();
	    }

	    @PostMapping("/parkings")
	    void addParking(@RequestBody ParkingLot parkingLot) throws Exception {
	    	//todo: validation
	    	if(parkingLot != null) {
	    		int vehicleNumber = parkingLot.getVehicleNumber();
	    		if(isVehicleFound(vehicleNumber)) {
	    			throw new Exception("Vehicle already exist");
	    		} else {
	    			parkingLot.setCreatedAt(new Date());
	    			parkingLot.setUpdatedAt(new Date());
	    			parkingLotRepository.saveAndFlush(parkingLot);
	    		}
	    	}
	    }
	    
	    private boolean isVehicleFound(int vehicleNumber) {
	    	//TODO: need to fetch the records based on the vehicleNumber using query
	    	boolean exist = false;
	    	List<ParkingLot> parkingLots = parkingLotRepository.findAll();
	    	if(parkingLots != null && parkingLots.size() > 0) {
	    		int size = parkingLots.size();
	    		for(int i =0;i<size;i++) {
	    			if(parkingLots.get(i).getVehicleNumber() == vehicleNumber) {
	    				exist = true;
	    				break;
	    			}
	    		}
	    	}
	    	return exist;
	    }
	    
	    @PutMapping("/parkings/{id}")
	    void updateParking(@PathParam(value="id") long id, @RequestBody ParkingLot parkingLot) throws Exception {
	    	if(parkingLot != null) {
	    		Optional<ParkingLot> lot = parkingLotRepository.findById(id);
	    		if(lot.isPresent()) {
	    			parkingLot.setCreatedAt(lot.get().getCreatedAt());
	    			parkingLot.setUpdatedAt(new Date());
	    			parkingLotRepository.saveAndFlush(parkingLot);
	    		}
	    	}
	    }
}

