package edu.uoc.epcsd.productcatalog.application.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public final class CreateProductRequest {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Double dailyPrice;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    @NotNull
    private Long categoryId;

}
