package edu.uoc.epcsd.productcatalog.domain.service;

import edu.uoc.epcsd.productcatalog.domain.Offer;

import java.util.List;

public interface OfferService {
    Long addOffer(Offer offer);

    List<Offer> findOffersByUser(String email);
}
