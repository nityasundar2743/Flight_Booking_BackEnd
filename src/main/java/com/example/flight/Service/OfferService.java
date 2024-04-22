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
    private Map<String, Offer> offerMap = new HashMap<>();

    public void addOffer(Offer offer) {
        if (offerMap.containsKey(offer.getOfferId())) {
            throw new TicketAlreadyExistsException("Ticket Exists");
        } else {
            offerMap.put(offer.getOfferId(), offer);
        }
    }

    public List<Offer> getAllOffer() {
        return new ArrayList<>(offerMap.values());
    }

    public Offer getOfferById(String offerId) {
        Offer offer = offerMap.get(offerId);
        if (ObjectUtils.isEmpty(offer)) {
            System.out.println("Ticket not found");
        }
        return offer;
    }

    public void deleteOffer(String offerId) {
        if (!offerMap.containsKey(offerId)) {
            throw new TicketNotFoundException("Ticket Doesn't Exist");
        } else {
            offerMap.remove(offerId);
        }
    }

    public int getPriceByOfferId(String offerId) {
        Offer offer = offerMap.get(offerId);
        if (ObjectUtils.isEmpty(offer)) {
            throw new TicketNotFoundException("Ticket Doesn't Exist");
        } else {
            return offer.getCost();
        }
    }
}
