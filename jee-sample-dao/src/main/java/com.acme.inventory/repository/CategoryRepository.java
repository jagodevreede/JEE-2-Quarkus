package com.acme.inventory.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Stateless
public class CategoryRepository {
    @PersistenceContext(unitName = "myDB")
    private EntityManager entityManager;

    public Category newCategory(String name) {
        Category category = Category.builder()
                .id(new Random().nextInt())
                .name(name)
                .build();

        entityManager.persist(category);
        return category;
    }

    public List<Category> findAll() {
        return entityManager.createQuery("Select t from " + Category.class.getSimpleName() + " t", Category.class).getResultList();
    }
}
