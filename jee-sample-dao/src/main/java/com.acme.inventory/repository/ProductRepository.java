package com.acme.inventory.repository;

import lombok.var;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProductRepository {

    @PersistenceContext(unitName = "myDB")
    private EntityManager entityManager;

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
