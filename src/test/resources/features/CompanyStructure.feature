Feature: Company Structure Management
  As a user, I want to verify the visibility and functionality of the Company Structure for different user types.

  Scenario: Verify Company Structure visibility for all user types
    Given the user navigates to "https://qa.azulcrm.com/"
    When the user logs in as "HR"
    Then the "Company Structure" section should be visible
    When the user logs out
    When the user logs in as "Helpdesk"
    Then the "Company Structure" section should be visible
    When the user logs out
    When the user logs in as "Marketing"
    Then the "Company Structure" section should be visible

  Scenario: Verify HR user can add a department
    Given the user navigates to "https://qa.azulcrm.com/"
    When the user logs in as "HR"
    Then the "ADD DEPARTMENT" button should be displayed
    When the user clicks the "ADD DEPARTMENT" button
    And enters "New Department" in the department name field
    Then the department "New Department" should be added successfully

  Scenario: Verify “ADD DEPARTMENT” button visibility for Helpdesk and Marketing users
    Given the user navigates to "https://qa.azulcrm.com/"
    When the user logs in as "Helpdesk"
    Then the "ADD DEPARTMENT" button should not be displayed
    When the user logs out
    When the user logs in as "Marketing"
    Then the "ADD DEPARTMENT" button should not be displayed
