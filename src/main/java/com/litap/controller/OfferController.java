package com.litap.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.litap.entity.Offer;
import com.litap.service.OfferServiceImpl;

@RestController
@CrossOrigin("http://localhost:4200")
public class OfferController {
	
	
	
	@Autowired
	OfferServiceImpl offerService;
	
	@GetMapping("getOffer/{offerId}")
	public Optional<Offer> getOffer(@PathVariable int offerId)
	{
		return offerService.getOffer(offerId);
		

	}
//	@GetMapping("getOffer/{offerId}")
//	public ResponseEntity<Offer> getOffer(@PathVariable int offerId)
//	{
//		
//		 Optional<Offer> offer = offerService.getOffer(offerId);
//		
//		
//		return offer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
//        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//
//	}
//	
	@RequestMapping("showofferpage")
	public ModelAndView offer() {
		
		List<Offer> allOffers =  offerService.getAllOffers();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("offer");
		modelAndView.addObject("allOffers", allOffers);
		
		return modelAndView;
	}
	
	@RequestMapping("offer")
	public List<Offer> getAllOffer(){
		
//		return	offerService.getAllOffers();
		return  StreamSupport.stream(offerService.getAllOffers().spliterator(), false)
				.collect(Collectors.toList());
		
	}
	
	@PostMapping("/save/offer")
	public Offer saveOffer(@RequestBody Offer offer) {
		
		Offer ofr = offerService.saveOffer(offer);
		return ofr;	
		
	}
	
	@DeleteMapping("/delete/offer/{offerid}")
	public String deleteOffer(@PathVariable int offerid) {
		
		
		String msg = offerService.deleteOffer(offerid);
		return msg;	
		
	}
	
	
	@PutMapping("/update/offer")
	public String updateOffer(@RequestBody Offer offer) {
		String msg = offerService.updateOffer(offer);
		return msg;
	}
	
	
	
}
