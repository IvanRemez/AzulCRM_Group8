Feature: Poll Creation

  Scenario: Verify default delivery setting for poll
    Given the user is on the "Create Poll" page
    Then the delivery should be "All employees" by default

  Scenario: Verify the user can create a poll with questions and multiple answers
    Given the user is on the "Create Poll" page
    When the user adds a question with text "What is your favorite color?"
    And the user adds answers "Red", "Blue"
    And the user submits the poll
    Then the poll should be successfully created

  Scenario: Verify the user can select the "Allow multiple choice" checkbox
    Given the user is on the "Create Poll" page
    When the user adds a question with text "Choose your preferred languages"
    And the user adds answers "Java", "Python"
    And the user selects the "Allow multiple choice" option
    And the user submits the poll
    Then the poll should allow multiple choice selection

  Scenario: Verify error messages for mandatory fields
    Given the user is on the "Create Poll" page
    When the user tries to submit the poll without specifying a recipient
    Then an error message "Please specify at least one person." should be displayed

    When the user tries to submit the poll without a title
    Then an error message "The message title is not specified" should be displayed

    When the user adds a question without text and tries to save
    Then an error message "The question text is not specified." should be displayed

    When the user adds a question with no answers and tries to save
    Then an error message "The question 'What is your favorite fruit?' has no answers." should be displayed
