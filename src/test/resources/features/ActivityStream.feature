@ActivityStream
Feature: Activity Stream Page Options
  User story: As a user, I should be able to see all the options on the Activity stream page.

  Background: User is on the main homepage.

  Scenario: Activity Stream Page Verification
  @Given ("The user logged in with username as {"helpdesk1@cydeo.com"} and password as {UserUser}")
    When User navigates to the activity stream page
    Then User sees the following options:
      | Message                  |
      | Task                     |
      | Event                    |
      | Polls                    |
      | More                     |


  @MoreOptions
  Scenario: More Options Verification
  @Given ("The user logged in with username as {"helpdesk1@cydeo.com"} and password as {UserUser}")
    When User navigates to the activity stream page
    Then User sees the following options under the More tab:
      | File                      |
      | Appreciation              |
      | Announcement              |
      | Workflow                  |





