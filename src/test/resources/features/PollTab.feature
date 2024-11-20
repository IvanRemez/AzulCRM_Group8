Feature: Poll Creation and Validation

  Background:
    Given the user is on the poll creation page

  Scenario: Verify default delivery is 'All employees'
    Given the user is logged into the application
    When the user navigates to the "Poll" module
    Then the default delivery recipient is "All employees"

  Scenario: Creating a poll with multiple questions and answers
    When the user adds a question "What is your favorite color?"
    And adds the following answers to the question:
      | Red   |
      | Blue  |
      | Green |
    And the user adds another question "Which department do you work in?"
    And adds the following answers to the question:
      | Marketing |
      | Sales     |
      | IT        |
    Then the poll should contain 2 questions with their respective answers

  Scenario: Allowing multiple choice selection
    When the user adds a question "Select your preferred work days"
    And adds the following answers to the question:
      | Monday    |
      | Wednesday |
      | Friday    |
    And the user checks the "Allow multiple choice" checkbox for the question
    Then the question should allow multiple answer selection

  Scenario Outline: Validation of mandatory fields
    When the user attempts to create a poll without specifying the <missing_field>
    Then an error message "<error_message>" should be displayed

    Examples:
      | missing_field | error_message                                    |
      | message title | The message title is not specified               |
      | recipient     | Please specify at least one person.              |
      | question      | The question text is not specified.              |
      | answer        | The question "<question_text>" has no answers.   |

  Scenario: Validation of question without answers
    When the user adds a question "What is your role?"
    And attempts to create the poll without adding any answers
    Then an error message "The question "What is your role?" has no answers." should be displayed