package com.acme.repository;

import com.acme.inventory.ApplicationConfiguration;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationConfigurationQuarkus implements ApplicationConfiguration {

    @ConfigProperty(name = "price.multiplier")
    double priceMultiplier;

    @Override
    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
