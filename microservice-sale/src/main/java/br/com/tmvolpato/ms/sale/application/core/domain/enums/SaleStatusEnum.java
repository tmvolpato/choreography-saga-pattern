package br.com.tmvolpato.ms.sale.application.core.domain.enums;

import java.util.Arrays;

public enum SaleStatusEnum {

    PENDING(1),
    FINALIZED(2),
    CANCELED(3);

    private final Integer statusId;

    SaleStatusEnum(final Integer statusId) {
        this.statusId = statusId;
    }

    public static SaleStatusEnum getSaleStatusByStatusId(final Integer statusId) {
        if (statusId == null) return null;

        return Arrays.stream(SaleStatusEnum.values())
                .filter(status -> status.getStatusId() == statusId).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid statusId: " + statusId));
    }

    public Integer getStatusId() {
        return statusId;
    }
}
