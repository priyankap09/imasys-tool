package com.litap.service;

import java.util.List;
import java.util.Optional;

import com.litap.entity.Offer;

public interface OfferService {
	
	Optional<Offer> getOffer(int offerId);
	
	List<Offer> getAllOffers();
	
	Offer saveOffer(Offer offer);
	
	String updateOffer(Offer offer);
	
	String deleteOffer(int offerId);

}
