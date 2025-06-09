/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.clarityvisionsolutions.distributor.kyc.update;

import com.clarityvisionsolutions.distributor.kyc.update.model.DistributorApplication;
import com.clarityvisionsolutions.distributor.kyc.update.model.DistributorKYCVerification;
import com.clarityvisionsolutions.distributor.kyc.update.model.KYCRequest;
import com.clarityvisionsolutions.distributor.kyc.update.model.KYCResponse;

import com.liferay.client.extension.util.spring.boot3.BaseRestController;

import java.time.Instant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * class DistributorKYCUpdateController: This class is used to update the KYCResponse.KYC status of a distributor.
 *
 * @author dnebinger
 */
@RequestMapping("/distributor/kyc/update")
@RestController
public class DistributorKYCUpdateController extends BaseRestController {

	@PostMapping
	public ResponseEntity<String> post(
		@AuthenticationPrincipal Jwt jwt, @RequestBody String json) {

		HttpStatus httpStatus = HttpStatus.OK;

		try {
			_log.info("Received JSON: " + json);

			// extract the details from the JSON that we
			// need to invoke the external API with

			DistributorApplication distributorApplication =
				new DistributorApplication(json);

			// POST to an external API with the details and get the response
			// KYCResponse kycResponse =
			//   invokeMiddeskKYCService(distributorApplication);

			KYCResponse kycResponse = _mockKYCResponse(distributorApplication);

			// process the response to extract the details we need.

			// create the Distributor KYC Details object with
			// the details we got from middesk

			DistributorKYCVerification distributorKYCVerification =
				_generateDistributorKYCVerification(
					kycResponse, distributorApplication);

			// save the Distributor KYCResponse.KYC Details object

			_addDistributorKYCVerificationToLiferay(distributorKYCVerification, jwt);

			// Return the original unmodified JSON and a success status

		}
		catch (Exception exception) {
			_log.error(
				"Error processing distributor KYCResponse.KYC: " +
					exception.getMessage(),
				exception);

			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<>(json, httpStatus);
	}

	/**
	 * Utility method to add the Distributor KYC Verification object to Liferay.
	 *
	 * @param details
	 * @param jwt
	 */
	private void _addDistributorKYCVerificationToLiferay(
			DistributorKYCVerification details, Jwt jwt) {

		// Create a RestTemplate to make the request to Liferay
		RestTemplate restTemplate = new RestTemplate();

		// Create headers for the request

		HttpHeaders headers = new HttpHeaders();

		// Set the content type and accept headers

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(
			Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", "Bearer " + jwt.getTokenValue());

		// Convert the Distributor KYC Verification object to JSON

		String json = details.toJSON(
		).toString();

		_log.info("KYCResponse JSON: " + json);

		// Create a request entity with the JSON and headers

		HttpEntity<String> request = new HttpEntity<>(json, headers);

		// Get the base URL for the Liferay API

		String liferayApiUrl = _getBaseURL() + "/o/c/distributorkycverifications/";
		//String liferayApiUrl = "http://localhost:8080/o/c/distributorkycverifications/";

		// POST to the Liferay API

		try {
			ResponseEntity<String> response = restTemplate.postForEntity(
				liferayApiUrl, request, String.class);

			// Check if the response is successful

			if (!response.getStatusCode(
				).is2xxSuccessful()) {

				// If not successful, throw an exception

				throw new RuntimeException(
					"Failed to add KYC: " + response.getStatusCode());
			}
		}
		catch (Exception exception) {

			// If an exception occurs, throw an exception

			throw new RuntimeException(
				"Failed to add KYC: " + exception.getMessage(), exception);
		}
	}

	/**
	 * Utility method to create a KYCRequest object. We're not really making an
	 * external API call, so we're not really creating a KYCRequest object.
	 * 
	 * This method is really just a placeholder, as is the KYCRequest class.
	 *
	 * @param distributorApplication
	 * @return
	 */
	private KYCRequest _createKYCRequest(
		DistributorApplication distributorApplication) {

		KYCRequest kycRequest = new KYCRequest();

		// Set the name

		kycRequest.setName(distributorApplication.getBusinessName());

		return kycRequest;
	}

	/**
	 * Utility method to generate a Distributor KYC Verification object.
	 *
	 * @param kycResponse
	 * @param distributorApplication
	 * @return
	 */
	private DistributorKYCVerification _generateDistributorKYCVerification(
		KYCResponse kycResponse,
		DistributorApplication distributorApplication) {

		DistributorKYCVerification distributorKYCVerification =
			new DistributorKYCVerification();

		// Populate fields from KYCResponse

		distributorKYCVerification.setKYCResponse(kycResponse.getRawResponse());

		// Populate fields from DistributorApplication

		distributorKYCVerification.setExternalReferenceCode(
			distributorApplication.getExternalReferenceCode());
		distributorKYCVerification.setBusinessName(
			distributorApplication.getBusinessName());
		distributorKYCVerification.setSubmittedBusinessEIN(
			distributorApplication.getBusinessTaxIDNumber());
		distributorKYCVerification.setValidatedBusinessEIN(
			distributorApplication.getBusinessTaxIDNumber());
		distributorKYCVerification.setBusinessType(
			kycResponse.getIndustryClassification());
		distributorKYCVerification.setKYCStatus(
			kycResponse.getReviewStatus());
		distributorKYCVerification.setApplicationState(
			kycResponse.getReviewStatus());
		distributorKYCVerification.setExternalReferenceCode(
			kycResponse.getReviewId());

		distributorKYCVerification.setR_applicationToKYC_c_distributorApplicationId(
			distributorApplication.getId());
		distributorKYCVerification.setR_applicationToKYC_c_distributorApplicationERC(
			distributorApplication.getExternalReferenceCode());

		return distributorKYCVerification;
	}

	/**
	 * Utility method to get the base URL for the Liferay API.
	 *
	 * @return
	 */
	private String _getBaseURL() {
		return _liferayLxcDxpServerProtocol + "://" + _liferayLxcDxpDomains;
	}

	/**
	 * Utility method to mock a KYCResponse, useful in
	 * class where developer doesn't have an external API account.
	 */
	private KYCResponse _mockKYCResponse(
		DistributorApplication distributorApplication) {

		KYCResponse kycResponse = new KYCResponse();

		// Populate basic fields

		kycResponse.setObject("business");
		kycResponse.setId(String.valueOf(distributorApplication.getId()));
		kycResponse.setIndustryClassification("unknown");

		// Create a review object

		kycResponse.setReviewId(
			UUID.randomUUID(
			).toString());

		// Randomly decide KYCResponse.KYC decision

		if (Math.random() > 0.5) {
			kycResponse.setReviewStatus("Accepted");
		}
		else {
			kycResponse.setReviewStatus("Rejected");
		}

		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"id", kycResponse.getId()
		).put(
			"industryClassification", kycResponse.getIndustryClassification()
		).put(
			"object", kycResponse.getObject()
		).put(
			"reviewId", kycResponse.getReviewId()
		).put(
			"reviewStatus", kycResponse.getReviewStatus()
		);

		kycResponse.setRawResponse(jsonObject.toString());

		return kycResponse;
	}

	private static final Logger _log = LoggerFactory.getLogger(
		DistributorKYCUpdateController.class);

	@Value("${com.liferay.lxc.dxp.mainDomain}")
	private String _liferayLxcDxpDomains;

	@Value("${com.liferay.lxc.dxp.server.protocol}")
	private String _liferayLxcDxpServerProtocol;

}