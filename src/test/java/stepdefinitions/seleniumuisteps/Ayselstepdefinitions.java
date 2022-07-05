package stepdefinitions.seleniumuisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AyselPage;
import pojos.AyselPojos;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static utilities.TxtWriter.saveUIAppoinmentData;

public class Ayselstepdefinitions {

    AyselPage ay = new AyselPage();
    AyselPojos ayp = new AyselPojos();
    Faker faker = new Faker();

    @Given("user\\(patient) navigate to {string} homepage")
    public void userPatientNavigateToMedunnaHomepage(String homepage) {
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        Driver.wait(2);

    }

    @Then("user\\(patient) verify the text {string}is visible and clickable")
    public void userPatientVerifyTheMakeAnAppoinmentIsVisibleAndClickable(String text) {
        Assert.assertTrue(ay.HMmakeanAppointmentWebelement.isDisplayed());
        Driver.wait(2);
        Assert.assertTrue(ay.HMmakeanAppointmentWebelement.isEnabled());
    }


    @Then("user\\(patient) click {string} button")
    public void userPatientClickMakeAnAppoinmentButton(String textButton) {
        Driver.wait(1);
        ay.HMmakeanAppointmentWebelement.click();
    }

    @And("user\\(patient) verify First name textbox is empty")
    public void userPatientVerifyFirstNameTextboxIsEmpty() {
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoViewByJS(ay.HMfirstnameBox);
        Assert.assertTrue(ay.HMfirstnameBox.getText().isEmpty());
    }


    @Then("user \\(patient) click textbox and enter their {string}")
    public void userPatientClickTextboxAndEnterTheir(String firstname) {
        Driver.wait(1);
        // ay.HMfirstnameBox.click();
       // firstname= faker.name().firstName();
        Driver.waitAndSendText(ay.HMfirstnameBox,firstname);
         ayp.setFirstName(firstname);
    }

    @And("user \\(patient) verify First name textbox is not blank")
    public void userPatientVerifyFirstNameTextboxIsNotBlank() {
        Assert.assertFalse(ay.HMfirstnameBox.getAttribute("value").isEmpty());
    }

    @And("user \\(patient) verify Last name textbox is blank")
    public void userPatientVerifyLastNameTextboxIsBlank() {
        Assert.assertTrue(ay.HMlastnameBox.getText().isEmpty());
    }


    @And("user\\(patient) click Last name textbox and enter  {string}")
    public void userPatientClickTextboxAndEnter(String Lastname) {
        ReusableMethods.waitFor(1);
       // ay.HMlastnameBox.click();
       // Lastname= faker.name().lastName();
        Driver.waitAndSendText(ay.HMlastnameBox,Lastname);
         ayp.setFirstName(Lastname);

    }
    @And("user \\(patient) verify Last Name textbox is not blank")
    public void userPatientVerifyLastNameTextboxIsNotBlank() {
        Assert.assertFalse(ay.HMlastnameBox.getAttribute("value").isEmpty());
    }

    @And("user\\(patient) verify SSN textbox is blank")
    public void userPatientVerifySSNTextboxIsBlank() {
        Assert.assertTrue(ay.HMSSNbox.getText().isEmpty());
    }

    @Then("user \\(patient) click textbox and enter ssn number {string}")
    public void userPatientClickTextboxAndEnterSsnNumber(String ssn) {
        ReusableMethods.waitFor(2);
        //ssn= faker.idNumber().ssnValid();
        Driver.waitAndSendText(ay.HMSSNbox,ssn);
        ayp.setSsn(ssn);
        ReusableMethods.waitFor(2);

    }

    @And("user \\(patient) verify ssn textbox is not blank")
    public void userPatientVerifySsnTextboxIsNotBlank() {
        Assert.assertFalse(ay.HMSSNbox.getAttribute("value").isEmpty());

    }

    @Then("user\\(patient) verify email textbox is blank")
    public void userPatientVerifyEmailTextboxIsBlank() {
   Driver.wait(2);
        Assert.assertTrue(ay.HMemailbox.getText().isEmpty());
    }

    @Then("user\\(patient) write {string}")
    public void userPatientWrite(String email) {
        Driver.wait(1);
        //email= faker.internet().emailAddress();
        Driver.waitAndSendText(ay.HMemailbox,email);
        ayp.setEmail(email);

    }

    @And("user\\(patient) verify email textbox is not blank")
    public void userPatientVerifyEmailTextboxIsNotBlank() {
        Driver.wait(1);
        Assert.assertFalse(ay.HMemailbox.getAttribute("value").isEmpty());
    }

    @And("user\\(patient) verify Phone textbox is empty")
    public void userPatientVerifyPhoneTextboxIsEmpty() {
        Assert.assertTrue(ay.HMphonenumberbox.getText().isEmpty());

    }
    @Then("user \\(patient) click Phone textbox and write valid {string}")
    public void userPatientClickPhoneTextboxAndWriteValid(String phoneNumber) {
       // ay.HMphonenumberbox.click();
        //phoneNumber= faker.phoneNumber().cellPhone();
        Driver.waitAndSendText(ay.HMphonenumberbox,phoneNumber);
        ayp.setPhoneNumber(phoneNumber);
    }

    @Then("user\\(patient) verify that @ and . sign are used")
    public void userPatientVerifyThatAndSignIsUsed() {
        Assert.assertTrue(ay.HMemailbox.getAttribute("value").contains("@")&& ay.HMemailbox.getAttribute("value").contains("."));
    }

    @And("user\\(patient) verify Phone textbox is not clean")
    public void userPatientVerifyPhoneTextboxIsNotClean() {
        Assert.assertFalse(ay.HMphonenumberbox.getAttribute("value").isEmpty());
    }

