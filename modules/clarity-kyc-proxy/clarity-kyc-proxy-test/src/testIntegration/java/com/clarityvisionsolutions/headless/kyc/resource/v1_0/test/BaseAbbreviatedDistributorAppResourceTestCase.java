package com.clarityvisionsolutions.headless.kyc.resource.v1_0.test;

import com.clarityvisionsolutions.headless.kyc.client.dto.v1_0.AbbreviatedDistributorApp;
import com.clarityvisionsolutions.headless.kyc.client.http.HttpInvoker;
import com.clarityvisionsolutions.headless.kyc.client.pagination.Page;
import com.clarityvisionsolutions.headless.kyc.client.resource.v1_0.AbbreviatedDistributorAppResource;
import com.clarityvisionsolutions.headless.kyc.client.serdes.v1_0.AbbreviatedDistributorAppSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import jakarta.annotation.Generated;

import jakarta.ws.rs.core.MultivaluedHashMap;

import java.lang.reflect.Method;

import java.text.Format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author 17XZ0Z2
 * @generated
 */
@Generated("")
public abstract class BaseAbbreviatedDistributorAppResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_format = FastDateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_abbreviatedDistributorAppResource.setContextCompany(testCompany);

		_testCompanyAdminUser = UserTestUtil.getAdminUser(
			testCompany.getCompanyId());

		abbreviatedDistributorAppResource =
			AbbreviatedDistributorAppResource.builder(
			).authentication(
				_testCompanyAdminUser.getEmailAddress(),
				PropsValues.DEFAULT_ADMIN_PASSWORD
			).endpoint(
				testCompany.getVirtualHostname(), 8080, "http"
			).locale(
				LocaleUtil.getDefault()
			).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = getClientSerDesObjectMapper();

		AbbreviatedDistributorApp abbreviatedDistributorApp1 =
			randomAbbreviatedDistributorApp();

		String json = objectMapper.writeValueAsString(
			abbreviatedDistributorApp1);

		AbbreviatedDistributorApp abbreviatedDistributorApp2 =
			AbbreviatedDistributorAppSerDes.toDTO(json);

		Assert.assertTrue(
			equals(abbreviatedDistributorApp1, abbreviatedDistributorApp2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = getClientSerDesObjectMapper();

		AbbreviatedDistributorApp abbreviatedDistributorApp =
			randomAbbreviatedDistributorApp();

		String json1 = objectMapper.writeValueAsString(
			abbreviatedDistributorApp);
		String json2 = AbbreviatedDistributorAppSerDes.toJSON(
			abbreviatedDistributorApp);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	protected ObjectMapper getClientSerDesObjectMapper() {
		return new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		AbbreviatedDistributorApp abbreviatedDistributorApp =
			randomAbbreviatedDistributorApp();

		abbreviatedDistributorApp.setBusinessName(regex);
		abbreviatedDistributorApp.setErc(regex);
		abbreviatedDistributorApp.setKycStatus(regex);
		abbreviatedDistributorApp.setTaxId(regex);

		String json = AbbreviatedDistributorAppSerDes.toJSON(
			abbreviatedDistributorApp);

		Assert.assertFalse(json.contains(regex));

		abbreviatedDistributorApp = AbbreviatedDistributorAppSerDes.toDTO(json);

		Assert.assertEquals(regex, abbreviatedDistributorApp.getBusinessName());
		Assert.assertEquals(regex, abbreviatedDistributorApp.getErc());
		Assert.assertEquals(regex, abbreviatedDistributorApp.getKycStatus());
		Assert.assertEquals(regex, abbreviatedDistributorApp.getTaxId());
	}

	@Test
	public void testGetAbbreviatedDistributorAppErc() throws Exception {
		AbbreviatedDistributorApp postAbbreviatedDistributorApp =
			testGetAbbreviatedDistributorAppErc_addAbbreviatedDistributorApp();

		AbbreviatedDistributorApp getAbbreviatedDistributorApp =
			abbreviatedDistributorAppResource.getAbbreviatedDistributorAppErc(
				testGetAbbreviatedDistributorAppErc_getErc(
					postAbbreviatedDistributorApp));

		assertEquals(
			postAbbreviatedDistributorApp, getAbbreviatedDistributorApp);
		assertValid(getAbbreviatedDistributorApp);
	}

	protected AbbreviatedDistributorApp
			testGetAbbreviatedDistributorAppErc_addAbbreviatedDistributorApp()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetAbbreviatedDistributorAppErc_getErc(
			AbbreviatedDistributorApp abbreviatedDistributorApp)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAbbreviatedDistributorAppErc() throws Exception {
		AbbreviatedDistributorApp abbreviatedDistributorApp =
			testGraphQLGetAbbreviatedDistributorAppErc_addAbbreviatedDistributorApp();

		// No namespace

		Assert.assertTrue(
			equals(
				abbreviatedDistributorApp,
				AbbreviatedDistributorAppSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"abbreviatedDistributorAppErc",
								new HashMap<String, Object>() {
									{
										put(
											"erc",
											"\"" +
												testGraphQLGetAbbreviatedDistributorAppErc_getErc(
													abbreviatedDistributorApp) +
														"\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/abbreviatedDistributorAppErc"))));

		// Using the namespace clarityKycProxy_v1_0

		Assert.assertTrue(
			equals(
				abbreviatedDistributorApp,
				AbbreviatedDistributorAppSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"clarityKycProxy_v1_0",
								new GraphQLField(
									"abbreviatedDistributorAppErc",
									new HashMap<String, Object>() {
										{
											put(
												"erc",
												"\"" +
													testGraphQLGetAbbreviatedDistributorAppErc_getErc(
														abbreviatedDistributorApp) +
															"\"");
										}
									},
									getGraphQLFields()))),
						"JSONObject/data", "JSONObject/clarityKycProxy_v1_0",
						"Object/abbreviatedDistributorAppErc"))));
	}

	protected String testGraphQLGetAbbreviatedDistributorAppErc_getErc(
			AbbreviatedDistributorApp abbreviatedDistributorApp)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAbbreviatedDistributorAppErcNotFound()
		throws Exception {

		String irrelevantErc = "\"" + RandomTestUtil.randomString() + "\"";

		// No namespace

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"abbreviatedDistributorAppErc",
						new HashMap<String, Object>() {
							{
								put("erc", irrelevantErc);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));

		// Using the namespace clarityKycProxy_v1_0

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"clarityKycProxy_v1_0",
						new GraphQLField(
							"abbreviatedDistributorAppErc",
							new HashMap<String, Object>() {
								{
									put("erc", irrelevantErc);
								}
							},
							getGraphQLFields()))),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	protected AbbreviatedDistributorApp
			testGraphQLGetAbbreviatedDistributorAppErc_addAbbreviatedDistributorApp()
		throws Exception {

		return testGraphQLAbbreviatedDistributorApp_addAbbreviatedDistributorApp();
	}

	@Test
	public void testGetAbbreviatedDistributorAppId() throws Exception {
		AbbreviatedDistributorApp postAbbreviatedDistributorApp =
			testGetAbbreviatedDistributorAppId_addAbbreviatedDistributorApp();

		AbbreviatedDistributorApp getAbbreviatedDistributorApp =
			abbreviatedDistributorAppResource.getAbbreviatedDistributorAppId(
				postAbbreviatedDistributorApp.getId());

		assertEquals(
			postAbbreviatedDistributorApp, getAbbreviatedDistributorApp);
		assertValid(getAbbreviatedDistributorApp);
	}

	protected AbbreviatedDistributorApp
			testGetAbbreviatedDistributorAppId_addAbbreviatedDistributorApp()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetAbbreviatedDistributorAppId() throws Exception {
		AbbreviatedDistributorApp abbreviatedDistributorApp =
			testGraphQLGetAbbreviatedDistributorAppId_addAbbreviatedDistributorApp();

		// No namespace

		Assert.assertTrue(
			equals(
				abbreviatedDistributorApp,
				AbbreviatedDistributorAppSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"abbreviatedDistributorAppId",
								new HashMap<String, Object>() {
									{
										put(
											"id",
											abbreviatedDistributorApp.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data",
						"Object/abbreviatedDistributorAppId"))));

		// Using the namespace clarityKycProxy_v1_0

		Assert.assertTrue(
			equals(
				abbreviatedDistributorApp,
				AbbreviatedDistributorAppSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"clarityKycProxy_v1_0",
								new GraphQLField(
									"abbreviatedDistributorAppId",
									new HashMap<String, Object>() {
										{
											put(
												"id",
												abbreviatedDistributorApp.
													getId());
										}
									},
									getGraphQLFields()))),
						"JSONObject/data", "JSONObject/clarityKycProxy_v1_0",
						"Object/abbreviatedDistributorAppId"))));
	}

	@Test
	public void testGraphQLGetAbbreviatedDistributorAppIdNotFound()
		throws Exception {

		Long irrelevantId = RandomTestUtil.randomLong();

		// No namespace

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"abbreviatedDistributorAppId",
						new HashMap<String, Object>() {
							{
								put("id", irrelevantId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));

		// Using the namespace clarityKycProxy_v1_0

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"clarityKycProxy_v1_0",
						new GraphQLField(
							"abbreviatedDistributorAppId",
							new HashMap<String, Object>() {
								{
									put("id", irrelevantId);
								}
							},
							getGraphQLFields()))),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	protected AbbreviatedDistributorApp
			testGraphQLGetAbbreviatedDistributorAppId_addAbbreviatedDistributorApp()
		throws Exception {

		return testGraphQLAbbreviatedDistributorApp_addAbbreviatedDistributorApp();
	}

	@Test
	public void testPatchAbbreviatedDistributorAppErc() throws Exception {
		AbbreviatedDistributorApp postAbbreviatedDistributorApp =
			testPatchAbbreviatedDistributorAppErc_addAbbreviatedDistributorApp();

		AbbreviatedDistributorApp randomPatchAbbreviatedDistributorApp =
			randomPatchAbbreviatedDistributorApp();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		AbbreviatedDistributorApp patchAbbreviatedDistributorApp =
			abbreviatedDistributorAppResource.patchAbbreviatedDistributorAppErc(
				postAbbreviatedDistributorApp.getErc(),
				randomPatchAbbreviatedDistributorApp);

		AbbreviatedDistributorApp expectedPatchAbbreviatedDistributorApp =
			postAbbreviatedDistributorApp.clone();

		BeanTestUtil.copyProperties(
			randomPatchAbbreviatedDistributorApp,
			expectedPatchAbbreviatedDistributorApp);

		AbbreviatedDistributorApp getAbbreviatedDistributorApp =
			abbreviatedDistributorAppResource.getAbbreviatedDistributorAppErc(
				patchAbbreviatedDistributorApp.getErc());

		assertEquals(
			expectedPatchAbbreviatedDistributorApp,
			getAbbreviatedDistributorApp);
		assertValid(getAbbreviatedDistributorApp);
	}

	protected AbbreviatedDistributorApp
			testPatchAbbreviatedDistributorAppErc_addAbbreviatedDistributorApp()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPatchAbbreviatedDistributorAppId() throws Exception {
		AbbreviatedDistributorApp postAbbreviatedDistributorApp =
			testPatchAbbreviatedDistributorAppId_addAbbreviatedDistributorApp();

		AbbreviatedDistributorApp randomPatchAbbreviatedDistributorApp =
			randomPatchAbbreviatedDistributorApp();

		@SuppressWarnings("PMD.UnusedLocalVariable")
		AbbreviatedDistributorApp patchAbbreviatedDistributorApp =
			abbreviatedDistributorAppResource.patchAbbreviatedDistributorAppId(
				postAbbreviatedDistributorApp.getId(),
				randomPatchAbbreviatedDistributorApp);

		AbbreviatedDistributorApp expectedPatchAbbreviatedDistributorApp =
			postAbbreviatedDistributorApp.clone();

		BeanTestUtil.copyProperties(
			randomPatchAbbreviatedDistributorApp,
			expectedPatchAbbreviatedDistributorApp);

		AbbreviatedDistributorApp getAbbreviatedDistributorApp =
			abbreviatedDistributorAppResource.getAbbreviatedDistributorAppId(
				patchAbbreviatedDistributorApp.getId());

		assertEquals(
			expectedPatchAbbreviatedDistributorApp,
			getAbbreviatedDistributorApp);
		assertValid(getAbbreviatedDistributorApp);
	}

	protected AbbreviatedDistributorApp
			testPatchAbbreviatedDistributorAppId_addAbbreviatedDistributorApp()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected AbbreviatedDistributorApp
			testGraphQLAbbreviatedDistributorApp_addAbbreviatedDistributorApp()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		AbbreviatedDistributorApp abbreviatedDistributorApp,
		List<AbbreviatedDistributorApp> abbreviatedDistributorApps) {

		boolean contains = false;

		for (AbbreviatedDistributorApp item : abbreviatedDistributorApps) {
			if (equals(abbreviatedDistributorApp, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			abbreviatedDistributorApps + " does not contain " +
				abbreviatedDistributorApp,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		AbbreviatedDistributorApp abbreviatedDistributorApp1,
		AbbreviatedDistributorApp abbreviatedDistributorApp2) {

		Assert.assertTrue(
			abbreviatedDistributorApp1 + " does not equal " +
				abbreviatedDistributorApp2,
			equals(abbreviatedDistributorApp1, abbreviatedDistributorApp2));
	}

	protected void assertEquals(
		List<AbbreviatedDistributorApp> abbreviatedDistributorApps1,
		List<AbbreviatedDistributorApp> abbreviatedDistributorApps2) {

		Assert.assertEquals(
			abbreviatedDistributorApps1.size(),
			abbreviatedDistributorApps2.size());

		for (int i = 0; i < abbreviatedDistributorApps1.size(); i++) {
			AbbreviatedDistributorApp abbreviatedDistributorApp1 =
				abbreviatedDistributorApps1.get(i);
			AbbreviatedDistributorApp abbreviatedDistributorApp2 =
				abbreviatedDistributorApps2.get(i);

			assertEquals(
				abbreviatedDistributorApp1, abbreviatedDistributorApp2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<AbbreviatedDistributorApp> abbreviatedDistributorApps1,
		List<AbbreviatedDistributorApp> abbreviatedDistributorApps2) {

		Assert.assertEquals(
			abbreviatedDistributorApps1.size(),
			abbreviatedDistributorApps2.size());

		for (AbbreviatedDistributorApp abbreviatedDistributorApp1 :
				abbreviatedDistributorApps1) {

			boolean contains = false;

			for (AbbreviatedDistributorApp abbreviatedDistributorApp2 :
					abbreviatedDistributorApps2) {

				if (equals(
						abbreviatedDistributorApp1,
						abbreviatedDistributorApp2)) {

					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				abbreviatedDistributorApps2 + " does not contain " +
					abbreviatedDistributorApp1,
				contains);
		}
	}

	protected void assertValid(
			AbbreviatedDistributorApp abbreviatedDistributorApp)
		throws Exception {

		boolean valid = true;

		if (abbreviatedDistributorApp.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("businessName", additionalAssertFieldName)) {
				if (abbreviatedDistributorApp.getBusinessName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("erc", additionalAssertFieldName)) {
				if (abbreviatedDistributorApp.getErc() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("kycStatus", additionalAssertFieldName)) {
				if (abbreviatedDistributorApp.getKycStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("taxId", additionalAssertFieldName)) {
				if (abbreviatedDistributorApp.getTaxId() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<AbbreviatedDistributorApp> page) {
		assertValid(page, Collections.emptyMap());
	}

	protected void assertValid(
		Page<AbbreviatedDistributorApp> page,
		Map<String, Map<String, String>> expectedActions) {

		boolean valid = false;

		java.util.Collection<AbbreviatedDistributorApp>
			abbreviatedDistributorApps = page.getItems();

		int size = abbreviatedDistributorApps.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);

		assertValid(page.getActions(), expectedActions);
	}

	protected void assertValid(
		Map<String, Map<String, String>> actions1,
		Map<String, Map<String, String>> actions2) {

		for (String key : actions2.keySet()) {
			Map action = actions1.get(key);

			Assert.assertNotNull(key + " does not contain an action", action);

			Map<String, String> expectedAction = actions2.get(key);

			Assert.assertEquals(
				expectedAction.get("method"), action.get("method"));
			Assert.assertEquals(expectedAction.get("href"), action.get("href"));
		}
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					com.clarityvisionsolutions.headless.kyc.dto.v1_0.
						AbbreviatedDistributorApp.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		AbbreviatedDistributorApp abbreviatedDistributorApp1,
		AbbreviatedDistributorApp abbreviatedDistributorApp2) {

		if (abbreviatedDistributorApp1 == abbreviatedDistributorApp2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("businessName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						abbreviatedDistributorApp1.getBusinessName(),
						abbreviatedDistributorApp2.getBusinessName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("erc", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						abbreviatedDistributorApp1.getErc(),
						abbreviatedDistributorApp2.getErc())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						abbreviatedDistributorApp1.getId(),
						abbreviatedDistributorApp2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("kycStatus", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						abbreviatedDistributorApp1.getKycStatus(),
						abbreviatedDistributorApp2.getKycStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("taxId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						abbreviatedDistributorApp1.getTaxId(),
						abbreviatedDistributorApp2.getTaxId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		if (clazz.getClassLoader() == null) {
			return new java.lang.reflect.Field[0];
		}

		return TransformUtil.transform(
			ReflectionUtil.getDeclaredFields(clazz),
			field -> {
				if (field.isSynthetic()) {
					return null;
				}

				return field;
			},
			java.lang.reflect.Field.class);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_abbreviatedDistributorAppResource instanceof
				EntityModelResource)) {

			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_abbreviatedDistributorAppResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		if (entityModel == null) {
			return Collections.emptyList();
		}

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		return TransformUtil.transform(
			getEntityFields(),
			entityField -> {
				if (!Objects.equals(entityField.getType(), type) ||
					ArrayUtil.contains(
						getIgnoredEntityFieldNames(), entityField.getName())) {

					return null;
				}

				return entityField;
			});
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		AbbreviatedDistributorApp abbreviatedDistributorApp) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("businessName")) {
			Object object = abbreviatedDistributorApp.getBusinessName();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("erc")) {
			Object object = abbreviatedDistributorApp.getErc();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("kycStatus")) {
			Object object = abbreviatedDistributorApp.getKycStatus();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		if (entityFieldName.equals("taxId")) {
			Object object = abbreviatedDistributorApp.getTaxId();

			String value = String.valueOf(object);

			if (operator.equals("contains")) {
				sb = new StringBundler();

				sb.append("contains(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 2)) {
					sb.append(value.substring(1, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else if (operator.equals("startswith")) {
				sb = new StringBundler();

				sb.append("startswith(");
				sb.append(entityFieldName);
				sb.append(",'");

				if ((object != null) && (value.length() > 1)) {
					sb.append(value.substring(0, value.length() - 1));
				}
				else {
					sb.append(value);
				}

				sb.append("')");
			}
			else {
				sb.append("'");
				sb.append(value);
				sb.append("'");
			}

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword(
			"test@liferay.com:" + PropsValues.DEFAULT_ADMIN_PASSWORD);

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected AbbreviatedDistributorApp randomAbbreviatedDistributorApp()
		throws Exception {

		return new AbbreviatedDistributorApp() {
			{
				businessName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				erc = StringUtil.toLowerCase(RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				kycStatus = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				taxId = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected AbbreviatedDistributorApp
			randomIrrelevantAbbreviatedDistributorApp()
		throws Exception {

		AbbreviatedDistributorApp randomIrrelevantAbbreviatedDistributorApp =
			randomAbbreviatedDistributorApp();

		return randomIrrelevantAbbreviatedDistributorApp;
	}

	protected AbbreviatedDistributorApp randomPatchAbbreviatedDistributorApp()
		throws Exception {

		return randomAbbreviatedDistributorApp();
	}

	protected AbbreviatedDistributorAppResource
		abbreviatedDistributorAppResource;
	protected com.liferay.portal.kernel.model.Group irrelevantGroup;
	protected com.liferay.portal.kernel.model.Company testCompany;
	protected com.liferay.portal.kernel.model.Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = source.getClass();

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					_getAllDeclaredFields(sourceClass)) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				try {
					Method setMethod = _getMethod(
						targetClass, field.getName(), "set",
						getMethod.getReturnType());

					setMethod.invoke(target, getMethod.invoke(source));
				}
				catch (Exception e) {
					continue;
				}
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static List<java.lang.reflect.Field> _getAllDeclaredFields(
			Class<?> clazz) {

			List<java.lang.reflect.Field> fields = new ArrayList<>();

			while ((clazz != null) && (clazz != Object.class)) {
				for (java.lang.reflect.Field field :
						clazz.getDeclaredFields()) {

					fields.add(field);
				}

				clazz = clazz.getSuperclass();
			}

			return fields;
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(
			BaseAbbreviatedDistributorAppResourceTestCase.class);

	private static Format _format;

	private com.liferay.portal.kernel.model.User _testCompanyAdminUser;

	@Inject
	private com.clarityvisionsolutions.headless.kyc.resource.v1_0.
		AbbreviatedDistributorAppResource _abbreviatedDistributorAppResource;

}