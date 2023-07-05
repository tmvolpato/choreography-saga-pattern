package br.com.tmvolpato.ms.sale.adapters.in.consumer;

import br.com.tmvolpato.ms.sale.adapters.out.message.SaleMessage;
import br.com.tmvolpato.ms.sale.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.sale.application.port.in.FinalizeSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "sale-finalize")
    public void execute(final SaleMessage saleMessage) {
        if (SaleEventEnum.VALIDATED_PAYMENT.equals(saleMessage.getSaleEventEnum())) {
            log.info("ReceiveSaleToFinalizeConsumer - Closed the sale");

            this.finalizeSaleInputPort.execute(saleMessage.getSale());
        }
    }

}
