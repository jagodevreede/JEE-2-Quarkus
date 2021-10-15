package com.acme.inventory.repository;

import lombok.var;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager entityManager;

    public List<Product> byName(String name) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Product.class);
        var root = criteriaQuery.from(Product.class);
        if (name != null && !name.isEmpty()) {
            criteriaQuery.where(criteriaBuilder.like(root.get("name"), name));
        }
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public Product findById(Integer id) {
        return entityManager.find(Product.class, id);
    }
}
