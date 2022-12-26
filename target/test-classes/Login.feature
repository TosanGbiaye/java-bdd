Feature: User Type Login
  As a user
  I should be able to login
  and gain access based on my user permissions

  Scenario Outline: A <user> is able to access the page based on <permission>
    When I insert the "<user>"
    And I insert the password
    And I click the login button
    Then I should have access based on my "<permission>"

    Examples:
      | user                    | permission |
      | standard_user           | success    |
      | problem_user            | distorted  |
      | performance_glitch_user | success    |
      | locked_out_user         | error      |

