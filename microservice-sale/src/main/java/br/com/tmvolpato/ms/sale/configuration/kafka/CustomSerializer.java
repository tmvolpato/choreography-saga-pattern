package br.com.tmvolpato.ms.sale.configuration.kafka;

import br.com.tmvolpato.ms.sale.adapters.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializer implements Serializer<SaleMessage> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, SaleMessage saleMessage) {
        try {
            if (saleMessage == null) {
                return null;
            }
            return objectMapper.writeValueAsBytes(saleMessage);
        } catch (final Exception e) {
            throw new SerializationException("Error when serializing SaleMessage to byte[]");
        }
    }

}

