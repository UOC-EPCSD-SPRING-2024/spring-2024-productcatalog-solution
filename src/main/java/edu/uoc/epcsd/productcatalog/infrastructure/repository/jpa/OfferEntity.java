package edu.uoc.epcsd.productcatalog.infrastructure.repository.jpa;

import edu.uoc.epcsd.productcatalog.domain.Offer;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity(name = "Offer")
@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class OfferEntity implements DomainTranslatable<Offer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne(optional = false)
    private CategoryEntity category;

    @ManyToOne(optional = false)
    private ProductEntity product;

    @Column(name = "serialNumber", nullable = false, unique = true)
    private String serialNumber;

    public static OfferEntity fromDomain(Offer offer) {
        if (offer == null) {
            return null;
        }

        return OfferEntity.builder()
                .id(offer.getId())
                .email(offer.getEmail())
                .serialNumber(offer.getSerialNumber())
                .build();
    }

    @Override
    public Offer toDomain() {
        return Offer.builder()
                .id(this.getId())
                .email(this.getEmail())
                .categoryId(this.getCategory().getId())
                .productId(this.getProduct().getId())
                .serialNumber(this.getSerialNumber())
                .build();
    }
}
