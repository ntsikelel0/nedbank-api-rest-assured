Feature: Universities - Wits Tests

  @wits @regression
  Scenario: Getting the value of state province for Wits
    When I send a GET request to "http://universities.hipolabs.com/search?country=South+Africa"
    Then The status code is 200
    And The state for wits is returned