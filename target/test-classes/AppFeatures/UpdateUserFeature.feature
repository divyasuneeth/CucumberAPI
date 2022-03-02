Feature: Check Update User

Background:
Given user has to login with working endpoint 


Scenario: checking update end point
   When  user salary is set to 7777 
   And 	 user is updated with working endpoint
   Then  check salary is updated to 7777