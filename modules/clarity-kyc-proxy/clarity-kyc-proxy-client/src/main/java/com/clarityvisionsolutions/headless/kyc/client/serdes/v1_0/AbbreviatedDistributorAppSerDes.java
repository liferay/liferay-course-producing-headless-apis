package com.clarityvisionsolutions.headless.kyc.client.serdes.v1_0;

import com.clarityvisionsolutions.headless.kyc.client.dto.v1_0.AbbreviatedDistributorApp;
import com.clarityvisionsolutions.headless.kyc.client.json.BaseJSONParser;

import jakarta.annotation.Generated;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author 17XZ0Z2
 * @generated
 */
@Generated("")
public class AbbreviatedDistributorAppSerDes {

	public static AbbreviatedDistributorApp toDTO(String json) {
		AbbreviatedDistributorAppJSONParser
			abbreviatedDistributorAppJSONParser =
				new AbbreviatedDistributorAppJSONParser();

		return abbreviatedDistributorAppJSONParser.parseToDTO(json);
	}

	public static AbbreviatedDistributorApp[] toDTOs(String json) {
		AbbreviatedDistributorAppJSONParser
			abbreviatedDistributorAppJSONParser =
				new AbbreviatedDistributorAppJSONParser();

		return abbreviatedDistributorAppJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		AbbreviatedDistributorApp abbreviatedDistributorApp) {

		if (abbreviatedDistributorApp == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (abbreviatedDistributorApp.getBusinessName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessName\": ");

			sb.append("\"");

			sb.append(_escape(abbreviatedDistributorApp.getBusinessName()));

			sb.append("\"");
		}

		if (abbreviatedDistributorApp.getErc() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"erc\": ");

			sb.append("\"");

			sb.append(_escape(abbreviatedDistributorApp.getErc()));

			sb.append("\"");
		}

		if (abbreviatedDistributorApp.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(abbreviatedDistributorApp.getId());
		}

		if (abbreviatedDistributorApp.getKycStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"kycStatus\": ");

			sb.append("\"");

			sb.append(_escape(abbreviatedDistributorApp.getKycStatus()));

			sb.append("\"");
		}

		if (abbreviatedDistributorApp.getTaxId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taxId\": ");

			sb.append("\"");

			sb.append(_escape(abbreviatedDistributorApp.getTaxId()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AbbreviatedDistributorAppJSONParser
			abbreviatedDistributorAppJSONParser =
				new AbbreviatedDistributorAppJSONParser();

		return abbreviatedDistributorAppJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		AbbreviatedDistributorApp abbreviatedDistributorApp) {

		if (abbreviatedDistributorApp == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (abbreviatedDistributorApp.getBusinessName() == null) {
			map.put("businessName", null);
		}
		else {
			map.put(
				"businessName",
				String.valueOf(abbreviatedDistributorApp.getBusinessName()));
		}

		if (abbreviatedDistributorApp.getErc() == null) {
			map.put("erc", null);
		}
		else {
			map.put("erc", String.valueOf(abbreviatedDistributorApp.getErc()));
		}

		if (abbreviatedDistributorApp.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(abbreviatedDistributorApp.getId()));
		}

		if (abbreviatedDistributorApp.getKycStatus() == null) {
			map.put("kycStatus", null);
		}
		else {
			map.put(
				"kycStatus",
				String.valueOf(abbreviatedDistributorApp.getKycStatus()));
		}

		if (abbreviatedDistributorApp.getTaxId() == null) {
			map.put("taxId", null);
		}
		else {
			map.put(
				"taxId", String.valueOf(abbreviatedDistributorApp.getTaxId()));
		}

		return map;
	}

	public static class AbbreviatedDistributorAppJSONParser
		extends BaseJSONParser<AbbreviatedDistributorApp> {

		@Override
		protected AbbreviatedDistributorApp createDTO() {
			return new AbbreviatedDistributorApp();
		}

		@Override
		protected AbbreviatedDistributorApp[] createDTOArray(int size) {
			return new AbbreviatedDistributorApp[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "businessName")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "erc")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "kycStatus")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "taxId")) {
				return false;
			}

			return false;
		}

		@Override
		protected void setField(
			AbbreviatedDistributorApp abbreviatedDistributorApp,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "businessName")) {
				if (jsonParserFieldValue != null) {
					abbreviatedDistributorApp.setBusinessName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "erc")) {
				if (jsonParserFieldValue != null) {
					abbreviatedDistributorApp.setErc(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					abbreviatedDistributorApp.setId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "kycStatus")) {
				if (jsonParserFieldValue != null) {
					abbreviatedDistributorApp.setKycStatus(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "taxId")) {
				if (jsonParserFieldValue != null) {
					abbreviatedDistributorApp.setTaxId(
						(String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			sb.append(_toJSON(value));

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _toJSON(Object value) {
		if (value == null) {
			return "null";
		}

		if (value instanceof Map) {
			return _toJSON((Map)value);
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			StringBuilder sb = new StringBuilder("[");

			Object[] values = (Object[])value;

			for (int i = 0; i < values.length; i++) {
				sb.append(_toJSON(values[i]));

				if ((i + 1) < values.length) {
					sb.append(", ");
				}
			}

			sb.append("]");

			return sb.toString();
		}

		if (value instanceof String) {
			return "\"" + _escape(value) + "\"";
		}

		return String.valueOf(value);
	}

}