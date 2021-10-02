package com.acme.inventory.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@EntityListeners(AuditTrailListener.class)
@Entity
@Table(name = "categories")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = "category_id")
    private Integer id;
    @Column(name = "category_name", nullable = false)
    private String name;
    @Column(name = "category_uuid")
    private UUID uuid;

    @PrePersist
    public void prePersist() {
        uuid = UUID.randomUUID();
    }
}
