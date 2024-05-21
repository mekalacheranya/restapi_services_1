package com.TaxInfo.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxInfoService {
	  @Autowired
	    private TaxInfoRepo taxInfoRepo;

	    public TaxInfo addTaxInfo(TaxInfo taxInfo) {
	        if (taxInfo.getAmount() < 0) {
	            throw new IllegalArgumentException("Amount must not be less than 0");
	        }
	        return taxInfoRepo.save(taxInfo);
	    }

	    public List<TaxInfo> getTaxInfosByAmountRange(float initialRange, float finalRange) {
	        return taxInfoRepo.findByAmountBetween(initialRange, finalRange);
	    }

	    public List<TaxInfo> getAllTaxInfosSortedByAmount() {
	        return taxInfoRepo.findAllByOrderByAmountAsc();
	    }
}
