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
    private Map<Integer, Offer> offerMap = new HashMap<>();
    private int nextOfferId = 0;

    public void addOffer(Offer offer) {
        if (offerMap.containsValue(offer)) {
            throw new TicketAlreadyExistsException("Ticket Exists");
        } else {
            offer.setOfferId(nextOfferId);
            offerMap.put(nextOfferId++, offer);
        }
    }
    public List<Offer> getAllOffer() {
        return new ArrayList<>(offerMap.values());
    }

    public Offer getOfferById(int offerId) {
        Offer offer = offerMap.get(offerId);
        if (ObjectUtils.isEmpty(offer)) {
            System.out.println("Offer not found");
        }
        return offer;
    }

    public void deleteOffer(int offerId) {
        if (!offerMap.containsKey(offerId)) {
            throw new TicketNotFoundException("Offer doesn't exist");
        } else {
            offerMap.remove(offerId);
        }
    }

    public int getPriceByOfferId(int offerId) {
        Offer offer = offerMap.get(offerId);
        if (ObjectUtils.isEmpty(offer)) {
            throw new TicketNotFoundException("Offer doesn't exist");
        } else {
            return offer.getCost();
        }
    }
	public void addAllOffer(List<Offer> offerList) {
		// TODO Auto-generated method stub
		for(Offer offer: offerList) {
			addOffer(offer);
		}
	}
}
