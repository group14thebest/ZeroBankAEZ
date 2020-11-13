@login
Feature: Login

  As user I want to be able to login

  Background: common steps
    Given the user on the login page

  Scenario: Login as a user
    When the user logs in with user credentials
    Then Account summary page is displayed
