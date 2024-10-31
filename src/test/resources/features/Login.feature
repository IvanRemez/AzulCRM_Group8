@Login
Feature: Users should have full access to all Login page features and be able to login

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: Verify login with different user types
#    Parameterized option:
#    Given the user logged in with username as "User1" and password as "UserUser123"
    Given the user logged in as "<userType>"
    Then user lands on homepage
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  Scenario Outline: Verify error message with invalid credentials
    Given user logs in with "<username>" and "<password>"
    Then "Incorrect login or password" error is displayed
    Examples:
      | username              | password        |
      | hr11@cydeo.com        | invalidPassword |
      | helpdesk11@cydeo.com  | invalidPassword |
      | marketing11@cydeo.com | invalidPassword |
      | invalidUsername       | UserUser        |

  Scenario: Verify "Remember me" checkbox
    Then user can see and interact with checkbox

  Scenario: Verify "Forgot password" link
    Then user can see and interact with link

  @wip
  Scenario: Verify password is hidden
    Then password field input is hidden