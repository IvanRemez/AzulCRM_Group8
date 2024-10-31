@UserStory_05
Feature: Upload files and pictures functionality
  User story:As a user, I should be able to upload files and pictures as messages.

  @UserStory_05_1
  Scenario Outline: Upload files and pictures functionality verification
    Given the user logged in as "<userType>"
    When user clicks on "message" option
#    When user clicks on message option
    Then user clicks on the upload files icon
    And user clicks on the Upload files and pictures button and selects a file "<filetype>" from their device
    And user clicks on in text button insert the file into the text
    Then user clicks on send button see the uploaded file or picture in the Activity Stream
    Examples:
      | userType  | filetype |
      | hr        | jpeg     |
      | helpdesk  | png      |
      | hr        | pdf      |
      | marketing | txt      |
      | marketing | docx     |
      | marketing | jpeg     |
      | marketing | png      |
      | helpdesk  | pdf      |
      | hr        | txt      |
      | hr        | docx     |

#  @UserStory_05_1
#  Scenario: Upload files and pictures functionality verification
#    When user clicks on "message" option
##    When user clicks on message option
#    Then user clicks on the upload files icon
#    And user clicks on the Upload files and pictures button and selects a file "/Users/zumrat/Desktop/Upload file functionality.docx" from their device
#    And user clicks on in text button insert the file into the text
#    Then user clicks on send button see the uploaded file or picture in the Activity Stream

  @UserStory_05_2
  Scenario Outline: : Removes uploaded file or pictures before sending
    Given the user logged in as "<userType>"
    When user clicks on "message" option
#    When user clicks on message option
    Then user clicks on the upload files icon
    And user clicks on the Upload files and pictures button and selects a file "<filetype>" from their device
    And user clicks on in text button insert the file into the text
    When the user clicks on the x button to remove the file
    Then the file is removed from the message composition area
    Examples:
      | userType  | filetype |
      | hr        | jpeg     |
      | marketing | jpeg     |
      | helpdesk  | png      |
      | marketing | png      |
      | hr        | pdf      |
      | helpdesk  | pdf      |
      | hr        | txt      |
      | marketing | txt      |
      | hr        | docx     |
      | marketing | docx     |









