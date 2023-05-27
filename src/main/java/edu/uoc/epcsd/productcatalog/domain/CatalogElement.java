package edu.uoc.epcsd.productcatalog.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CatalogElement {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    private String description;

}
