package br.com.tmvolpato.ms.adapters.in.consumer;

import br.com.tmvolpato.ms.adapters.out.message.SaleMessage;
import br.com.tmvolpato.ms.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.application.ports.in.SalePaymentInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void execute(final SaleMessage saleMessage) {
        if (SaleEventEnum.UPDATED_INVENTORY.equals(saleMessage.getSaleEventEnum())) {
            log.info("ReceiveSaleToPaymentConsumer - Start payment");

            this.salePaymentInputPort.execute(saleMessage.getSale());
        }
    }

}
