@Test_Frontend
Feature: Test scenario for movie search functionality

  Scenario: Filter response to keep only movies with titles
    Given I want to set API host "http://www.omdbapi.com/"
    Then I want to set API parameter with host
      | parameter | value             |
      | apikey    | cb70d73a          |
      | type      | movie             |
      | s         | lord of the rings |
    Then Filter titles from response for all movie
    

  Scenario: Validate Response Data with UI search
    Then Navigate to "https://www.imdb.com/" page
