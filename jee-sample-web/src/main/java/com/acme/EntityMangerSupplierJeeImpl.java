package com.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityMangerSupplierJeeImpl {
    @PersistenceContext(unitName = "myDB")
    @Produces
    private EntityManager entityManager;
}
