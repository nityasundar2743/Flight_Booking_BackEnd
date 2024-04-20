package com.example.flight.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.Entity.Offer;
import com.example.flight.Service.OfferService;

@RestController
@RequestMapping("/offer")
@CrossOrigin(origins = "*")
public class OfferController {

	@Autowired
	OfferService offerService;
	
	@PostMapping("/addoffer")
	public void addOffer(@RequestBody Offer offer) {
		offerService.addOffer(offer);
	}
	
	@PostMapping("/addalloffers")
	public void addOffers(@RequestBody List<Offer> offerList) {
		offerService.addAllOffer(offerList);
	}
	
	@GetMapping("/alloffer")
	public List<Offer> getAllOffers() {
		return offerService.getAllOffer();
	}
	
	@GetMapping("/{offerId}")
	public Offer getOfferById(@PathVariable String offerId) {
		return offerService.getOfferById(offerId);
	}
	
	@DeleteMapping("/{offerId}")
	public void deleteOfferById(@PathVariable String offerId) {
		offerService.deleteOffer(offerId);
	}
}
