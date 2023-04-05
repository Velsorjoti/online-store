package com.example.onlinestoreproject.repository;

import com.example.onlinestoreproject.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    @EntityGraph(attributePaths = {"categories"})
    List<Product> findFetchAllBy(Sort sort);


}
