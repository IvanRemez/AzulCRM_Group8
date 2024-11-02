Feature: My Profile page Functionality
  Agile story : As a user I want to access My Profile Page

  Background: User is already in the log in page
    Given the user logged in as "helpdesk"

  Scenario : User Navigates to MyProfile
    When user clicks on user block
    And user clicks on My Profile
    Then User is on My Profile page


  Scenario: Profile Tab Options Verification
    When User views the general tab menu
    Then User sees the following tab options:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |







