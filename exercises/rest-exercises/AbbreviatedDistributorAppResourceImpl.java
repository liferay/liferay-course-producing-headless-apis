package com.clarityvisionsolutions.headless.kyc.internal.resource.v1_0;

import com.clarityvisionsolutions.headless.kyc.dto.v1_0.AbbreviatedDistributorApp;
import com.clarityvisionsolutions.headless.kyc.resource.v1_0.AbbreviatedDistributorAppResource;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.rest.dto.v1_0.ObjectEntry;
import com.liferay.object.rest.resource.v1_0.ObjectEntryResource;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMap;
import com.liferay.osgi.service.tracker.collections.map.ServiceTrackerMapFactory;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.Validator;

import java.lang.reflect.Method;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author dnebinger
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/abbreviated-distributor-app.properties",
	scope = ServiceScope.PROTOTYPE,
	service = AbbreviatedDistributorAppResource.class
)
public class AbbreviatedDistributorAppResourceImpl
	extends BaseAbbreviatedDistributorAppResourceImpl {

	@Override
	public AbbreviatedDistributorApp getAbbreviatedDistributorAppErc(String erc)
		throws Exception {

		// fetch the object entry using the resource id

		ObjectEntryResource objectEntryResource = _getObjectEntryResource(
			"c_distributorapplication", "DistributorApplication");

		ObjectEntry objectEntry =
			objectEntryResource.getByExternalReferenceCode(erc);

		return _getAbbreviatedDistributorApp(objectEntry);
	}

	@Override
	public AbbreviatedDistributorApp getAbbreviatedDistributorAppId(Long id)
		throws Exception {

		// fetch the object entry using the resource id

		ObjectEntryResource objectEntryResource = _getObjectEntryResource(
			"c_distributorapplication", "C_DistributorApplication");

		return _getAbbreviatedDistributorApp(
			objectEntryResource.getObjectEntry(id));
	}

	@Override
	public AbbreviatedDistributorApp patchAbbreviatedDistributorAppErc(
			String erc, AbbreviatedDistributorApp abbreviatedDistributorApp)
		throws Exception {

		// fetch the object entry using the resource id

		ObjectEntryResource objectEntryResource = _getObjectEntryResource(
			"c_distributorapplication", "DistributorApplication");

		ObjectEntry objectEntry =
			objectEntryResource.getByExternalReferenceCode(erc);

		return _patchAbbreviatedDistributorApp(
			objectEntryResource, objectEntry, abbreviatedDistributorApp);
	}

	@Override
	public AbbreviatedDistributorApp patchAbbreviatedDistributorAppId(
			Long id, AbbreviatedDistributorApp abbreviatedDistributorApp)
		throws Exception {

		// fetch the object entry using the resource id

		ObjectEntryResource objectEntryResource = _getObjectEntryResource(
			"c_distributorapplication", "C_DistributorApplication");

		ObjectEntry objectEntry = objectEntryResource.getObjectEntry(id);

		return _patchAbbreviatedDistributorApp(
			objectEntryResource, objectEntry, abbreviatedDistributorApp);
	}

	@Activate
	private void _activate(final BundleContext bundleContext) {
		_log.info("Activating AbbreviatedDistributorAppResourceImpl");

		_objectEntryResourceServiceTrackerMap =
			ServiceTrackerMapFactory.openSingleValueMap(
				bundleContext, ObjectEntryResource.class, "entity.class.name");
	}

	@Deactivate
	private void _deactivate() {
		_objectEntryResourceServiceTrackerMap.close();
	}

	private AbbreviatedDistributorApp _getAbbreviatedDistributorApp(
			ObjectEntry objectEntry)
		throws Exception {

		AbbreviatedDistributorApp abbreviatedDistributorApp =
			new AbbreviatedDistributorApp();

		// set the fields on the abbreviated distributor app object

		abbreviatedDistributorApp.setErc(
			objectEntry.getExternalReferenceCode());
		abbreviatedDistributorApp.setId(objectEntry.getId());

		// these values come from the properties of the object entry

		Map<String, Object> properties = objectEntry.getProperties();

		if ((properties != null) && !properties.isEmpty()) {
			abbreviatedDistributorApp.setBusinessName(
				properties.get(
					"businessName"
				).toString());
			abbreviatedDistributorApp.setTaxId(
				properties.get(
					"businessTaxIDNumber"
				).toString());
		}

		abbreviatedDistributorApp.setKycStatus(
			_getDistributorKycStatus(objectEntry.getId()));

		return abbreviatedDistributorApp;
	}

//Insert exercise code snippet here
	

	private String _getDistributorKycStatus(long id) throws Exception {
		ObjectEntry objectEntry = _getDistributorKyc(id);

		if (objectEntry != null) {

			// these values come from the properties of the object entry

			Map<String, Object> properties = objectEntry.getProperties();

			if ((properties != null) && !properties.isEmpty()) {
				return properties.get(
					"kYCStatus"
				).toString();
			}
		}

		return "Unknown";
	}

	private ObjectEntryResource _getObjectEntryResource(
			final String oerKey, final String oerSimpleName)
		throws Exception {

		try {
			ObjectEntryResource objectEntryResource =
				_objectEntryResourceServiceTrackerMap.getService(
					StringBundler.concat(
						ObjectEntry.class.getName(), StringPool.POUND, oerKey));

			// update the entity we got with the context information.

			objectEntryResource.setContextAcceptLanguage(contextAcceptLanguage);
			objectEntryResource.setContextCompany(contextCompany);
			objectEntryResource.setContextUser(contextUser);

			// load up the object definition

			String objDefnName = oerSimpleName;

			ObjectDefinition objDefn =
				_objectDefinitionLocalService.fetchObjectDefinition(
					contextCompany.getCompanyId(), objDefnName);

			// use reflection to set the object definition
			// on the object entry resource

			Class<?> clazz = objectEntryResource.getClass();

			Method method = clazz.getMethod(
				"setObjectDefinition", ObjectDefinition.class);

			method.invoke(objectEntryResource, objDefn);

			return objectEntryResource;
		}
		catch (Exception exception) {
			_log.error("Error getting object entry resource", exception);

			throw exception;
		}
	}

	private AbbreviatedDistributorApp _patchAbbreviatedDistributorApp(
			ObjectEntryResource objectEntryResource, ObjectEntry objectEntry,
			AbbreviatedDistributorApp abbreviatedDistributorApp)
		throws Exception {

		int updates = 0;

		if (Validator.isNotNull(abbreviatedDistributorApp.getBusinessName())) {
			objectEntry.getProperties(
			).put(
				"businessName", abbreviatedDistributorApp.getBusinessName()
			);
			updates++;
		}

		if (Validator.isNotNull(abbreviatedDistributorApp.getTaxId())) {
			objectEntry.getProperties(
			).put(
				"businessTaxIDNumber", abbreviatedDistributorApp.getTaxId()
			);
			updates++;
		}

		if (updates > 0) {
			objectEntry = objectEntryResource.patchObjectEntry(
				objectEntry.getId(), objectEntry);
		}

		return _getAbbreviatedDistributorApp(objectEntry);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AbbreviatedDistributorAppResourceImpl.class);

	@Reference
	private ObjectDefinitionLocalService _objectDefinitionLocalService;

	private ServiceTrackerMap<String, ObjectEntryResource>
		_objectEntryResourceServiceTrackerMap;

}