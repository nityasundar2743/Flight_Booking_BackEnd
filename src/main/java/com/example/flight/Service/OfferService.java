package com.example.flight.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.flight.Entity.Offer;
import com.example.flight.Exceptions.TicketAlreadyExistsException;
import com.example.flight.Exceptions.TicketNotFoundException;

@Service
public class OfferService {
	List<Offer> offerList= new ArrayList<Offer>();
	Map<String, Offer> offerMap = new HashMap<String, Offer>();
	
	public void addOffer(Offer offer) {
		if(offerMap.containsKey(offer.getOfferId())) {
			throw new TicketAlreadyExistsException("Ticket Exists");
		}
		else {
			offerList.add(offer);
			offerMap.put(offer.getOfferId(), offer);
		}
	}
	
	public void addAllOffer(List<Offer> offerlist) {
		for(Offer offer:offerlist) {
			if(offerMap.containsKey(offer.getOfferId())) {
				throw new TicketAlreadyExistsException("Ticket Exists");
			}
			else {
				offerList.add(offer);
				offerMap.put(offer.getOfferId(), offer);
			}
		}
	}
	
	public List<Offer> getAllOffer() {
		return offerList;
	}
	
	/** This method retrieves a ticket based on its unique id from ticketmap. **/ 
	public Offer getOfferById(String offerId) {
		if(ObjectUtils.isEmpty(offerMap.get(offerId))) {
			System.out.println("Ticket not found");
		}
		return offerMap.get(offerId);
	}
	
	public void deleteOffer(String offerId) {
		if(ObjectUtils.isEmpty(offerMap.get(offerId))) {
			throw new TicketNotFoundException("Ticket Doesn't Exists");
		}
		else {
			Offer offer = getOfferById(offerId);
			offerList.remove(offer);
			offerMap.remove(offerId);
		}
	}
	public int getPriceByOfferId(String offerId) {
		if(ObjectUtils.isEmpty(offerMap.get(offerId))) {
			throw new TicketNotFoundException("Ticket Doesn't Exists");
		}
		else {
			Offer offer = getOfferById(offerId);
			return offer.getCost();
		}
	}
}
