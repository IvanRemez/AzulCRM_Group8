Feature: My Profile page Functionality
  Agile story : As a user I want to access My Profile Page

  Background: User logs in.
    Given User log in

  Scenario: Profile Options Verification
    Given User is on the My Profile page
    When User views the general tab menu
    Then User sees the following tab options:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |









