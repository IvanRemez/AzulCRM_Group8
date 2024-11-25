Feature: Send message functionality
  As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  @userStory4-1
  Scenario Outline: Verify that the user can send a message by filling in the mandatory fields.
    Given the user logged in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks on "message" tab
    And user enter "message" into the textBox
    When user clicks Send button
    Then user should be able to see message which is sent
    Examples:
      | userType |
      | hr       |
#      | helpdesk  |
#      | marketing |
  @userStory4-2
  Scenario Outline: verify that user can not send a message without  filling  Message title
    Given the user logged in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks on "message" tab
    When user clicks Send button
    Then user should see error message that "The message title is not specified"
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |
    @userStory4-3
    Scenario Outline: Verify that user can not send a message without  filling  recipient
    Given the user logged in as "<userType>"
    And user clicks "Activity Stream"
      And user clicks on "message" tab
      Then user cancel default option All employees from delivery box
      When user clicks Send button
      Then user should see error message that "Please specify at least one person."
      Examples:
        | userType  |
        | hr        |
        | helpdesk  |
        | marketing |
  @userStory4-4
  Scenario Outline: Verify that the message delivery is to 'All employees' by default.
    Given the user logged in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks on "message" tab
    Then user should be able to see the message delivery is to "All employees" by default
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |
    @userStory4-5
    Scenario Outline: Verify that user can cancel sending message at any time before sending.
    Given the user logged in as "<userType>"
      And user clicks "Activity Stream"
      And user clicks on "message" tab
      Then user enter "message" into the textBox
      When user clicks Cancel button
      Then user should see the "Send message …" default box
      Examples:
        | userType  |
        | hr        |
        | helpdesk  |
        | marketing |


