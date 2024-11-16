package com.learn.me.part1;

import java.util.Objects;

public class Insurance {
    private final String policyNumber;
    private final String holderName;
    private final double premiumAmount;
    public Insurance(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getPremiumAmount() {
        return premiumAmount;
    }
	@Override
	public int hashCode() {
		return Objects.hash(holderName, policyNumber, premiumAmount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insurance other = (Insurance) obj;
		return Objects.equals(holderName, other.holderName) && Objects.equals(policyNumber, other.policyNumber)
				&& Double.doubleToLongBits(premiumAmount) == Double.doubleToLongBits(other.premiumAmount);
	}
	@Override
	public String toString() {
		return "Insurance [policyNumber=" + policyNumber + ", holderName=" + holderName + ", premiumAmount="
				+ premiumAmount + "]";
	}
  
}