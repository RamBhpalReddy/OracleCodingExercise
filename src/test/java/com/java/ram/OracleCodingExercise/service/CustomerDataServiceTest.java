package com.java.ram.OracleCodingExercise.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.java.ram.oracleCodingExercise.model.CustomerData;
import com.java.ram.oracleCodingExercise.service.CustomerDataServiceImpl;

public class CustomerDataServiceTest {
	
	private CustomerDataServiceImpl customerDataServiceImpl;
	
	 @BeforeEach  
	    public void setUp() throws Exception {
		    customerDataServiceImpl = new CustomerDataServiceImpl();
	        List<CustomerData>  customerDataList = new ArrayList<>();
	        CustomerData c1 = new CustomerData("2343225","2345","us_east","RedTeam","ProjectApple",3445);
	        CustomerData c2 = new CustomerData("2343226","2345","us_east","RedTeam","ProjectApple",2457);
	        CustomerData c3 = new CustomerData("2343227","2346","us_west","RedTeam","ProjectApple",1998);
	        CustomerData c4 = new CustomerData("2343228","2346","us_west","RedTeam","ProjectApple",2112);
	        CustomerData c5 = new CustomerData("2343229","2347","us_north","RedTeam","ProjectApple",3445);
	        customerDataList.add(c1);
	        customerDataList.add(c2);
	        customerDataList.add(c3);
	        customerDataList.add(c4);
	        customerDataList.add(c5);
			ReflectionTestUtils.setField(customerDataServiceImpl, "customerDataList", customerDataList);
	    }  
	 
	 @Test
	 public void testGetNoOfCustIdForEachContractId() {
		 Map<String, Integer> response = customerDataServiceImpl.getNoOfCustIdForEachContractId();
		 assertNotNull(response);
		 assertEquals(response.get("2345"), 2);
		 assertEquals(response.get("2346"), 2);
		 assertEquals(response.get("2347"), 1);
	 }
	 
	 @Test
	 public void testGetNoOfCustIdForEachGeoZone() {
		 Map<String, Integer> response = customerDataServiceImpl.getNoOfCustIdForEachGeoZone();
		 assertNotNull(response);
		 assertEquals(response.get("us_east"), 2);
		 assertEquals(response.get("us_west"), 2);
		 assertEquals(response.get("us_north"), 1);
		
	 }
	 
	 @Test
	 public void testGetCustIdsForEachGeoZone() {
		 Map<String, Set<String>> response = customerDataServiceImpl.getCustIdsForEachGeoZone();
		 assertNotNull(response);
		 assertEquals(response.get("us_east").size(), 2);
		 assertTrue(response.get("us_east").contains("2343226"));
		 assertTrue(response.get("us_east").contains("2343225"));
		 assertEquals(response.get("us_west").size(), 2);
		 assertTrue(response.get("us_west").contains("2343227"));
		 assertTrue(response.get("us_west").contains("2343228"));
		 assertEquals(response.get("us_north").size(), 1);
		 assertTrue(response.get("us_north").contains("2343229"));
	 }
	 
	 @Test
	 public void testAveBuildDurationForEachGeoZone() {
		 Map<String, Float> response = customerDataServiceImpl.aveBuildDurationForEachGeoZone();
		 assertNotNull(response);
		 assertEquals(response.get("us_east"), 2951);
		 assertEquals(response.get("us_west"), 2055);
		 assertEquals(response.get("us_north"), 3445);
	 }

}
