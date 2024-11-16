package com.learn.me.part3;

public record InsuranceRecord(String type, float premium) {

	private static final String DEFAULT_INSURANCE_TYPE = "Health Insurance";
	private static final float DEFAULT_PREMIUM = 1000;

	public static InsuranceRecord getDefaultInsurance() {
		return new InsuranceRecord(DEFAULT_INSURANCE_TYPE, DEFAULT_PREMIUM);
	}

	public float convertToUSD(float conversionRate) {
		return premium * conversionRate;
	}

	public static class PolicyValidator {
		public void validate(InsuranceRecord record) {
			if (record.premium() < 100) {
				System.out.println("Invalid premium: must be at least 100.");
			} else {
				System.out.println("Insurance record is valid.");
			}
		}
	}

	public static void main(String args[]) {
		InsuranceRecord record = new InsuranceRecord("Life Insurance", 5000);
		System.out.println("Premium in USD: " + record.convertToUSD((float) 1.2));

		InsuranceRecord defaultRecord = InsuranceRecord.getDefaultInsurance();
		System.out.println("Premium in USD: " + defaultRecord.convertToUSD((float) 1.2));
		
		InsuranceRecord.PolicyValidator validator = new InsuranceRecord.PolicyValidator();
		validator.validate(defaultRecord);
	}
}