package com.litap.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Criteria;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Offer> getOfferByQuery(String fromDate, String toDate) {
		
		Session session = factory.openSession();
		
		Query<Offer> query = session.createQuery("from Offer where validfrom >= :validfrom and validto <= :validto");
		query.setParameter("validfrom", fromDate);
		query.setParameter("validto", toDate);
		
		
		return query.list();
	}
	
	public List<Offer> getOfferByCriteria(String fromDate, String toDate) {
		
		Session session = factory.openSession();
		
		Criteria criteria =  session.createCriteria(Offer.class);
		ProjectionList l = Projections.projectionList();
		l.add(Projections.property("offerDesc"));
		l.add(Projections.property("validfrom"));
		l.add(Projections.property("validto"));
		
		criteria.add(Restrictions.and(Restrictions.ge("validfrom", fromDate), Restrictions.le("validto", toDate)));
		
		criteria.setProjection(l);
		
		
		return criteria.list();
	}
	
}
