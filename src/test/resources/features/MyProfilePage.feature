Feature: My Profile page Functionality
  Agile story : As a user I want to access My Profile Page

  Background: User Navigates .
    Given the user is logged in

  Scenario: Navigation to My Profile
    When user clicks on user block
    And  user clicks on My Profile
    Then user sees the following tab options:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |

    Scenario: Email Verification












