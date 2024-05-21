package com.TaxInfo.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "taxinfo")
public class TaxInfo {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "txn_id", nullable = false)
	    private String txnId;

	    @Column(name = "customer_name", nullable = false)
	    private String customerName;

	    @Column(name = "service", nullable = false)
	    private String service;

	    @Min(value = 0, message = "Amount must not be less than 0")
	    @Column(name = "amount", nullable = false)
         private float amount;

	    @Column(name = "gst", nullable = false)
	    private float gst;

	    @Column(name = "commission", nullable = false)
	    private float commission;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTxnId() {
			return txnId;
		}

		public void setTxnId(String txnId) {
			this.txnId = txnId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getService() {
			return service;
		}

		public void setService(String service) {
			this.service = service;
		}

		public float getAmount() {
			return amount;
		}

		public void setAmount(float amount) {
			this.amount = amount;
		}

		public float getGst() {
			return gst;
		}

		public void setGst(float gst) {
			this.gst = gst;
		}

		public float getCommission() {
			return commission;
		}

		public void setCommission(float commission) {
			this.commission = commission;
		}

		public TaxInfo(Long id, String txnId, String customerName, String service, float amount, float gst,
				float commission) {
			super();
			this.id = id;
			this.txnId = txnId;
			this.customerName = customerName;
			this.service = service;
			this.amount = amount;
			this.gst = gst;
			this.commission = commission;
		}

		public TaxInfo() {
			super();
		}

	    
}