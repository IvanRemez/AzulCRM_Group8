@Message
Feature: Sending messages in AzulCRM
  Agile Story: As a user, I should be able to send messages
  by clicking on Message tab in the Activity Stream


  @Scenario01
  Scenario Outline:  User sends a message successfully to All employees
    Given the user logged in as "<userType>"
    When the user clicks on the Message tab
    And fills in the message content with "Hello, Team!"
    And user should be able to sent to All employees by default
    Then the message should be sent to All employees by default
    Examples:
      | userType  |
      | hr        |
      | helpdesk |
      | marketing  |

  @Scenario02
  Scenario Outline:  User sends a message successfully to particular person
    Given the user logged in as "<userType>"
    When the user clicks on the Message tab
    And fills in the message content with "Hi there!"
    And user should be able to sent to recent person
    And user should be able to sent to Employees and Departments
    And user should be able to sent to email users
    Examples:
      | userType  |
      | hr        |
      | helpdesk |
      | marketing  |

  @Scenario03
  Scenario Outline: User submits a message with no recipient
    Given the user logged in as "<userType>"
    When the user clicks on the Message tab
    And fills in the message content with "Important Update"
    And selects no recipient
    Then the user should see the error message "Please specify at least one person."
    Examples:
      | userType  |
      | hr        |
      | helpdesk |
      | marketing  |

  @Scenario04
  Scenario Outline: User cancels sending a message
    Given the user logged in as "<userType>"
    When the user clicks on the Message tab
    And fills in the message content with "This is a test message."
    And decides to cancel the message
    Then the message should not be sent
    Examples:
      | userType  |
      | hr        |
      | helpdesk |
      | marketing  |

  #Scenario:  User sees option of attachment
   # Given user is logged in to AzulCRM
   # When the user clicks on the Message tab
   # And user is able to see option to Upload files
   # And user is able to see option to add Link
   # And user is able to see option to insert Video
   # And user is able to see option to quote text
 #   And user is able to see option to add Mention
  #  And user is able to see option to add Tag
   # And user is able to see option to Record Video

