package br.com.tmvolpato.ms.sale.adapters.in.resource.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SaleRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    private BigDecimal value;

    private int quantity;
}
