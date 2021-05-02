package com.java.ram.oracleCodingExercise.config;

/*Loads data from CSV file and store in customerDataList*/
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.java.ram.oracleCodingExercise.model.CustomerData;
import com.opencsv.CSVReader;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Getter
@Setter
@Slf4j
public class LoadCustomerData {

	public static List<CustomerData> customerDataList = new ArrayList<CustomerData>();

	@Value("${customerDataFilePath}")
	private String customerDataFilePath;

	@PostConstruct
	public void loadCustomerData() {
		try {
			InputStream fin = this.getClass().getResourceAsStream(customerDataFilePath);
			CSVReader reader = new CSVReader(new InputStreamReader(fin));
			// read all lines from csv file
			List<String[]> records = reader.readAll();

			records.stream().filter(record -> record.length == 6).forEach(record -> {
				CustomerData customerData = CustomerData.builder().customerId(record[0]).contractId(record[1])
						.geozone(record[2]).teamcode(record[3]).projectcode(record[4])
						.buildduration(Integer.valueOf(record[5].substring(0, record[5].length() - 1))).build();

				customerDataList.add(customerData);
			});

			// close csv reader
			reader.close();
		} catch (Exception e) {
			String errorMsg = String.format("Exception while reading/ parsing the file. Caused by: {}, Error Msg: {}",
					e.getCause(), e.getMessage());
			log.error(errorMsg);
		}
	}
}
