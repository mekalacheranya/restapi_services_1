package com.TaxInfo.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxInfoRepo extends JpaRepository<TaxInfo, Long> {
	List<TaxInfo> findByAmountBetween(Float initialRange, Float finalRange);

    List<TaxInfo> findAllByOrderByAmountAsc();
}
