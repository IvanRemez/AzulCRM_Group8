Feature: My Profile page Functionality
  Agile story : As a user I want to access My Profile Page

  Background: User log in
    Given User is login in homepage

  @Profile
  Scenario: Profile Options Verification
    When user clicks on User Block
    And clicks on My Profile
    Then user sees the following general options tabs:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |

    Scenario: Email Verification display
      When user lands on Profile Page
      Then user sees email address under the General tab







