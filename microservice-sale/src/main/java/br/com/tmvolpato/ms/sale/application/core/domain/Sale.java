package br.com.tmvolpato.ms.sale.application.core.domain;

import br.com.tmvolpato.ms.sale.application.core.domain.enums.SaleStatusEnum;

import java.math.BigDecimal;
import java.util.Objects;

public class Sale {
    private Long id;
    private Long userId;
    private Long productId;
    private BigDecimal value;
    private SaleStatusEnum status;
    private int quantity;

    public void statusInitial() {
        this.status = SaleStatusEnum.PENDING;
    }

    public void statusFinalized() {
        this.status = SaleStatusEnum.FINALIZED;
    }

    public void statusCanceled() {
        this.status = SaleStatusEnum.CANCELED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public SaleStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SaleStatusEnum status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale sale)) return false;
        return Objects.equals(id, sale.id) && Objects.equals(productId, sale.productId) && Objects.equals(userId, sale.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, userId);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", value=" + value +
                ", status=" + status +
                ", quantity=" + quantity +
                '}';
    }
}
