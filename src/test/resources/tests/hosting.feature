Feature: Hosting Auto Installer

  Background: User is Logged In
    Given User is on the login page
    When User enter email and password
    And User click on the login button
    Then login success and profile menu should be displayed

  Scenario: Install WordPress Application
    Given User is on the manage hosting page
    When User navigate to auto installer page
    And User select "WordPress" auto-installer
    And User enter site title and admin password
    And User click on the button next and install
    Then "WordPress" installation success

  Scenario: Delete WordPress Application
    Given User is on the manage hosting page
    When User navigate to auto installer page
    And User click on the button "Delete" from installed application action menu
    And User select data to delete and confirm
    Then Uninstall application success
