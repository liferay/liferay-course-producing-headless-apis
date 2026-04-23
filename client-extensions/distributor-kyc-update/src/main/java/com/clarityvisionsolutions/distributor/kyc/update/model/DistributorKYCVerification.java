package com.clarityvisionsolutions.distributor.kyc.update.model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * class DistributorKYCVerification: This class is used to get and update the distributor KYC details.
 *
 * @author dnebinger
 */
public class DistributorKYCVerification {

	public String getApplicationState() {
		return _applicationState;
	}

	public String getBusinessAddress() {
		return _businessAddress;
	}

	public String getBusinessName() {
		return _businessName;
	}

	public String getSubmittedBusinessEIN() {
		return _submittedBusinessEIN;
	}

	public String getValidatedBusinessEIN() {
		return _validatedBusinessEIN;
	}

	public String getBusinessType() {
		return _businessType;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public String getKYCResponse() {
		return _kYCResponse;
	}

	public String getKYCStatus() {
		return _kYCStatus;
	}

	public List<Permission> getPermissions() {
		return _permissions;
	}

	public String getR_applicationToKYC_c_distributorApplicationERC() {
		return _r_applicationToKYC_c_distributorApplicationERC;
	}

	public int getR_applicationToKYC_c_distributorApplicationId() {
		return _r_applicationToKYC_c_distributorApplicationId;
	}

	// Getters and Setters

	public void setApplicationState(String applicationState) {
		_applicationState = applicationState;
	}

	public void setBusinessAddress(String businessAddress) {
		_businessAddress = businessAddress;
	}

	public void setBusinessName(String businessName) {
		_businessName = businessName;
	}

	public void setSubmittedBusinessEIN(String submittedBusinessEIN) {
		_submittedBusinessEIN = submittedBusinessEIN;
	}

	public void setValidatedBusinessEIN(String validatedBusinessEIN) {
		_validatedBusinessEIN = validatedBusinessEIN;
	}

	public void setBusinessType(String businessType) {
		_businessType = businessType;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public void setKYCResponse(String kYCResponse) {
		_kYCResponse = kYCResponse;
	}

	public void setKYCStatus(String kYCStatus) {
		_kYCStatus = kYCStatus;
	}

	public void setPermissions(List<Permission> permissions) {
		_permissions = permissions;
	}

	public void setR_applicationToKYC_c_distributorApplicationERC(
		String r_applicationToKYC_c_distributorApplicationERC) {

		_r_applicationToKYC_c_distributorApplicationERC =
			r_applicationToKYC_c_distributorApplicationERC;
	}

	public void setR_applicationToKYC_c_distributorApplicationId(
		int r_applicationToKYC_c_distributorApplicationId) {

		_r_applicationToKYC_c_distributorApplicationId =
			r_applicationToKYC_c_distributorApplicationId;
	}

	/**
	 * Method to convert the instance to JSON.
	 *
	 * @return JSON object
	 */
	public JSONObject toJSON() {
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("externalReferenceCode", getExternalReferenceCode());

		JSONArray permissionsArray = new JSONArray();

		if (getPermissions() != null) {
			for (Permission permission : getPermissions()) {
				JSONObject permissionObject = new JSONObject();

				permissionObject.put("roleName", permission.getRoleName());

				JSONArray actionIdsArray = new JSONArray();

				for (String actionId : permission.getActionIds()) {
					actionIdsArray.put(actionId);
				}

				permissionObject.put("actionIds", actionIdsArray);

				permissionsArray.put(permissionObject);
			}
		}

		jsonObject.put(
			"applicationState", getApplicationState()
		).put(
			"businessAddress", getBusinessAddress()
		).put(
			"businessName", getBusinessName()
		).put(
			"submittedBusinessEIN", getSubmittedBusinessEIN()
		).put(
			"validatedBusinessEIN", getValidatedBusinessEIN()
		).put(
			"businessType", getBusinessType()
		).put(
			"kYCResponse", getKYCResponse()
		).put(
			"kYCStatus", getKYCStatus()
		).put(
			"permissions", permissionsArray
		).put(
			"r_applicationToKYC_c_distributorApplicationERC",
			getR_applicationToKYC_c_distributorApplicationERC()
		).put(
			"r_applicationToKYC_c_distributorApplicationId",
			getR_applicationToKYC_c_distributorApplicationId()
		);

		return jsonObject;
	}

	/**
	 * Inner class for Permission.
	 *
	 * @author dnebinger
	 */
	public static class Permission {

		public List<String> getActionIds() {
			return _actionIds;
		}

		public String getRoleName() {
			return _roleName;
		}

		// Getters and Setters

		public void setActionIds(List<String> actionIds) {
			_actionIds = actionIds;
		}

		public void setRoleName(String roleName) {
			_roleName = roleName;
		}

		private List<String> _actionIds;
		private String _roleName;

	}

	private String _applicationState;
	private String _businessAddress;
	private String _businessName;
	private String _submittedBusinessEIN;
	private String _validatedBusinessEIN;
	private String _businessType;
	private String _externalReferenceCode;
	private String _kYCResponse;
	private String _kYCStatus;
	private List<Permission> _permissions;

	// Inner class for Permission

	private String _r_applicationToKYC_c_distributorApplicationERC;

	// Method to convert the instance to JSON

	private int _r_applicationToKYC_c_distributorApplicationId;

}