package com.learn.me.part2;

public record InsuranceRecordCanonical(String policyNumber, String holderName, double premiumAmount) {
	
	public InsuranceRecordCanonical(String policyNumber, String holderName, double premiumAmount) {
		this.policyNumber = policyNumber;
		this.holderName = holderName;
		this.premiumAmount = premiumAmount;
	}
}