package com.clarityvisionsolutions.distributor.app.model;

import org.json.JSONObject;

/**
 * class DistributorAppDTO: This class is used to get and update the distributor application.
 *
 * @author dnebinger
 */
public class DistributorAppDTO {

	public DistributorAppDTO() {
	}

	public DistributorAppDTO(String jsonString) {
		JSONObject jsonObject = new JSONObject(jsonString);

		_businessName = jsonObject.optString("businessName");
		_businessTaxIDNumber = jsonObject.optString("businessTaxIDNumber");
		_kycStatus = jsonObject.optString("kycStatus");
		_distributorApplicationID = jsonObject.optLong(
			"distributorApplicationID");
		_distributorApplicationERC = jsonObject.optString(
			"distributorApplicationERC");
	}

	public DistributorAppDTO(
		String businessName, String businessTaxIDNumber, String kycStatus,
		Long distributorApplicationID, String distributorApplicationERC) {

		_businessName = businessName;
		_businessTaxIDNumber = businessTaxIDNumber;
		_kycStatus = kycStatus;
		_distributorApplicationID = distributorApplicationID;
		_distributorApplicationERC = distributorApplicationERC;
	}

	public String getBusinessName() {
		return _businessName;
	}

	public String getBusinessTaxIDNumber() {
		return _businessTaxIDNumber;
	}

	public String getDistributorApplicationERC() {
		return _distributorApplicationERC;
	}

	public Long getDistributorApplicationID() {
		return _distributorApplicationID;
	}

	public String getKycStatus() {
		return _kycStatus;
	}

	public void setBusinessName(String businessName) {
		_businessName = businessName;
	}

	public void setBusinessTaxIDNumber(String businessTaxIDNumber) {
		_businessTaxIDNumber = businessTaxIDNumber;
	}

	public void setDistributorApplicationERC(String distributorApplicationERC) {
		_distributorApplicationERC = distributorApplicationERC;
	}

	public void setDistributorApplicationID(Long distributorApplicationID) {
		_distributorApplicationID = distributorApplicationID;
	}

	public void setKycStatus(String kycStatus) {
		_kycStatus = kycStatus;
	}

	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put(
			"businessName", _businessName
		).put(
			"businessTaxIDNumber", _businessTaxIDNumber
		).put(
			"distributorApplicationERC", _distributorApplicationERC
		).put(
			"distributorApplicationID", _distributorApplicationID
		).put(
			"kycStatus", _kycStatus
		);

		return jsonObject;
	}

	private String _businessName;
	private String _businessTaxIDNumber;
	private String _distributorApplicationERC;
	private Long _distributorApplicationID;
	private String _kycStatus;

}