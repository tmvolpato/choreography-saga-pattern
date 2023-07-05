package br.com.tmvolpato.ms.application.core.domain;

import br.com.tmvolpato.ms.application.core.domain.enums.SaleStatusEnum;

import java.math.BigDecimal;
import java.util.Objects;

public class Sale {

    private Long id;
    private Long userId;
    private Long productId;
    private BigDecimal value;
    private SaleStatusEnum status;
    private int quantity;

    public Sale() {}

    public Sale(Long id, Long userId, Long productId, BigDecimal value, SaleStatusEnum status, int quantity) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.value = value;
        this.status = status;
        this.quantity = quantity;
    }

    public void statusInitial() {
        this.status = SaleStatusEnum.PENDING;
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
        return Objects.equals(id, sale.id) && Objects.equals(userId, sale.userId) && Objects.equals(productId, sale.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, productId);
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", value=" + value +
                ", status=" + status +
                ", quantity=" + quantity +
                '}';
    }
}
