package br.com.tmvolpato.ms.sale.adapters.out.repository;

import br.com.tmvolpato.ms.sale.adapters.out.repository.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
