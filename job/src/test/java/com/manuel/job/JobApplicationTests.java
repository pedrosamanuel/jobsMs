package com.manuel.job;

import com.manuel.job.job.clients.CompanyClient;
import com.manuel.job.job.external.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JobApplicationTests {

	@Autowired
	private CompanyClient companyClient;

	@Test
	public void testGetCompany() {
		Company company = companyClient.getCompany(1L);
		assertNotNull(company);
		System.out.println(company);
	}@Test
	void contextLoads() {
	}

}
