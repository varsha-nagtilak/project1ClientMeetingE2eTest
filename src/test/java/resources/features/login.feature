Feature: Login to application
Scenario: Existing user should able to login
Given the user is on login page
When the user enters the login detais and click on the Login button
Then user should redirect to home page
