Feature: Application login 

Scenario: HOme Web page default login
Given user is on netbanking landing page
When user logs in to  application with username "Vamshi"  password "1234"
Then homepage is populated
And cards are displayed
And testing done

Scenario: HOme Mobile page default login
Given user is on netbanking landing page
When user logs in to  application with username "OneVamshi"  password "4136"
Then homepage is populated
And cards are displayed
