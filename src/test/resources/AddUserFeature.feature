

Feature: Test AddUser API
 
 Background:
 Given user has to login with working endpoint 

 
  Scenario: checking add user end point
 		When 	user data is populated
 		When 	user added with working endpoint 
    Then check last added record is the user
    
 
     

  
  