package com.litap.exceptions;

public class OfferException extends RuntimeException {
	
	public  OfferException(int offerId) {
		super("Offer with the id:"+offerId+ " not found");
	}

}
