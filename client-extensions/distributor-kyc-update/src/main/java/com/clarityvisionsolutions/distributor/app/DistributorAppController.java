package com.clarityvisionsolutions.distributor.app;

import com.clarityvisionsolutions.distributor.app.model.DistributorAppDTO;

import java.util.Collections;

import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * class DistributorAppController: This class is used to get and update the distributor application.
 *
 * @author dnebinger
 */
@RequestMapping("/distributor/app")
@RestController
public class DistributorAppController {

	@GetMapping("/erc/{erc}")
	public ResponseEntity<String> getByErc(
		@AuthenticationPrincipal Jwt jwt, @PathVariable String erc) {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(
			Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("x-csrf-token", "wvgfiLCY");
		headers.set("Authorization", "Bearer " + jwt.getTokenValue());

		String url =
			_getBaseURL() +
				"/o/c/distributorapplications/by-external-reference-code/" +
					erc + "?nestedFields=applicationToKYC";
		HttpEntity<String> request = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(
			url, HttpMethod.GET, request, String.class);

		if (response.getStatusCode(
			).is2xxSuccessful()) {

			JSONObject jsonObject = new JSONObject(response.getBody());

			DistributorAppDTO distributorAppDTO = new DistributorAppDTO();

			distributorAppDTO.setBusinessName(
				jsonObject.optString("businessName"));
			distributorAppDTO.setBusinessTaxIDNumber(
				jsonObject.optString("businessTaxIDNumber"));
			distributorAppDTO.setKycStatus("unknown");
			distributorAppDTO.setDistributorApplicationID(
				jsonObject.optLong("id"));
			distributorAppDTO.setDistributorApplicationERC(
				jsonObject.optString("externalReferenceCode"));

			if (jsonObject.has("applicationToKYC")) {
				JSONObject applicationToKYC = jsonObject.getJSONArray(
					"applicationToKYC"
				).getJSONObject(
					0
				);

				distributorAppDTO.setKycStatus(
					applicationToKYC.optString("kYCStatus"));
			}

			return ResponseEntity.ok(
				distributorAppDTO.toJSON(
				).toString());
		}

		return ResponseEntity.status(
			response.getStatusCode()
		).build();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<String> getById(
		@AuthenticationPrincipal Jwt jwt, @PathVariable Long id) {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(
			Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("x-csrf-token", "wvgfiLCY");
		headers.set("Authorization", "Bearer " + jwt.getTokenValue());

		String url =
			_getBaseURL() + "/o/c/distributorapplications/" + id +
				"?nestedFields=applicationToKYC";
		HttpEntity<String> request = new HttpEntity<>(headers);

		ResponseEntity<String> response = restTemplate.exchange(
			url, HttpMethod.GET, request, String.class);

		if (response.getStatusCode(
			).is2xxSuccessful()) {

			JSONObject jsonObject = new JSONObject(response.getBody());

			DistributorAppDTO distributorAppDTO = new DistributorAppDTO();

			distributorAppDTO.setBusinessName(
				jsonObject.optString("businessName"));
			distributorAppDTO.setBusinessTaxIDNumber(
				jsonObject.optString("businessTaxIDNumber"));
			distributorAppDTO.setKycStatus("unknown");
			distributorAppDTO.setDistributorApplicationID(
				jsonObject.optLong("id"));
			distributorAppDTO.setDistributorApplicationERC(
				jsonObject.optString("externalReferenceCode"));

			if (jsonObject.has("applicationToKYC")) {
				JSONObject applicationToKYC = jsonObject.getJSONArray(
					"applicationToKYC"
				).getJSONObject(
					0
				);

				distributorAppDTO.setKycStatus(
					applicationToKYC.optString("kYCStatus"));
			}

			return ResponseEntity.ok(
				distributorAppDTO.toJSON(
				).toString());
		}

		return ResponseEntity.status(
			response.getStatusCode()
		).build();
	}

	@PatchMapping("/erc/{erc}")
	public ResponseEntity<String> patchByErc(
		@AuthenticationPrincipal Jwt jwt, @PathVariable String erc,
		@RequestBody String jsonBody) {

		DistributorAppDTO update = new DistributorAppDTO(jsonBody);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(
			Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("x-csrf-token", "wvgfiLCY");
		headers.set("Authorization", "Bearer " + jwt.getTokenValue());

		String url =
			_getBaseURL() +
				"/o/c/distributorapplications/by-external-reference-code/" +
					erc;

		JSONObject updateObj = new JSONObject();

		updateObj.put(
			"businessName", update.getBusinessName()
		).put(
			"businessTaxIDNumber", update.getBusinessTaxIDNumber()
		).put(
			"externalReferenceCode", update.getDistributorApplicationERC()
		);

		HttpEntity<String> request = new HttpEntity<>(
			updateObj.toString(), headers);

		ResponseEntity<String> response = restTemplate.exchange(
			url, HttpMethod.PATCH, request, String.class);

		if (response.getStatusCode(
			).is2xxSuccessful()) {

			return ResponseEntity.ok(response.getBody());
		}

		return ResponseEntity.status(
			response.getStatusCode()
		).build();
	}

	@PatchMapping("/id/{id}")
	public ResponseEntity<String> patchById(
		@AuthenticationPrincipal Jwt jwt, @PathVariable Long id,
		@RequestBody String jsonBody) {

		DistributorAppDTO update = new DistributorAppDTO(jsonBody);

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(
			Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("x-csrf-token", "wvgfiLCY");
		headers.set("Authorization", "Bearer " + jwt.getTokenValue());

		String url = _getBaseURL() + "/o/c/distributorapplications/" + id;

		JSONObject updateObj = new JSONObject();

		updateObj.put(
			"businessName", update.getBusinessName()
		).put(
			"businessTaxIDNumber", update.getBusinessTaxIDNumber()
		).put(
			"externalReferenceCode", update.getDistributorApplicationERC()
		);

		HttpEntity<String> request = new HttpEntity<>(
			updateObj.toString(), headers);

		ResponseEntity<String> response = restTemplate.exchange(
			url, HttpMethod.PATCH, request, String.class);

		if (response.getStatusCode(
			).is2xxSuccessful()) {

			return ResponseEntity.ok(response.getBody());
		}

		return ResponseEntity.status(
			response.getStatusCode()
		).build();
	}

	private String _getBaseURL() {
		return _liferayLxcDxpServerProtocol + "://" + _liferayLxcDxpDomains;
	}

	@Value("${com.liferay.lxc.dxp.domains}")
	private String _liferayLxcDxpDomains;

	@Value("${com.liferay.lxc.dxp.server.protocol}")
	private String _liferayLxcDxpServerProtocol;

}