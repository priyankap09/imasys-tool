package com.litap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.litap.dao.OfferDAO;
import com.litap.entity.Offer;
import com.litap.exceptions.OfferException;


@Service
public class OfferServiceImpl implements OfferService{
	
	@Autowired
	OfferDAO offerDAO;

	@Override
	public  Optional<Offer>  getOffer(int offerId) {
	
		Optional<Offer> offer = offerDAO.getOffer(offerId);
		
		if(offer.isPresent())
			return offer;
		else
			throw new OfferException(offerId);
	}

	@Override
	public List<Offer> getAllOffers() {
		
		List<Offer> offerList = offerDAO.getOfferList();
		return offerList;
	}

	@Override
	public String updateOffer(Offer offer) {

		Optional<Offer> offOptional = offerDAO.getOffer(offer.getOfferid());
		
		if(offOptional.isPresent()){
			offerDAO.updateOffer(offer);
			return "OFFER UPDATED";
		}
		else {
			throw new OfferException(offer.getOfferid());
			
		}
	}

	@Override
	public String deleteOffer(int offerId) {
		String delStatus = offerDAO.deleteOffer(offerId);
		return delStatus;
	}

	@Override
	public Offer saveOffer(Offer offer) {
		Offer offerFrmDB = offerDAO.saveOffer(offer);
		return offerFrmDB;
	}


	public List<Offer> offerListByQuery(String fromDate, String toDate) {
		
		return offerDAO.getOfferByQuery(fromDate, toDate);
		 
	}
	
public List<Offer> offerListByCriteria(String fromDate, String toDate) {
		
		return offerDAO.getOfferByCriteria(fromDate, toDate);
		 
	}
}
