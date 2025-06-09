package com.clarityvisionsolutions.distributor.kyc.update;

import com.liferay.client.extension.util.spring.boot3.ClientExtensionUtilSpringBootComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * class DistributorKycUpdateApplication: This class is used to run the distributor KYC update application.
 *
 * @author dnebinger
 */
@Import(ClientExtensionUtilSpringBootComponentScan.class)
@SpringBootApplication
public class DistributorKycUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributorKycUpdateApplication.class, args);
	}

}