Feature: Logout functionality for authenticated users

  # As a user, I should be able to log out

  @logout
  Scenario: User successfully logs out of the application
    Given the user is logged into the application
    When the user clicks on the profile icon
    And the user selects the "Log out" option
    Then the user should be logged out of the application
    And the user should see the login screen

  @profile_options
  Scenario: User sees options under profile dropdown
    Given the user is logged into the application
    When the user clicks on the profile icon
    Then the user should see the following options under the profile:
      | Option                   |
      | My Profile               |
      | Edit Profile Settings    |
      | Themes                   |
      | Configure notifications  |
      | Log out                  |