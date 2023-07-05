package br.com.tmvolpato.ms.sale.adapters.in.consumer;

import br.com.tmvolpato.ms.sale.adapters.out.message.SaleMessage;
import br.com.tmvolpato.ms.sale.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.sale.application.port.in.CancelSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-cancel")
    public void execute(final SaleMessage saleMessage) {
       if (SaleEventEnum.ROLLBACK_INVENTORY.equals(saleMessage.getSaleEventEnum())) {
           log.info("CancelSaleConsumer - Canceling sale");

           this.cancelSaleInputPort.execute(saleMessage.getSale());
       }
    }

}
