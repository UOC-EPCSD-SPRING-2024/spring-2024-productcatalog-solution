package edu.uoc.epcsd.productcatalog.infrastructure.repository.jpa;

import edu.uoc.epcsd.productcatalog.domain.Offer;
import edu.uoc.epcsd.productcatalog.domain.repository.OfferRepository;
import edu.uoc.epcsd.productcatalog.domain.service.CategoryNotFoundException;
import edu.uoc.epcsd.productcatalog.domain.service.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OfferRepositoryImpl implements OfferRepository {

    private final SpringDataOfferRepository jpaRepository;

    private final SpringDataCategoryRepository jpaCategoryRepository;

    private final SpringDataProductRepository jpaProductRepository;

    @Override
    public Long addOffer(Offer offer) {
        Long categoryId = offer.getCategoryId();
        CategoryEntity category = jpaCategoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Long productId = offer.getProductId();
        ProductEntity product = jpaProductRepository.findById(productId).orElseThrow( () -> new ProductNotFoundException(productId));

        OfferEntity offerEntity = OfferEntity.fromDomain(offer);
        offerEntity.setCategory(category);
        offerEntity.setProduct(product);

        return jpaRepository.save(offerEntity).getId();
    }
}
