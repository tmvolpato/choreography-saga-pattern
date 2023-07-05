package br.com.tmvolpato.ms.application.core.usecase;

import br.com.tmvolpato.ms.application.core.domain.Payment;
import br.com.tmvolpato.ms.application.core.domain.Sale;
import br.com.tmvolpato.ms.application.core.domain.enums.SaleEventEnum;
import br.com.tmvolpato.ms.application.ports.in.FindUserByIdInputPort;
import br.com.tmvolpato.ms.application.ports.in.SalePaymentInputPort;
import br.com.tmvolpato.ms.application.ports.out.SavePaymentOutputPort;
import br.com.tmvolpato.ms.application.ports.out.SendFailedPaymentOutputPort;
import br.com.tmvolpato.ms.application.ports.out.SendValidatedPaymentOutputPort;
import br.com.tmvolpato.ms.application.ports.out.UpdateUserOutputPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SalePaymentUseCase implements SalePaymentInputPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalePaymentUseCase.class);

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;
    private final SendFailedPaymentOutputPort sendFailedPaymentOutputPort;

    public SalePaymentUseCase(final FindUserByIdInputPort findUserByIdInputPort, final UpdateUserOutputPort updateUserOutputPort,
                              final SavePaymentOutputPort savePaymentOutputPort, final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort,
                              final SendFailedPaymentOutputPort sendFailedPaymentOutputPort) {

        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
        this.sendFailedPaymentOutputPort = sendFailedPaymentOutputPort;
    }

    @Override
    public void execute(final Sale sale) {
        try {

            var user = this.findUserByIdInputPort.execute(sale.getUserId());

            if (user.getBalance().compareTo(sale.getValue()) < 0) {
                throw new RuntimeException("Insufficient balance");
            }

            user.debitBalance(sale.getValue());
            this.updateUserOutputPort.execute(user);
            this.savePaymentOutputPort.execute(createPayment(sale));
            this.sendValidatedPaymentOutputPort.execute(sale, SaleEventEnum.VALIDATED_PAYMENT);

        } catch (final Exception ex) {
            LOGGER.error("SalePaymentUseCase -  Payment error [{}]", ex.getMessage());
            this.sendFailedPaymentOutputPort.execute(sale, SaleEventEnum.FAILED_PAYMENT);
        }
    }

    private Payment createPayment(final Sale sale) {
        return new Payment(null, sale.getUserId(), sale.getId(), sale.getValue());
    }
}