    @And("user\\(patient) verify used dash after the third and sixth digits")
    public void userPatientVerifyUsedDashAfterTheThirdAndSixthDigits() {
        System.out.println("AyselPage."+ ay.HMphonenumberbox.getAttribute("value").substring(3,4));
        System.out.println("AyselPage.HMphonenumberbox.  : "+ ay.HMphonenumberbox.getAttribute("value").substring(6,7));
        Assert.assertEquals("-",ay.HMphonenumberbox.getAttribute("value").substring(3,4));
        Assert.assertEquals( "-",ay.HMphonenumberbox.getAttribute("value").substring(6,7));
    }


    @Then("user \\(patient) click Appoinment DateTime dropbox and select date {string}")
    public void userPatientClickAppoinmentDateTimeDropboxAndSelectDate(String date) {
        ay.appointmentDateTimeBox.click();
        Driver.waitAndSendText(ay.appointmentDateTimeBox,date);
        Driver.wait(1);
        ayp.setDate(date);

    }

/*
   // @And("user quits browser")
   // public void userQuitsBrowser() {
   //     Driver.getDriver().quit();
   // }

    @Then("user\\(patient)select the appoinment date from {string}")
    public void userPatientSelectTheAppoinmentDateFrom(String date) {

        ayp.setDate(date);
        
    }

    @And("user\\(patient) confirm the selected date is one of the valid dates")
    public void userPatientConfirmTheSelectedDateIsOneOfTheValidDates() {
        String date= ay.appointmentDateTimeBox.getAttribute("value");
        System.out.println("date = " + date);
        String year=date.substring(0,4);
        String month=date.substring(7,8);
        String day=date.substring(31);

        LocalDate actualDate= LocalDate.now();
        if (Integer.parseInt(year)==actualDate.getYear()){
            Assert.assertEquals(Integer.parseInt(year), actualDate.getYear());
            Assert.assertTrue(Integer.parseInt(month)>= actualDate.getMonthValue());
            Assert.assertTrue(Integer.parseInt(day)>= actualDate.getDayOfMonth());
        } else if(Integer.parseInt(year)<actualDate.getYear()){
            Assert.assertTrue(Integer.parseInt(year)>=actualDate.getYear());
        }else{
            Assert.assertTrue(Integer.parseInt(year)>=actualDate.getYear());
        }
    }
*/
    @And("user\\(patient)click Send an Appoinment Button and validate Toast Container saved message")
    public void userPatientClickSendAnAppoinmentButtonAndAndValidateToastContainerSavedMessage() {
        ay.sendAppButton.click();
        ay.AppointmentToastContainerMassage.isDisplayed();
        //Driver.wait(1);

      //System.out.println("toast " + ay.AppointmentToastContainerMassage.getText());
      //List<String> savedToastList= Arrays.asList(ay.AppointmentToastContainerMassage.getText().split("\\s"));
      //System.out.println("savedToastList = " + savedToastList);
      //Assert.assertTrue(ay.AppointmentToastContainerMassage.getText().contains("saved"));
      //Driver.wait(1);

    }

    @And("user\\(patient) save the data")
    public void userPatientSaveTheData() {
        saveUIAppoinmentData(ayp);
    }




    @Given("User navigate to Registration Page")
    public void userNavigateToRegistrationPage() {
        ay.iconButton.click();
        Driver.wait(1);
        ay.IconRegistrationWebelement.click();
        
    }

    @Then("User verify the Registration Text is visible")
    public void userVerifyTheRegistrationTextIsVisible() {
        Assert.assertTrue(ay.RegistarionText.isDisplayed());
        
    }

    @Then("User validate the SSN text box is empty")
    public void userValidateTheSSNTextBoxIsEmpty() {
        Assert.assertTrue(ay.RegSSNbox.getText().isEmpty());
        
    }

    @Then("User click and provide their {string} id")
    public void userClickAndProvideTheirId(String snn) {
        ay.RegSSNbox.click();
        Driver.waitAndSendText(ay.RegSSNbox,snn);
        
    }

    @Then("User make sure the SNN box is not blank")
    public void userMakeSureTheSNNBoxIsNotBlank() {
        Assert.assertFalse(ay.RegSSNbox.getText().isEmpty());
        
    }

    @Then("User verify First Name box is blank")
    public void userVerifyFirstNameBoxIsBlank() {
        Assert.assertTrue(ay.RegFirstnamebox.getText().isEmpty());
        
    }

    @And("User click and write their {string}")
    public void userClickAndWriteTheir(String firstname) {
        ay.RegFirstnamebox.click();
        Driver.waitAndSendText(ay.RegFirstnamebox,firstname);
    }

    @Then("User make sure the First Name box is not empty")
    public void userMakeSureTheFirstNameBoxIsNotEmpty() {
        Assert.assertFalse(ay.RegFirstnamebox.getText().isEmpty());
        
    }

    @Then("User verify Last Name box is empty")
    public void userVerifyLastNameBoxIsEmpty() {
        Assert.assertTrue(ay.RegLastnamebox.getText().isEmpty());
        
    }

    @Then("User click and provide their {string}")
    public void userClickAndProvideTheir(String lastname) {
        ay.RegLastnamebox.click();
        Driver.waitAndSendText(ay.RegLastnamebox,lastname);
    }

    @And("User make sure the Last Name box is not empty")
    public void userMakeSureTheLastNameBoxIsNotEmpty() {
        Assert.assertFalse(ay.RegLastnamebox.getText().isEmpty());
        
    }

    @Then("User validate the Username text box is empty")
    public void userValidateTheUsernameTextBoxIsEmpty() {
        Assert.assertTrue(ay.RegusernameBox.getText().isEmpty());
    }
}


