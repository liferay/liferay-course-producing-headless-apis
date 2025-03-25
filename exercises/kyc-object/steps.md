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

Once this is published, students can go to `/o/api` to the `c/distributorkycdetailses` application to review the headless API.

Isaac: Note that it seems to be a bug if the singular name is also a plural name, it generates a bad application name.