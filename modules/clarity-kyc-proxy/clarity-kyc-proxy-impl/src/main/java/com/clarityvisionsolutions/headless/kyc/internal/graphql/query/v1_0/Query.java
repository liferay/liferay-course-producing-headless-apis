package com.clarityvisionsolutions.headless.kyc.internal.graphql.query.v1_0;

import com.clarityvisionsolutions.headless.kyc.dto.v1_0.AbbreviatedDistributorApp;
import com.clarityvisionsolutions.headless.kyc.resource.v1_0.AbbreviatedDistributorAppResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import jakarta.annotation.Generated;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ws.rs.core.UriInfo;

import java.util.Map;
import java.util.function.BiFunction;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author 17XZ0Z2
 * @generated
 */
@Generated("")
public class Query {

	public static void
		setAbbreviatedDistributorAppResourceComponentServiceObjects(
			ComponentServiceObjects<AbbreviatedDistributorAppResource>
				abbreviatedDistributorAppResourceComponentServiceObjects) {

		_abbreviatedDistributorAppResourceComponentServiceObjects =
			abbreviatedDistributorAppResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {abbreviatedDistributorAppErc(erc: ___){businessName, erc, id, kycStatus, taxId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AbbreviatedDistributorApp abbreviatedDistributorAppErc(
			@GraphQLName("erc") String erc)
		throws Exception {

		return _applyComponentServiceObjects(
			_abbreviatedDistributorAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			abbreviatedDistributorAppResource ->
				abbreviatedDistributorAppResource.
					getAbbreviatedDistributorAppErc(erc));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {abbreviatedDistributorAppId(id: ___){businessName, erc, id, kycStatus, taxId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public AbbreviatedDistributorApp abbreviatedDistributorAppId(
			@GraphQLName("id") Long id)
		throws Exception {

		return _applyComponentServiceObjects(
			_abbreviatedDistributorAppResourceComponentServiceObjects,
			this::_populateResourceContext,
			abbreviatedDistributorAppResource ->
				abbreviatedDistributorAppResource.
					getAbbreviatedDistributorAppId(id));
	}

	@GraphQLName("AbbreviatedDistributorAppPage")
	public class AbbreviatedDistributorAppPage {

		public AbbreviatedDistributorAppPage(
			Page abbreviatedDistributorAppPage) {

			actions = abbreviatedDistributorAppPage.getActions();

			items = abbreviatedDistributorAppPage.getItems();
			lastPage = abbreviatedDistributorAppPage.getLastPage();
			page = abbreviatedDistributorAppPage.getPage();
			pageSize = abbreviatedDistributorAppPage.getPageSize();
			totalCount = abbreviatedDistributorAppPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<AbbreviatedDistributorApp> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			AbbreviatedDistributorAppResource abbreviatedDistributorAppResource)
		throws Exception {

		abbreviatedDistributorAppResource.setContextAcceptLanguage(
			_acceptLanguage);
		abbreviatedDistributorAppResource.setContextCompany(_company);
		abbreviatedDistributorAppResource.setContextHttpServletRequest(
			_httpServletRequest);
		abbreviatedDistributorAppResource.setContextHttpServletResponse(
			_httpServletResponse);
		abbreviatedDistributorAppResource.setContextUriInfo(_uriInfo);
		abbreviatedDistributorAppResource.setContextUser(_user);
		abbreviatedDistributorAppResource.setGroupLocalService(
			_groupLocalService);
		abbreviatedDistributorAppResource.setRoleLocalService(
			_roleLocalService);
	}

	private static ComponentServiceObjects<AbbreviatedDistributorAppResource>
		_abbreviatedDistributorAppResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction
		<Object, String, com.liferay.portal.kernel.search.filter.Filter>
			_filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, com.liferay.portal.kernel.search.Sort[]>
		_sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}