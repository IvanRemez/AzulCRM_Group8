@UserStory_05
Feature: Upload files and pictures functionality
  User story:As a user, I should be able to upload files and pictures as messages.

  @UserStory_05_1
  Scenario Outline: Upload files and pictures functionality verification
    Given the user logged in as "<userType>"
    When user clicks on "message" option
#    Then user clicks on the "upload files" icon
#    And user Upload files a file "<filetype>" from their device
#    And user clicks on "in text" button insert the file
    Then user clicks on send button see the uploaded "<file name>" in the Activity Stream
    Examples:
      | userType  | filetype | file name                             |
      | hr        | jpeg     | sampleFile.jpeg                       |
      | helpdesk  | png      | Screenshot 2024-10-29 at 19.39.02.png |
      | hr        | pdf      | Test_Case_Writing_Tips.docx.pdf       |
      | marketing | txt      | testFile.txt                          |
      | marketing | docx     | Upload file functionality.docx        |
#      | marketing | jpeg     | sampleFile.jpeg                       |
#      | marketing | png      | Screenshot 2024-10-29 at 19.39.02.png |
#      | helpdesk  | pdf      | Test_Case_Writing_Tips.docx.pdf       |
#      | hr        | txt      | testFile.txt                          |
#      | hr        | docx     | Upload file functionality.docx        |


  @UserStory_05_2
  Scenario Outline: : Removes uploaded file or pictures before sending
    Given the user logged in as "<userType>"
    When user clicks on "message" option
#    Then user clicks on the "upload files" icon
#    And user Upload files a file "<filetype>" from their device
#    And user clicks on "in text" button insert the file
#    When user clicks Delete Icon with exact class "del-but"
#    Then user should not be able to see "<fileType>" in the uploaded files
    Examples:
      | userType  | filetype |
      | hr        | jpeg     |
      | helpdesk  | png      |
      | hr        | pdf      |
      | marketing | txt      |
      | marketing | docx     |
#      | marketing | jpeg     |
#      | marketing | png      |
#      | helpdesk  | pdf      |
#      | hr        | txt      |
#      | hr        | docx     |









