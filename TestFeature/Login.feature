@tag
 Feature: Login

@tag1
 Scenario: Sucessful Login with valid credentials
Given User Launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out Link 
Then Page Title should be "Your store.Login"
And close browser

@tag2
 Scenario: Login Data Driven Test
Given User Launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on Log out Link 
Then Page Title should be "Your store.Login"
And close browser