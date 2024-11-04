Feature: Modules in the Employees page and the Company Structure by default

  User Story: User should see following 8 modules in the
  Employees page and see the Company Structure by default

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: 8 modules in the Employees page Verification
    Given User logged in as "<userType>"
    And User on the Base Page
    When User sees Employees page button
    And User clicks Employees page button
    Then User sees following eight modules in the Employees page:
      | Company Structure   |
      | Find Employee       |
      | Telephone Directory |
      | Staff Changes       |
      | Efficiency Report   |
      | Honored Employees   |
      | Birthdays           |
      | New page            |

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Viewing the Company Structure by default by clicking the Employees page Verification
    Given User logged in as "<userType>"
    And User on the Base Page
    When User sees Employees page button
    And  User clicks Employees page button
    Then User sees the Company Structure by default

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


