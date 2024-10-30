Feature: My Profile page Functionality
  Agile story : As a user I want to access My Profile Page

  Background: User is logged in page.
    Given User log in

  Scenario: Profile Tab Options Verification
    When User clicks on user block
    And  User clicks my profile
    Then User sees the following tab options on General:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |







