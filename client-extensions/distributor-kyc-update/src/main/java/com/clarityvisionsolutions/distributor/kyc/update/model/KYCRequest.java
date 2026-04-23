package com.clarityvisionsolutions.distributor.kyc.update.model;

import org.json.JSONObject;

/**
 * class KYCRequest: This class would be used to create a KYC request to some external API.
 * 
 * Since we're just mocking the response, this class is really nothing more than a placeholder.
 *
 * @author dnebinger
 */
public class KYCRequest {

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	/**
	 * Utility method to convert the KYCRequest object to a JSON string that we need to send to middesk.
	 */
	public String toJSON() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", _name);

		return jsonObject.toString();
	}

	private String _name;

}