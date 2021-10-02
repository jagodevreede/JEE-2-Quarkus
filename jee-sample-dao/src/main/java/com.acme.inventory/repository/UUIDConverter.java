package com.acme.inventory.repository;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.UUID;

@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {
    @Override
    public String convertToDatabaseColumn(UUID attribute) {
        if (attribute == null){
            return null;
        }
        return attribute.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String dbData) {
        if (dbData == null){
            return null;
        }
        return UUID.fromString(dbData);
    }
}
