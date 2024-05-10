package edu.uoc.epcsd.productcatalog.domain.repository;

import edu.uoc.epcsd.productcatalog.domain.Offer;

import java.util.List;

public interface OfferRepository {
    Long addOffer(Offer offer);

    List<Offer> findOffersByUser(String email);
}
