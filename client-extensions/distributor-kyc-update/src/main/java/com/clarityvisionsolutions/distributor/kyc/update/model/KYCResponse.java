package com.clarityvisionsolutions.distributor.kyc.update.model;

import org.json.JSONObject;

/**
 * class KYCResponse: This class is used to get and update the KYC response.
 *
 * @author dnebinger
 */
public class KYCResponse {

	public KYCResponse() {
	}

	public KYCResponse(String jsonString) {
		JSONObject jsonObject = new JSONObject(jsonString);

		_object = jsonObject.optString("object");
		_id = jsonObject.optString("id");
		_reviewId = jsonObject.optString("reviewId");
		_reviewStatus = jsonObject.optString("reviewStatus");

		_industryClassification = jsonObject.optString(
			"industryClassification");

		_rawResponse = jsonString;
	}

	public String getId() {
		return _id;
	}

	public String getIndustryClassification() {
		return _industryClassification;
	}

	public String getObject() {
		return _object;
	}

	public String getRawResponse() {
		return _rawResponse;
	}

	public String getReviewStatus() {
		return _reviewStatus;
	}

	public String getReviewId() {
		return _reviewId;
	}

	public void setId(String id) {
		_id = id;
	}

	public void setIndustryClassification(String industryClassification) {
		_industryClassification = industryClassification;
	}

	// Getters and Setters

	public void setObject(String object) {
		_object = object;
	}

	public void setRawResponse(String rawResponse) {
		_rawResponse = rawResponse;
	}

	public void setReviewStatus(String reviewStatus) {
		_reviewStatus = reviewStatus;
	}

	public void setReviewId(String reviewId) {
		_reviewId = reviewId;
	}

	private String _id;
	private String _industryClassification;
	private String _object;
	private String _rawResponse;
	private String _reviewStatus;
	private String _reviewId;
}