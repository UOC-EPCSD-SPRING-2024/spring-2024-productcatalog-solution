package edu.uoc.epcsd.productcatalog.application.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public final class CreateCategoryRequest {

    private final Long parentCategoryId;

    @NotNull
    private final String name;

    private final String description;

}