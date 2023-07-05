package br.com.tmvolpato.ms.adapters.out;

import br.com.tmvolpato.ms.adapters.out.message.SaleMessage;
import br.com.tmvolpato.ms.application.core.domain.Sale;
import br.com.tmvolpato.ms.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.application.ports.out.SendFailedPaymentOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SendFailedPaymentAdapter implements SendFailedPaymentOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void execute(final Sale sale, final SaleEventEnum saleEventEnum) {
        log.info("SendFailedPaymentAdapter - Send failed payment");

        var key = UUID.randomUUID().toString();
        var saleMessage = new SaleMessage(sale, saleEventEnum);
        this.kafkaTemplate.send("tp-saga-sale", key, saleMessage);
    }
}
