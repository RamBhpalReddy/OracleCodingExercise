package com.java.ram.oracleCodingExercise.service;
/*Interface for list of operations*/
import java.util.Map;
import java.util.Set;

public interface CustomerDataService {
	
	Map<String, Integer> getNoOfCustIdForEachContractId();
	
	Map<String, Integer> getNoOfCustIdForEachGeoZone();
	
	Map<String, Set<String>> getCustIdsForEachGeoZone();
	
	Map<String, Float> aveBuildDurationForEachGeoZone();

}
