Feature: Attach and Navigate Links
  As a user, I want to attach a link to specified text, verify the link works, and ensure it opens in a new tab.

  Scenario: Verify user can attach and navigate links
    Given the user is on the "Edit Page" of the application
    When the user attaches a link with URL "https://qa.azulcrm.com/" to the text "Click Here"
    Then the link should be attached to the text "Click Here"
    When the user clicks on the link "Click Here"
    Then the user should be navigated to "https://qa.azulcrm.com/" in a new tab
