Feature: AngularJs Internal Link validation
  I want to use this template for my feature file
  
  Background:
  
    Given I have landed  on developer documentaion 

  @Tc-001
  Scenario: Internal link validation
    And I have all the internal links available from the page
    Then I should get response code of each link as TwoHundred 
    And For each link page should be loaded and angular should be initialized
    
    
   

