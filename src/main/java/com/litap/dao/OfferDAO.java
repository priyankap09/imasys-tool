package com.litap.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.litap.entity.Offer;


//database logic
@Repository
public class OfferDAO {

	@Autowired
	SessionFactory factory;
	
	public List<Offer> getOfferList() {
		
		Session session = factory.openSession();
	
		Criteria criteria = session.createCriteria(Offer.class);
		List<Offer> list = criteria.list();
		return list;		
	}
	
	
	public Offer saveOffer(Offer offer) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		session.save(offer);
		tx.commit();
		
		return offer;
		
	}
	
	public String deleteOffer(int offerid) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction(); 
		
		Offer offer = session.get(Offer.class, offerid);
		session.delete(offer);
		tx.commit();
		
		return "Offer Deleted";
		
	}
	
	
	public Optional<Offer> getOffer(int offerId) {
		Session session = factory.openSession();
		
		Offer offer = session.get(Offer.class, offerId);
		
		return Optional.ofNullable(offer);
		
	}
	
	
	public String updateOffer(Offer offer) {
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		session.update(offer);
		tx.commit();
		
		return "Offer Deleted";
		
	}
	
}
