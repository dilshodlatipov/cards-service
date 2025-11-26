package com.example.cardsservice.common;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Converter(autoApply = false)
public class FieldEncryptionConverter implements AttributeConverter<String, String> {

    private final RsaCryptoUtil crypto;

    @Override
    public String convertToDatabaseColumn(String value) {
        return value == null ? null : crypto.encrypt(value);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData == null ? null : crypto.decrypt(dbData);
    }
}
