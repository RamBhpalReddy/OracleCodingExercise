package com.java.ram.oracleCodingExercise.model;
import lombok.AllArgsConstructor;
/*Dto class to represent the data*/
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {

	private String customerId;
	private String contractId;
	private String geozone;
	private String teamcode;
	private String projectcode;
	private int buildduration;

	@Override
	public String toString() {
		return "CustomerData [customerId=" + customerId + ", contractId=" + contractId + ", geozone=" + geozone
				+ ", teamcode=" + teamcode + ", projectcode=" + projectcode + ", buildduration=" + buildduration + "]";
	}

}
