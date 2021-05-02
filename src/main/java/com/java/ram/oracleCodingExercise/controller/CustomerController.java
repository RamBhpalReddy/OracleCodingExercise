package com.java.ram.oracleCodingExercise.controller;
/*Rest Controller to fetch data*/
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.ram.oracleCodingExercise.Exception.DataException;
import com.java.ram.oracleCodingExercise.service.CustomerDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customerData")
@Slf4j
public class CustomerController {
	
	private CustomerDataService customerDataService;

	public CustomerController(CustomerDataService customerDataService) {
		this.customerDataService = customerDataService;
	}

	@GetMapping("/noofUniqueCustIdForEachContractId")
	public @ResponseBody Map<String, Integer> getUniqueCustIdForEachContractId() {
		Map<String, Integer> response = new HashMap<>();
		try {
			response = customerDataService.getNoOfCustIdForEachContractId();
			log.info("getNoOfCustIdForEachContractId response: " + response);
		} catch (Exception e) {
			String errorMsg = String.format("Exception while fetching data. Caused by: {}, Error Msg: {}",
					e.getCause(), e.getMessage());
			log.error(errorMsg);
			throw new DataException(errorMsg);
		}
		return response;
	}

	@GetMapping("/noofUniqueCustIdForEachGeoZone")
	public @ResponseBody Map<String, Integer> getNoOfCustIdForEachGeoZone() {
		Map<String, Integer> response = new HashMap<>();
		try {
			response = customerDataService.getNoOfCustIdForEachGeoZone();
			log.info("getNoOfCustIdForEachGeoZone response: " + response);
		} catch (Exception e) {
			String errorMsg = String.format("Exception while fetching data. Caused by: {}, Error Msg: {}",
					e.getCause(), e.getMessage());
			log.error(errorMsg);
			throw new DataException(errorMsg);
		}
		return response;
	}

	@GetMapping("/getCustIdsForEachGeoZone")
	public @ResponseBody Map<String, Set<String>> getCustIdsForEachGeoZone() {
		Map<String, Set<String>> response = new HashMap<>();
		try {
			response = customerDataService.getCustIdsForEachGeoZone();
			log.info("getCustIdsForEachGeoZone response: " + response);
		} catch (Exception e) {
			String errorMsg = String.format("Exception while fetching data. Caused by: {}, Error Msg: {}",
					e.getCause(), e.getMessage());
			log.error(errorMsg);
			throw new DataException(errorMsg);
		}
		return response;
	}

	@GetMapping("/aveBuildDurationForEachGeoZone")
	public @ResponseBody Map<String, Float> aveBuildDurationForEachGeoZone() {
		Map<String, Float> response = new HashMap<>();
		try {
			response = customerDataService.aveBuildDurationForEachGeoZone();
			log.info("aveBuildDurationForEachGeoZone response: " + response);
		} catch (Exception e) {
			String errorMsg = String.format("Exception while fetching data. Caused by: {}, Error Msg: {}",
					e.getCause(), e.getMessage());
			log.error(errorMsg);
			throw new DataException(errorMsg);
		}
		return response;
	}

}
