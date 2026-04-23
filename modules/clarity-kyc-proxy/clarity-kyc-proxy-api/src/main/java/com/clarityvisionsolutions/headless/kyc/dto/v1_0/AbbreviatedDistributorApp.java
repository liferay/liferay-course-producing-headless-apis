package com.clarityvisionsolutions.headless.kyc.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import jakarta.annotation.Generated;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author 17XZ0Z2
 * @generated
 */
@Generated("")
@GraphQLName("AbbreviatedDistributorApp")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "AbbreviatedDistributorApp")
public class AbbreviatedDistributorApp implements Serializable {

	public static AbbreviatedDistributorApp toDTO(String json) {
		return ObjectMapperUtil.readValue(
			AbbreviatedDistributorApp.class, json);
	}

	public static AbbreviatedDistributorApp unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			AbbreviatedDistributorApp.class, json);
	}

	@io.swagger.v3.oas.annotations.media.Schema
	public String getBusinessName() {
		if (_businessNameSupplier != null) {
			businessName = _businessNameSupplier.get();

			_businessNameSupplier = null;
		}

		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;

		_businessNameSupplier = null;
	}

	@JsonIgnore
	public void setBusinessName(
		UnsafeSupplier<String, Exception> businessNameUnsafeSupplier) {

		_businessNameSupplier = () -> {
			try {
				return businessNameUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String businessName;

	@JsonIgnore
	private Supplier<String> _businessNameSupplier;

	@io.swagger.v3.oas.annotations.media.Schema
	public String getErc() {
		if (_ercSupplier != null) {
			erc = _ercSupplier.get();

			_ercSupplier = null;
		}

		return erc;
	}

	public void setErc(String erc) {
		this.erc = erc;

		_ercSupplier = null;
	}

	@JsonIgnore
	public void setErc(UnsafeSupplier<String, Exception> ercUnsafeSupplier) {
		_ercSupplier = () -> {
			try {
				return ercUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String erc;

	@JsonIgnore
	private Supplier<String> _ercSupplier;

	@io.swagger.v3.oas.annotations.media.Schema
	public Long getId() {
		if (_idSupplier != null) {
			id = _idSupplier.get();

			_idSupplier = null;
		}

		return id;
	}

	public void setId(Long id) {
		this.id = id;

		_idSupplier = null;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		_idSupplier = () -> {
			try {
				return idUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long id;

	@JsonIgnore
	private Supplier<Long> _idSupplier;

	@io.swagger.v3.oas.annotations.media.Schema
	public String getKycStatus() {
		if (_kycStatusSupplier != null) {
			kycStatus = _kycStatusSupplier.get();

			_kycStatusSupplier = null;
		}

		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;

		_kycStatusSupplier = null;
	}

	@JsonIgnore
	public void setKycStatus(
		UnsafeSupplier<String, Exception> kycStatusUnsafeSupplier) {

		_kycStatusSupplier = () -> {
			try {
				return kycStatusUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String kycStatus;

	@JsonIgnore
	private Supplier<String> _kycStatusSupplier;

	@io.swagger.v3.oas.annotations.media.Schema
	public String getTaxId() {
		if (_taxIdSupplier != null) {
			taxId = _taxIdSupplier.get();

			_taxIdSupplier = null;
		}

		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;

		_taxIdSupplier = null;
	}

	@JsonIgnore
	public void setTaxId(
		UnsafeSupplier<String, Exception> taxIdUnsafeSupplier) {

		_taxIdSupplier = () -> {
			try {
				return taxIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String taxId;

	@JsonIgnore
	private Supplier<String> _taxIdSupplier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AbbreviatedDistributorApp)) {
			return false;
		}

		AbbreviatedDistributorApp abbreviatedDistributorApp =
			(AbbreviatedDistributorApp)object;

		return Objects.equals(toString(), abbreviatedDistributorApp.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		String businessName = getBusinessName();

		if (businessName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"businessName\": ");

			sb.append("\"");

			sb.append(_escape(businessName));

			sb.append("\"");
		}

		String erc = getErc();

		if (erc != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"erc\": ");

			sb.append("\"");

			sb.append(_escape(erc));

			sb.append("\"");
		}

		Long id = getId();

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		String kycStatus = getKycStatus();

		if (kycStatus != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"kycStatus\": ");

			sb.append("\"");

			sb.append(_escape(kycStatus));

			sb.append("\"");
		}

		String taxId = getTaxId();

		if (taxId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"taxId\": ");

			sb.append("\"");

			sb.append(_escape(taxId));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@io.swagger.v3.oas.annotations.media.Schema(
		accessMode = io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY,
		defaultValue = "com.clarityvisionsolutions.headless.kyc.dto.v1_0.AbbreviatedDistributorApp",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof Map) {
						sb.append(_toJSON((Map<String, ?>)valueArray[i]));
					}
					else if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

	private Map<String, Serializable> _extendedProperties;

}