# Clarity KYC Proxy

This project demonstrates how to use RESTBuilder to create a new headless API.

# Steps:

1. Using the command line, navigate to the `modules` folder and then use the command `blade create -t rest-builder -p com.clarityvisionsolutions.headless.kyc clarity-kyc-proxy` to create the project.

2. Copy the yaml files from the exercises folder into the `modules/clarity-kyc-proxy/clarity-kyc-proxy-impl` folder.

3. Navigate to the `modules/clarity-kyc-proxy/clarity-kyc-proxy-impl` folder and issue the command `blade gw buildRest` to generate the initial files.

4. Copy the `AbbreviatedDistributorAppResourceImpl.java` file from the exercises folder to the `modules/clarity-kyc-proxy/clarity-kyc-proxy-impl/src/main/java/com/clarityvisionsolutions/headless/kyc/internal/resource/v1_0` directory.

5. Use the `blade gw build deploy` in the -api and -impl directories to deploy to Liferay.

6. Use the API Explorer to investigate the new Clarity KYC Proxy application.

7. Get an ID for a Distributor Application and use it to invoke the proxy API. Check the result object JSON to see the partial object.
