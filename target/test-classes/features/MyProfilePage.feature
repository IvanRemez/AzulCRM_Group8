Feature: My Profile page Functionality
  Agile story : As a user I want to access My Profile Page

  Background: User is logged in page.
    Given the user is logged in

  Scenario: Navigation to My Profile
    When user clicks on user block
    And  user clicks on My Profile
    Then User is on My Profile page

  Scenario: Tabs Verifications
    Given User is on My Profile page
    Then User sees the following tab options:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |







