package br.com.cqrs.eventhandler.config;

import com.google.gson.*;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

@Component
public class LocalDateTimeDeserializer
        implements JsonDeserializer<LocalDateTime> {

    private final static List<DateTimeFormatter> formatters = List.of(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
    );

    @SneakyThrows
    @Override
    public LocalDateTime deserialize(
            final JsonElement json,
            final Type typeOfT,
            final JsonDeserializationContext context
    ) throws JsonParseException {
        try {
            if (json.isJsonPrimitive()) {
                JsonPrimitive primitive = json.getAsJsonPrimitive();

                if (primitive.isNumber()) {
                    long micros = primitive.getAsLong();
                    return LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(micros / 1000),
                            TimeZone.getDefault()
                                    .toZoneId()
                    );
                }

                if (primitive.isString()) {
                    String value = primitive.getAsString();
                    for (DateTimeFormatter formatter : formatters) {
                        try {
                            return LocalDateTime.parse(value, formatter);
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new JsonParseException("Erro ao desserializar data: " + json, e);
        }

        throw new JsonParseException("Formato de data inválido: " + json);
    }
}