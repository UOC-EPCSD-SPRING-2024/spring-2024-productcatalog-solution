package edu.uoc.epcsd.productcatalog.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @NotNull
    private Long id;

    @NotBlank
    private String email;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long productId;

    @NotBlank
    private String serialNumber;
}
