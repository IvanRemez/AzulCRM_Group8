@UserStory14
Feature: Company page functionality
  User story:As a user, I should be able to access to the Company page .

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: Company page verification
    Given the user logged in as "<userType>"
    When user navigates to the company page
    Then user see the following modules in the Company page:
      | Official Information |
      | Our Life             |
      | About Company        |
      | Photo Gallery        |
      | Video                |
      | Career               |
      | More                 |
      | Business News (RSS)  |
    Examples:
      | userType  |
      | hr        |
      | helpdesk |
      | marketing  |