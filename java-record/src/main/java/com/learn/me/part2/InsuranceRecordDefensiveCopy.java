package com.learn.me.part2;

import java.util.ArrayList;
import java.util.List;

public record InsuranceRecordDefensiveCopy(List<String> policyHolders) {

	public InsuranceRecordDefensiveCopy {
		policyHolders = List.copyOf(policyHolders);
	}

	public List<String> policyHolders() {
		return List.copyOf(policyHolders);
	}

	public static void main(String args[]) {
		List<String> holders = new ArrayList<>();
		holders.add("John Doe");

		InsuranceRecordDefensiveCopy record = new InsuranceRecordDefensiveCopy(holders);
		// Modify the list after creating the record
		holders.add("Jane Smith");
		// The internal list inside the record remains unchanged
		System.out.println(record.policyHolders()); // Output: [John Doe]
	}
}