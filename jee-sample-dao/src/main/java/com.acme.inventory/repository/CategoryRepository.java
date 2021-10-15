package com.acme.inventory.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class CategoryRepository {

    @Inject
    EntityManager entityManager;

    @Transactional
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
