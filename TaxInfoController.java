package com.TaxInfo.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxInfoController {

    @Autowired
    private TaxInfoService taxInfoService;
    
    @PostMapping("/add")
    public ResponseEntity<String> addTaxInfo(@RequestBody TaxInfo taxInfo) {
        try {
            taxInfoService.addTaxInfo(taxInfo);
            return ResponseEntity.ok("Transaction added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

    @GetMapping("/amount/{initialRange}/{finalRange}")
    public ResponseEntity<List<TaxInfo>> getTaxInfosByAmountRange(@PathVariable float initialRange,
                                                                  @PathVariable float finalRange) {
        List<TaxInfo> taxInfos = taxInfoService.getTaxInfosByAmountRange(initialRange, finalRange);
        if (taxInfos.isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.ok(taxInfos);
    }

    @GetMapping("/sort/amount")
    public ResponseEntity<List<TaxInfo>> getAllTaxInfosSortedByAmount() {
        List<TaxInfo> taxInfos = taxInfoService.getAllTaxInfosSortedByAmount();
        return ResponseEntity.ok(taxInfos);
    }
}