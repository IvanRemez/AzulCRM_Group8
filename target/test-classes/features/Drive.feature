@UserStory_13
Feature: My Drive page functionality
  User story: As a user, I want to access the Drive page to view different document categories.

  Background: User logs in and accesses drive page
    Given the user goes on the Drive tab

  Scenario: Accessing the Drive page and viewing document categories
    Given the user logged in with username as {string} and password as {string}
    When User navigates to the Drive page
    Then User sees the following options under the More tab::

      | My Drive                    |
      | All Documents               |
      | Company Drive               |
      | Sales and Marketing         |
      | Top Management’s documents  |
      | Drive cleanup               |
