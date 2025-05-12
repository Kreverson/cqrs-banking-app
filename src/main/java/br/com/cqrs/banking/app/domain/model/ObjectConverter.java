package br.com.cqrs.banking.app.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import lombok.SneakyThrows;

@Convert
public class ObjectConverter implements AttributeConverter<Object, String> {

    @Override
    public String convertToDatabaseColumn(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(dbData, Object.class);
    }
}
