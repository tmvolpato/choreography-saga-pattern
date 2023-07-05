package br.com.tmvolpato.ms.sale.adapters.in.resource;

import br.com.tmvolpato.ms.sale.adapters.in.resource.mapper.SaleRequestMapper;
import br.com.tmvolpato.ms.sale.adapters.in.resource.request.SaleRequest;
import br.com.tmvolpato.ms.sale.application.port.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleResource {

    private final CreateSaleInputPort createSaleInputPort;
    private final SaleRequestMapper saleRequestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSale(@Valid @RequestBody final SaleRequest saleRequest) {
        log.info("SaleResource - Creating sale [{}]", saleRequest);

        final var sale = this.saleRequestMapper.saleRequestToSale(saleRequest);
        this.createSaleInputPort.execute(sale);
    }
}
