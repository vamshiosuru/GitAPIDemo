Feature: Validating place API

@AddPlace @Regression
Scenario Outline: Verify Addplace API

Given Add place payload with "<name>"  "<language>" "<address>"
When user hits "Addplace" API payload with "POST" http request
Then API call is success with http status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created mapping to "<name>" using  "GetPlace"

Examples:
|name    |language  |address       |
|Hyderabad |Telugu  |India|
 # |Medak|Kannada|Chennai|
 
 @deletePlace
 Scenario: Verify Deleteplace API
 
 Given deleteplacepayload
 When user hits "DeletePlace" API payload with "POST" http request
Then API call is success with http status code 200
And "status" in response body is "OK"