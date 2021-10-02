package com.acme.inventory.repository;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Slf4j
public class AuditTrailListener {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(Category category) {
        log.info("About to change category with id: " + category.getId());
    }
}
