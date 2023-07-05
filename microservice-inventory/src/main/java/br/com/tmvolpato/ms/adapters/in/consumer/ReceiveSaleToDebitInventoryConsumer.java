package br.com.tmvolpato.ms.adapters.in.consumer;

import br.com.tmvolpato.ms.adapters.out.message.SaleMessage;
import br.com.tmvolpato.ms.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.application.ports.in.DebitInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToDebitInventoryConsumer {

    private final DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(final SaleMessage saleMessage) {
        if (SaleEventEnum.CREATED_SALE.equals(saleMessage.getSaleEventEnum())) {
            log.info("ReceiveSaleToDebitInventoryConsumer - Start inventory separation");

            this.debitInventoryInputPort.execute(saleMessage.getSale());
        }
    }
}
