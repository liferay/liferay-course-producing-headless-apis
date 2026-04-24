package com.clarityvisionsolutions.headless.kyc.internal.graphql.servlet.v1_0;

import com.clarityvisionsolutions.headless.kyc.internal.graphql.mutation.v1_0.Mutation;
import com.clarityvisionsolutions.headless.kyc.internal.graphql.query.v1_0.Query;
import com.clarityvisionsolutions.headless.kyc.internal.resource.v1_0.AbbreviatedDistributorAppResourceImpl;
import com.clarityvisionsolutions.headless.kyc.resource.v1_0.AbbreviatedDistributorAppResource;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import jakarta.annotation.Generated;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author 17XZ0Z2
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setAbbreviatedDistributorAppResourceComponentServiceObjects(
			_abbreviatedDistributorAppResourceComponentServiceObjects);

		Query.setAbbreviatedDistributorAppResourceComponentServiceObjects(
			_abbreviatedDistributorAppResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "ClarityKycProxy";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/clarity-kyc-proxy-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#patchAbbreviatedDistributorAppErc",
						new ObjectValuePair<>(
							AbbreviatedDistributorAppResourceImpl.class,
							"patchAbbreviatedDistributorAppErc"));
					put(
						"mutation#patchAbbreviatedDistributorAppId",
						new ObjectValuePair<>(
							AbbreviatedDistributorAppResourceImpl.class,
							"patchAbbreviatedDistributorAppId"));

					put(
						"query#abbreviatedDistributorAppErc",
						new ObjectValuePair<>(
							AbbreviatedDistributorAppResourceImpl.class,
							"getAbbreviatedDistributorAppErc"));
					put(
						"query#abbreviatedDistributorAppId",
						new ObjectValuePair<>(
							AbbreviatedDistributorAppResourceImpl.class,
							"getAbbreviatedDistributorAppId"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AbbreviatedDistributorAppResource>
		_abbreviatedDistributorAppResourceComponentServiceObjects;

}