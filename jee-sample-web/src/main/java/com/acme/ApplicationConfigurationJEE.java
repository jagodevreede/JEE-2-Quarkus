package com.acme;

import com.acme.inventory.ApplicationConfiguration;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationConfigurationJEE implements ApplicationConfiguration {

    @Resource(lookup="resource/jee-sample/priceMultiplier")
    private double priceMultiplier;

    @Override
    public double getPriceMultiplier() {
        return priceMultiplier;
    }
}
