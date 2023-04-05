package com.example.onlinestoreproject.service;

import com.example.onlinestoreproject.dto.CategoryDTO;
import com.example.onlinestoreproject.dto.ProductDTO;
import com.example.onlinestoreproject.dto.ProductDTONoCreatingDate;
import com.example.onlinestoreproject.model.Category;
import com.example.onlinestoreproject.model.Product;
import com.example.onlinestoreproject.repository.CategoryRepository;
import com.example.onlinestoreproject.repository.ProductRepository;
import com.example.onlinestoreproject.repository.spec.Specification;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> findProduct(Boolean sort) {
        List<Product> products = productRepository.findFetchAllBy(
                sort ?
                        Sort.by(Sort.Direction.DESC, "createdDate") :
                        Sort.unsorted());
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO product) {
        product.setId(null);
        product.setModificationDate(Instant.now());
        product.setCreationDate(Instant.now());
        productRepository.save(product.to());
        return product;
    }

    public ProductDTONoCreatingDate update(ProductDTONoCreatingDate product) {
        product.setModificationDate(Instant.now());
        productRepository.save(product.to());
        return product;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<ProductDTO> search(String name, String description, String categoryName) {


        List<Product> products = productRepository.findAll(Specification.byName(name)
                .and(Specification.byDescription(description))
                .and(Specification.byCategory(categoryName)));
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }
}
