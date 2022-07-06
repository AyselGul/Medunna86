Feature: Testing the Appiontment data

@APIAppoinment
  Scenario:  TC 01 Appoinment

    Given user(patient) send get Request for their data
    Then user(patient) deserialize their data jo Java
    And user(patient) save the data to related file and validate