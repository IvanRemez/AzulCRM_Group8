Feature: User Logout
  As a user, I should be able to log out of the application successfully.

  @logout
  Scenario: User logs out successfully
    Given the user is logged in on the homepage
    When the user clicks on the profile icon
    And the user selects "Log out" from the options
    Then the user should be logged out and redirected to the login page

  @logout
  Scenario: Options under profile menu
    Given the user is logged in on the homepage
    When the user clicks on the profile icon
    Then the user should see the following options:
      | My Profile                |
      | Edit Profile Settings     |
      | Themes                    |
      | Configure notifications   |
      | Log out                   |
