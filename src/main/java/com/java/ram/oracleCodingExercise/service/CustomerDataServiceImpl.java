package com.java.ram.oracleCodingExercise.service;
/*Implementation for interface to do the operations*/
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.ram.oracleCodingExercise.config.LoadCustomerData;
import com.java.ram.oracleCodingExercise.model.CustomerData;

@Service
public class CustomerDataServiceImpl implements CustomerDataService{

	List<CustomerData> customerDataList = LoadCustomerData.customerDataList;
    
	@Override
	public Map<String, Integer> getNoOfCustIdForEachContractId() {

		// groupby contractID
		Map<String, List<CustomerData>> groupByContractIDs = customerDataList.stream()
				.collect(Collectors.groupingBy(CustomerData::getContractId));

		Map<String, Integer> noofCustIdforContractId = new HashMap<>();
		groupByContractIDs.forEach((k, v) -> {
			noofCustIdforContractId.put(k, v.stream().map(p -> p.getCustomerId()).collect(Collectors.toSet()).size());
		});
		return noofCustIdforContractId;
	}
    
	@Override
	public Map<String, Integer> getNoOfCustIdForEachGeoZone() {
		Map<String, Integer> noofCustIdforGeoZone = new HashMap<>();
		groupByGeoZone().forEach((k, v) -> {
			noofCustIdforGeoZone.put(k, v.stream().map(p -> p.getCustomerId()).collect(Collectors.toSet()).size());
		});
		return noofCustIdforGeoZone;
	}
    
	@Override
	public Map<String, Set<String>> getCustIdsForEachGeoZone() {

		Map<String, Set<String>> custIdsforGeoZone = new HashMap<>();
		groupByGeoZone().forEach((k, v) -> {
			custIdsforGeoZone.put(k, v.stream().map(p -> p.getCustomerId()).collect(Collectors.toSet()));
		});
		return custIdsforGeoZone;
	}
    
	@Override
	public Map<String, Float> aveBuildDurationForEachGeoZone() {

		Map<String, Float> aveBuildDurationforGeoZone = new HashMap<>();
		groupByGeoZone().forEach((k, v) -> {
			aveBuildDurationforGeoZone.put(k,
					(float) v.stream().mapToDouble(p -> p.getBuildduration()).average().getAsDouble());
		});
		return aveBuildDurationforGeoZone;
	}

	public Map<String, List<CustomerData>> groupByGeoZone() {
        
		// groupby GeoZone
		Map<String, List<CustomerData>> groupByGeoZone = customerDataList.stream()
				.collect(Collectors.groupingBy(CustomerData::getGeozone));
		return groupByGeoZone;

	}
}
