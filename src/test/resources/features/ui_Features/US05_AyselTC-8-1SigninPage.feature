Feature: US 05
  Background: User go to Signin Page

    Given user(patient) navigate to 'Medunna' homepage
    Then user(patient) navigate to icon, verify it is seen,clickable and click the icon
    Then user(patient) click on Signin button


  @UIappointment
  Scenario Outline:  Test01: Signing In

    And   user(patient) verify drop table is visible
    Then  user (patient) verify username textbox is blank
    And   user(patient) click and write their "<username>"
    And   user (patient) verify username textbox is not blank
    Then  user (patient) verify password textbox is blank
    And   user(patient) click and enter their "<password>"
    And   user (patient) verify password textbox is not empty
    And   user(patient) press Signin button
   # Then  user (patient) confirm Username cannot be empty!




    Examples:
    |username|password|
    |Tyt23       |Tyt23.  |