package edu.uoc.epcsd.productcatalog.domain.service;

import edu.uoc.epcsd.productcatalog.application.rest.response.GetUserResponse;
import edu.uoc.epcsd.productcatalog.domain.Offer;
import edu.uoc.epcsd.productcatalog.domain.repository.OfferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class OfferServiceImpl implements OfferService {

    @Value("${userService.getUserByEmail.url}")
    private String getUserByEmail;

    private final OfferRepository offerRepository;

    public Long addOffer(Offer offer) {
        try {
            ResponseEntity<GetUserResponse> response = new RestTemplate().
                    getForEntity(getUserByEmail, GetUserResponse.class, offer.getEmail());
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new RuntimeException("Could not fetch user with email " + offer.getEmail());
            }
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new UserNotFoundException(offer.getEmail());
            }
            throw new RuntimeException("Could not fetch user with email " + offer.getEmail());
        }

        return offerRepository.addOffer(offer);
    }
}
