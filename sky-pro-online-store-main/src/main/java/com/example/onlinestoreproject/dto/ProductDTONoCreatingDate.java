package com.example.onlinestoreproject.dto;

import com.example.onlinestoreproject.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTONoCreatingDate {

    private Long id;
    private String name;
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant modificationDate;
    private List<CategoryDTO> categories;

    public static ProductDTONoCreatingDate of(Product product) {
        ProductDTONoCreatingDate dto = new ProductDTONoCreatingDate();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setModificationDate(product.getModificationDate());
        dto.setCategories(product.getCategories().stream().map(CategoryDTO::of).collect(Collectors.toList()));
        return dto;
    }



    public Product to() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setModificationDate(this.getModificationDate());
        product.setCategories(this.getCategories().stream().map(CategoryDTO::to).collect(toSet()));
        return product;
    }
}