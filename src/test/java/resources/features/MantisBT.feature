Feature: Order Task to user
  Scenario: MyScenario for ordering the task to user
    Given Log in as "administrator"
    And Open create Task page
    And Create Task using info from "task_1"
    And Check that "task_1" was created
    And Order "task_1" to user "user_1"
    And Log out
    And Log in as "user_1"
    Then I should see that "task_1" was rightly ordered
