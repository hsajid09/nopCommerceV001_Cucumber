Feature: Customer

@tag1
Scenario: Add new Customers
Given User Launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then User can view Dashboard
When User click on customer menu
And click on customer menu Item
And click on Add new button
Then user can view Add new customer page
When user enters cutomer info
And click on Save button
Then User can view confirmation page "The new customer has been added sucessfylly"
And close browser

@tag2
Scenario: Search Customer by EMailID
Given User Launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then User can view Dashboard
When User click on customer menu
And click on customer menu Item
And enter Customer EMail
When Click on search button 
Then User should found Email int he search table
And close browser





