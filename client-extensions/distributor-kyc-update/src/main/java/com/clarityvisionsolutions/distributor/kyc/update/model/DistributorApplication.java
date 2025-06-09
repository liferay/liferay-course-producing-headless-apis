package com.clarityvisionsolutions.distributor.kyc.update.model;

import org.json.JSONObject;

/**
 * class DistributorApplication: This class is used to get and update the distributor application.
 *
 * The actual object in Liferay has a bunch of related objects/fields, but since we don't care about
 * them in this implementation, we've decided to exclude them from this class.
 * 
 * @author dnebinger
 */
public class DistributorApplication {

	/**
	 * Constructor for the DistributorApplication class.
	 * 
	 * @param jsonString
	 */
	public DistributorApplication(String jsonString) {
		JSONObject rootObject = new JSONObject(jsonString);

		JSONObject jsonObject = rootObject.getJSONObject(
			"objectEntryDTODistributorApplication");

		_creator = rootObject.getString("userName");

		_dateCreated = jsonObject.getLong("dateCreated");
		_dateModified = jsonObject.getLong("dateModified");
		_externalReferenceCode = jsonObject.getString("externalReferenceCode");
		_id = jsonObject.getInt("id");

		if (jsonObject.has("scopeKey")) {
			_scopeKey = jsonObject.getString("scopeKey");
		}

		_status = jsonObject.getJSONObject(
			"status"
		).getInt(
			"code"
		);

		JSONObject props = jsonObject.getJSONObject("properties");

		_applicantEmailAddress = props.getString("applicantEmailAddress");
		_businessName = props.getString("businessName");
		_businessPhoneNumber = props.getString("businessPhoneNumber");
		_businessTaxIDNumber = props.getString("businessTaxIDNumber");
		_businessWebsiteURL = props.getString("businessWebsiteURL");
	}

	public String getApplicantEmailAddress() {
		return _applicantEmailAddress;
	}

	public String getApplicantName() {
		return _applicantName;
	}

	public String getBusinessName() {
		return _businessName;
	}

	public String getBusinessPhoneNumber() {
		return _businessPhoneNumber;
	}

	public String getBusinessTaxIDNumber() {
		return _businessTaxIDNumber;
	}

	public String getBusinessWebsiteURL() {
		return _businessWebsiteURL;
	}

	public String getComments() {
		return _comments;
	}

	public String getCreator() {
		return _creator;
	}

	public long getDateCreated() {
		return _dateCreated;
	}

	public long getDateModified() {
		return _dateModified;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public int getId() {
		return _id;
	}

	public String getScopeKey() {
		return _scopeKey;
	}

	public int getStatus() {
		return _status;
	}

	public void setApplicantEmailAddress(String applicantEmailAddress) {
		_applicantEmailAddress = applicantEmailAddress;
	}

	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	public void setBusinessName(String businessName) {
		_businessName = businessName;
	}

	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		_businessPhoneNumber = businessPhoneNumber;
	}

	public void setBusinessTaxIDNumber(String businessTaxIDNumber) {
		_businessTaxIDNumber = businessTaxIDNumber;
	}

	public void setBusinessWebsiteURL(String businessWebsiteURL) {
		_businessWebsiteURL = businessWebsiteURL;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public void setCreator(String creator) {
		_creator = creator;
	}

	public void setDateCreated(long dateCreated) {
		_dateCreated = dateCreated;
	}

	public void setDateModified(long dateModified) {
		_dateModified = dateModified;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public void setId(int id) {
		_id = id;
	}

	public void setScopeKey(String scopeKey) {
		_scopeKey = scopeKey;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _applicantEmailAddress;
	private String _applicantName;
	private String _businessName;
	private String _businessPhoneNumber;
	private String _businessTaxIDNumber;
	private String _businessWebsiteURL;
	private String _comments;
	private String _creator;
	private long _dateCreated;
	private long _dateModified;
	private String _externalReferenceCode;
	private int _id;
	private String _scopeKey;
	private int _status;

}