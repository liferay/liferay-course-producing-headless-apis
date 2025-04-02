# Steps for the KYC Object for Distributor App

So the goal with this exercise is to create an object to hold the results of a KYC check. This will help us evaluate legitimate distributors versus potential fraudulent entities.

This object will be combined with others later on and populated later too, but we start by creating the object.

Steps in this exercise:

1. Log in as the admin and navigate to the Objects control panel.

2. Create a new object in the Distributor Management object folder with the following details:

|Name|Value|
|----|-----|
|Name|Distributor KYC Details|
|ERC|D4B8_DISTRIBUTOR_KYC_DETAILS|
|Scope|Company|
|Panel Link|Content|
|Entry Title Field|Business Name|
|Show Widget in Page Builder|Off|
|Enable Categorization of Object entries|Off|

3. Add the following fields to the object:

### BusinessVerification Object

| Name          | Type      | Description |
|---------------------|----------|-------------|
| Business Name     | Text     | The official name of the business. |
| Business Tax ID Number             | Text     | Employer Identification Number (EIN) of the business. |
| KYC Status           | Text     | Verification status (e.g., "Verified", "Pending", "Failed"). |
| Business Address | Text     | Official business address returned from Middesk. |
| Business Type    | Text     | Type of business entity (e.g., "LLC", "Corporation"). |
| Application State| Text     | State in which the business is registered. |
| KYC Response  | Long Text | Raw JSON response from KYC web service (for debugging/logging). |

4. Add the Distributor Application Relationship

In the Distributor Application object definition, go to the Relationships tab and add a new 1:many relationship, the Distributor Application is the 1, and the Distributor KYC Details is the many. The Label for the relationship would be *Application to KYC* and the name will be `applicationToKYC` and save the relationship.

Navigate to the Distributor KYC Details object definition to the Fields tab and rename the field to *Distributor Application* 

Once this is published, students can go to `/o/api` to the `c/distributorkycdetailses` application to review the headless API.

Isaac: Note that it seems to be a bug if the singular name is also a plural name, it generates a bad application name.

# Distributor KYC Update Client Extension

This is a client extension to introduce some business logic around the population of the new objects.

It has two entry points:

1. The Distributor App Object Action - This is intended to be invoked when a new Distributor App is submitted and, using an On After Add Object Action, invoke the CX microservice. The Microservice would invoke an external KYC service to get info about the possible fraudulent app submission and creates a new instance of the KYC object with the result.

2. The Distributor App Limited Detail Proxy - This is a microservice implementation to expose a subset of details from the distributor app and KYC detail to expose only necessary details.

Steps:

1. Explode the distributor-kyc-update.tar.gz file in the client-extensions folder (maybe we already have it exploded and just copy?).

2. Make sure the Liferay environment is running.

3. Using the command line, navigate into `client-extensions/distributor-kyc-update` directory and issue the command `blade gw deploy bootRun` (if deploy has already been completed, only the `blade gw bootRun` is necessary).

4. Log into Liferay as an admin, go to the Objects control panel, to the Distributor Application object, on the Actions tab and add a new Action. Set the label to `addDistributorKYCCheck`. On the Action Builder tab, set the Trigger to *On After Add*, and the Action Then to the `object-action-executor[function#clarity-distributor-kyc-update]` which is the deployed CX entry point. If this entry point is not available, it indicates that the CX was not properly deployed and student should re-attempt step 3. Save the new action.

5. With this, it is now possible to add a distributor application and log messages should detail what is going on in the CX and the end result is that a new KYC object will be added and joined to the object.