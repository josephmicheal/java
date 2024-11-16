package com.learn.me.part2;

public class Application {
	public static void main(String args[]) {
		
		Insurance insurance = new Insurance("POL123", "John Doe", 1500.00);
		InsuranceRecordCanonical insuranceRecord = new InsuranceRecordCanonical("POL123", "John Doe", 1500.00);
		
		System.out.println("insurance:"+insurance);
		System.out.println("insuranceRecord:"+insuranceRecord);


	}
}
