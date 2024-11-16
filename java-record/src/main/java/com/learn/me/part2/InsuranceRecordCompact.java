package com.learn.me.part2;

public record InsuranceRecordCompact(String policyNumber, String holderName, double premiumAmount) {
	
	public InsuranceRecordCompact {		
		 if (policyNumber == null) {
		      throw new IllegalArgumentException("The insurance policyNumber cannot be null");
		    }
		    if (premiumAmount < 100 || premiumAmount > 10000) {
		      throw new IllegalArgumentException("The premiumAmount must be between 100 and 10000");
		    }
	  }
}