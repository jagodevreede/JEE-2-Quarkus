package com.acme.inventory.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @Column(name = "brand_id")
    private Integer id;
    @Column(name = "brand_name", nullable = false)
    private String name;
}
