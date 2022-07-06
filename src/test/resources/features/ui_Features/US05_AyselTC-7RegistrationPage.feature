Feature: US 05
  Background: User go to Registration Page

    Given user(patient) navigate to 'Medunna' homepage
    Then user(patient) navigate to icon, verify it is seen,clickable and click the icon
    Then user(patient) click on Register button
    #Given user(patient) navigate to 'Medunna Registration' homepage
    Then user(patient) verify the text 'Registration'is visible


  @UIappointment
  Scenario Outline:  Test01: Make Registration

    And   user(patient) verify RegSSN textbox is blank
   Then  user (patient) click RegSSN textbox and enter "<RegSSN>"
    And   user(patient) verify used dash after the third and fifth digits
    And   user (patient) verify RegSSN textbox is not blank
    And   user(patient) verify RegFirst name textbox is empty
    Then  user (patient) click RegFirst name textbox and enter their "<RegFirstname>"
    Then  user(patient) verify RegFirst name textbox is full
    And user(patient) verify RegLast name textbos is clear
    Then  user (patient) click RegLastname textbox and enter their "<RegLastname>"
    Then user(patient) verify RegLastname textbox is filled
    And   user(patient) verify Regusername textbox is epmty
    Then  user (patient) click Regusername textbox and write "<Regusername>"
    And   user (patient) verify Regusername textbox is filled
    And   user(patient) verify Regemail textbox is empty
    Then  user (patient) click Regemail textbox and enter their "<Regemail>"
    Then  user(patient) verify that @ and . sign are used in Regemail
    Then  user(patient) verify Regemail textbox is not clear
    And user(patient) verify RegNewpassword textbos is clear
    Then  user (patient) click RegNewpassword textbox and enter their "<RegNewpassword>"
    And   user(patient) verify RegNewpassword textbox is filled
    Then user(patient) verify RegNewpassword confirmation textbox is empty
    Then  user (patient) click RegNewpassword confirmation  textbox and enter their "<RegNewpassword confirmation>" password
    And   user(patient) verify RegNewpassword confirmation number is provided
    Then  user(patient) click on Registration button
    And  user(patient) verify Registration saved text is seen
    And user(patient) register and save the provided data



    Examples:
    |RegSSN|RegFirstname|RegLastname|Regusername|Regemail|RegNewpassword|RegNewpassword confirmation|
<<<<<<<< HEAD:src/test/resources/features/ui_Features/US05_AyselTC-7RegistrationPage.feature
    | 100-23-0942     |Mars      |jupiter.     |MamC      |mars@gmail.com|Mars72? |Mars72? |
========
<<<<<<< HEAD:target/test-classes/features/uiFeatures/US-05_AyselTC-7RegistrationPage.feature
    | 140-53-2345     |Mehmet      |Khann      |Meh-7      |edkhlr@gmail.com|Meh72- |Meh72- |
=======
    | 190-53-7860     |Mehmet      |Khann      |Meh-7      |khnnn@gmail.com|Meh72? |Meh72? |
>>>>>>> c46f3be229b5521e027397a386524e6c25e30299:target/test-classes/features/UIFeatures/US-05_AyselTC-7RegistrationPage.feature
>>>>>>>> master:target/test-classes/features/uiFeatures/US-05_AyselTC-7RegistrationPage.feature

