package com.example.ShoppingmallProject.product;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
@AllArgsConstructor
public class ProductDTO {

    private long id;
    @NotBlank
    private String name;
    @NotNull
    private int price;
    @NotBlank
    private String description;
    @JsonProperty("category_id")
    private long categoryId;

}
