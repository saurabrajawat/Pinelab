@Test_Frontend @Regression
Feature: Test scenario for checkout functionality

  Scenario: Filter response to keep only movies with titles
    Given I want to set API host "http://www.omdbapi.com/"
    Then I want to set API parameter with host
      | parameter | value             |
      | apikey    | cb70d73a          |
      | type      | movie             |
      | s         | lord of the rings |
    Then Filter titles from response for all movie

  @TC-01
  Scenario: Validate checkout functionality for 3rd number product
    Then Navigate to "http://pluraltestmerchant.com.s3-website.ap-south-1.amazonaws.com/" page
    Then Click on play with plural for 3rd prodcut
    Then Enter merchant data with below details
      | merchantId | merchantAccessCode                   | merchantReturnUrl                    |
      | 3413       | 1c295f88-4477-4cd3-b5ac-e76148545a3e | http://localhost:53132/charging.aspx |
    Then Click on payment info bar
    And Enter amount info with below details
      | amount | currencyCode | orderDescription |
      | 10000  | INR          | Testing          |
    Then Click on customer info bar
    And Enter customer info with below details
      | email                 | mobileNumber |
      | saurab@mailinator.com | 8591650982   |
    Then Click on billing address info bar
    And Enter billing address info with below details
      | firstName | lastName | address1  | address2 | address3 | pincode  | city  | state         | country |
      | ranjeet   | kumar    | sector-62 | noida    | noida    | 201301   | noida | uttar pradesh | india   |
    Then Click on product info bar
    And Enter product info with below details
      | productCode | productAmount | 
      |  40         |   10000       |
    And Click on submit button
