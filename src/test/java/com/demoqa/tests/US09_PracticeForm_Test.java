package com.demoqa.tests;


import com.demoqa.pages.US09_PracticeForm_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class US09_PracticeForm_Test {
    public US09_PracticeForm_Page us09PracticeFormPage;
    Actions action = new Actions(Driver.getDriver());


    @Test(priority = 1)
    public void setup() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        us09PracticeFormPage = new US09_PracticeForm_Page();
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us09PracticeFormPage.formsButton.click();

    }

    @Test(priority = 2, dependsOnMethods = "setup")
    //Forms altindaki Practice Form sayfasina ulasilabilmelidir.
    public void TC0936() {
        Assert.assertTrue(us09PracticeFormPage.practiceFormButton.isEnabled());
    }

    @Test(priority = 3, dependsOnMethods = "setup")
   /* Student Registration Formdaki  Name,  Gender, Date of Birth, Mobile bolumleri bos birakildiginda
    Submit yapilamadigini dogrulayin*/

    public void TC0937() {
        us09PracticeFormPage.practiceFormButton.click();
        ReusableMethods.waitFor(2);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        //ReusableMethods.waitForClickablility(us09PracticeFormPage.submit, 10);
        us09PracticeFormPage.submit.click();
        ReusableMethods.waitFor(1);
        String expectedColor = "#dc3545";
        String firstNameBorderColor = us09PracticeFormPage.firstName.getCssValue("border-color");
        System.out.println("firstNameBorderColor = " + firstNameBorderColor);
        String firstNameHexColor = Color.fromString(firstNameBorderColor).asHex();
        System.out.println("firstNameHexColor = " + firstNameHexColor);
        String lastNameBorderColor = us09PracticeFormPage.lastName.getCssValue("border-color");
        String lastnameHexColor = Color.fromString(lastNameBorderColor).asHex();

        ReusableMethods.waitFor(2);
        String genderBorderColor = us09PracticeFormPage.gender.getCssValue("border-color");
        String genderHexColor = Color.fromString(genderBorderColor).asHex();
        System.out.println("genderHexColor = " + genderHexColor);

        Assert.assertEquals(firstNameHexColor, expectedColor);
        Assert.assertEquals(lastnameHexColor, expectedColor);
        Assert.assertEquals(genderHexColor, expectedColor);

        ReusableMethods.waitFor(1);
        String mobileNumberBorderColor = us09PracticeFormPage.mobile.getCssValue("border-color");
        String mobileNumberHexColor = Color.fromString(mobileNumberBorderColor).asHex();

        Assert.assertEquals(mobileNumberHexColor, expectedColor);
        Driver.getDriver().navigate().refresh();

    }


    @Test(priority = 4, dependsOnMethods = "setup")
    //Gecerli bir mail ile submit yapilabilmelidir
    public void US0938(){
        us09PracticeFormPage.practiceFormButton.click();

        for (int i = 1; i < 9; i++) {
            ReusableMethods.waitFor(1);
            us09PracticeFormPage.userEmail.sendKeys(ConfigurationReader.getProperty("invalid_email_" + i));
            action.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitFor(1);
            us09PracticeFormPage.submit.click();
            ReusableMethods.waitFor(1);
            String userEmailBorderColor = us09PracticeFormPage.userEmail.getCssValue("border-color");
            String userEmailHexColor = Color.fromString(userEmailBorderColor).asHex();
            String expectedColor = "#dc3545";
            Assert.assertEquals(userEmailHexColor, expectedColor);
            Driver.getDriver().navigate().refresh();
        }

        us09PracticeFormPage.userEmail.sendKeys(ConfigurationReader.getProperty("valid_email"));
        ReusableMethods.waitFor(1/2);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        //ReusableMethods.waitForClickablility(us09PracticeFormPage.submit,2);
        us09PracticeFormPage.submit.click();
        ReusableMethods.waitFor(1);
        String userEmailBorderColor = us09PracticeFormPage.userEmail.getCssValue("border-color");
        String userEmailHexColor = Color.fromString(userEmailBorderColor).asHex();
        String expectedColor = "#28a745";
        Assert.assertEquals(userEmailHexColor, expectedColor);
        ReusableMethods.waitFor(1/2);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(1/2);
    }

    @Test(priority = 5, dependsOnMethods = "setup")
    //Mobile TextBox kismina gercek bir mobile number ile submit yapilabilmelidir
    public void US0939() {
        us09PracticeFormPage.practiceFormButton.click();
        String minlength = us09PracticeFormPage.mobile.getAttribute("minlength");
        String maxlength = us09PracticeFormPage.mobile.getAttribute("maxlength");
        String expectedlength = "10";
        Assert.assertEquals(minlength, expectedlength);
        Assert.assertEquals(maxlength, expectedlength);

        us09PracticeFormPage.mobile.sendKeys("123456789");
        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        us09PracticeFormPage.submit.click();
        ReusableMethods.waitFor(1);
        String mobileHexColor = ReusableMethods.getHexColor(us09PracticeFormPage.mobile, "border-color");
        System.out.println("mobileHexColor = " + mobileHexColor);
        String expectedColor = "#dc3545";
        Assert.assertEquals(mobileHexColor, expectedColor);
        Driver.getDriver().navigate().refresh();

    }

    @Test(priority = 6, dependsOnMethods = "setup")
    //Hobbies  checkBoxlari secilebilir olmalidir
    public void US0940() {
        us09PracticeFormPage.practiceFormButton.click();

        action.click(us09PracticeFormPage.hobbyMusic).perform();
        Assert.assertTrue(us09PracticeFormPage.hobbyMusic.isSelected());

        action.click(us09PracticeFormPage.hobbyReading).perform();
        Assert.assertTrue(us09PracticeFormPage.hobbyReading.isSelected());

        action.click(us09PracticeFormPage.hobbySports).perform();
        Assert.assertTrue(us09PracticeFormPage.hobbySports.isSelected());
        Driver.getDriver().navigate().refresh();

    }


    @Test(priority = 7, dependsOnMethods = "setup")
    public void US0941() {
        //Gecerli veriler ile submit yapilabilmelidir

        ReusableMethods.waitFor(1);
        us09PracticeFormPage.practiceFormButton.click();
        us09PracticeFormPage.firstName.sendKeys("Ahmet");
        us09PracticeFormPage.lastName.sendKeys("Murat");
        us09PracticeFormPage.userEmail.sendKeys("ahmetmurat@gmail.com");

        action.click(us09PracticeFormPage.male).perform();
        ReusableMethods.waitFor(1);

        action.sendKeys(us09PracticeFormPage.mobile, "1234567890").perform();

        //ReusableMethods.waitFor(1/2);


        action.click(us09PracticeFormPage.dateOfBirth).perform();
        Select month = new Select(us09PracticeFormPage.monthDropdown);
        month.selectByIndex(4);
        Select year = new Select(us09PracticeFormPage.yearDropdown);
        year.selectByVisibleText("2014");

        action.click(us09PracticeFormPage.day).perform();

        ReusableMethods.waitFor(1);

        us09PracticeFormPage.subjects.click();

        action.sendKeys(us09PracticeFormPage.subjects, "Testing US09").perform();

        ReusableMethods.waitFor(1/2);

        action.click(us09PracticeFormPage.hobbySports).perform();

        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        String uploadFile = "C:\\Users\\abdkz\\OneDrive\\Desktop\\images.png";

        us09PracticeFormPage.chooseFile.sendKeys(uploadFile);
        ReusableMethods.waitForClickablility(us09PracticeFormPage.currentAddress,5);
        //ReusableMethods.waitFor(1);

        us09PracticeFormPage.currentAddress.sendKeys(ConfigurationReader.getProperty("textBox_currentAddress"));
        ReusableMethods.waitFor(1/2);


        action.sendKeys(us09PracticeFormPage.selectState, "Haryana" + Keys.ENTER).perform();

        ReusableMethods.waitFor(1/2);
        action.sendKeys(us09PracticeFormPage.selectCity, "Karnal" + Keys.ENTER).perform();

        us09PracticeFormPage.submit.click();


        String[] expectedOutput = {"Label Values", "Student Name Ahmet Murat", "Student Email ahmetmurat@gmail.com", "Gender Male", "Mobile 1234567890", "Date of Birth 13 May,2014", "Subjects", "Hobbies Sports", "Picture images.png", "Address asdfg", "State and City Haryana Karnal"};
        for (int i = 0; i < expectedOutput.length; i++) {
            Assert.assertEquals(us09PracticeFormPage.submitOutput.get(i).getText(), expectedOutput[i]);
        }
    }

    @AfterClass
    public void tearDown(){
        Driver.closeDriver();
    }

}