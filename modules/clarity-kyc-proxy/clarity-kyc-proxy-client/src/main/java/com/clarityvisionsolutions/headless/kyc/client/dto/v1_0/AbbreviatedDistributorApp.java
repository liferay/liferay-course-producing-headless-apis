package com.clarityvisionsolutions.headless.kyc.client.dto.v1_0;

import com.clarityvisionsolutions.headless.kyc.client.function.UnsafeSupplier;
import com.clarityvisionsolutions.headless.kyc.client.serdes.v1_0.AbbreviatedDistributorAppSerDes;

import jakarta.annotation.Generated;

import java.io.Serializable;

import java.util.Objects;

/**
 * @author 17XZ0Z2
 * @generated
 */
@Generated("")
public class AbbreviatedDistributorApp implements Cloneable, Serializable {

	public static AbbreviatedDistributorApp toDTO(String json) {
		return AbbreviatedDistributorAppSerDes.toDTO(json);
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setBusinessName(
		UnsafeSupplier<String, Exception> businessNameUnsafeSupplier) {

		try {
			businessName = businessNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String businessName;

	public String getErc() {
		return erc;
	}

	public void setErc(String erc) {
		this.erc = erc;
	}

	public void setErc(UnsafeSupplier<String, Exception> ercUnsafeSupplier) {
		try {
			erc = ercUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String erc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public String getKycStatus() {
		return kycStatus;
	}

	public void setKycStatus(String kycStatus) {
		this.kycStatus = kycStatus;
	}

	public void setKycStatus(
		UnsafeSupplier<String, Exception> kycStatusUnsafeSupplier) {

		try {
			kycStatus = kycStatusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String kycStatus;

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public void setTaxId(
		UnsafeSupplier<String, Exception> taxIdUnsafeSupplier) {

		try {
			taxId = taxIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String taxId;

	@Override
	public AbbreviatedDistributorApp clone() throws CloneNotSupportedException {
		return (AbbreviatedDistributorApp)super.clone();
	}

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
		return AbbreviatedDistributorAppSerDes.toJSON(this);
	}

}