package com.demoqa.tests;


import com.demoqa.pages.US09_PracticeForm_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

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
        ReusableMethods.waitForClickablility(us09PracticeFormPage.formsButton,10);
        //ReusableMethods.clickWithJS(us09PracticeFormPage.formsButton);
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
        ReusableMethods.waitForClickablility(us09PracticeFormPage.submit, 10);
        ReusableMethods.clickWithJS(us09PracticeFormPage.submit);
        ReusableMethods.waitFor(1);
        String expectedColor = "#dc3545";
        String firstNameBorderColor = us09PracticeFormPage.firstName.getCssValue("border-color");
        System.out.println("firstNameBorderColor = " + firstNameBorderColor);
        String firstNameHexColor = Color.fromString(firstNameBorderColor).asHex();
        System.out.println("firstNameHexColor = " + firstNameHexColor);
        String lastNameBorderColor = us09PracticeFormPage.lastName.getCssValue("border-color");
        String lastnameHexColor = Color.fromString(lastNameBorderColor).asHex();

        ReusableMethods.waitForClickablility(us09PracticeFormPage.gender,10);
        String genderBorderColor = us09PracticeFormPage.gender.getCssValue("border-color");
        String genderHexColor = Color.fromString(genderBorderColor).asHex();
        System.out.println("genderHexColor = " + genderHexColor);

        Assert.assertEquals(firstNameHexColor, expectedColor);
        Assert.assertEquals(lastnameHexColor, expectedColor);
        Assert.assertEquals(genderHexColor, expectedColor);

        ReusableMethods.waitForVisibility(us09PracticeFormPage.mobile,10);
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
            ReusableMethods.waitForClickablility(us09PracticeFormPage.userEmail,10);
            us09PracticeFormPage.userEmail.sendKeys(ConfigurationReader.getProperty("invalid_email_" + i));
            ReusableMethods.waitForClickablility(us09PracticeFormPage.submit,10);
            ReusableMethods.clickWithJS(us09PracticeFormPage.submit);
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
        ReusableMethods.clickWithJS(us09PracticeFormPage.submit);
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
        ReusableMethods.waitForClickablility(us09PracticeFormPage.submit,10);
        ReusableMethods.clickWithJS(us09PracticeFormPage.submit);
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
        ReusableMethods.clickWithJS( us09PracticeFormPage.practiceFormButton);
        ReusableMethods.clickWithJS(us09PracticeFormPage.hobbyMusic);
        Assert.assertTrue(us09PracticeFormPage.hobbyMusic.isSelected());

        ReusableMethods.clickWithJS(us09PracticeFormPage.hobbyReading);
        Assert.assertTrue(us09PracticeFormPage.hobbyReading.isSelected());
        ReusableMethods.clickWithJS(us09PracticeFormPage.hobbySports);
        Assert.assertTrue(us09PracticeFormPage.hobbySports.isSelected());
        Driver.getDriver().navigate().refresh();

    }


    @Test(priority = 7, dependsOnMethods = "setup")
    public void US0941() {
        //Gecerli veriler ile submit yapilabilmelidir



        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForClickablility(us09PracticeFormPage.practiceFormButton,10);
        ReusableMethods.clickWithJS( us09PracticeFormPage.practiceFormButton);

       // ReusableMethods.clickWithJS(us09PracticeFormPage.selectState);
        ReusableMethods.clickStaleElement(us09PracticeFormPage.selectState);
        action.sendKeys(us09PracticeFormPage.selectState,"Haryana"+ Keys.ENTER).build().perform();
        ReusableMethods.clickStaleElement(us09PracticeFormPage.selectCity);
        action.sendKeys(us09PracticeFormPage.selectCity, "Karnal" + Keys.ENTER).build().perform();


//            boolean result = false;
//            int attempts = 0;
//            while(attempts < 500) {
//                try {
//                    Driver.getDriver().navigate().refresh();
//                    ReusableMethods.clickWithJS(us09PracticeFormPage.selectState);
//                    action.sendKeys(us09PracticeFormPage.selectState,"Haryana"+ Keys.ENTER).build().perform();
//                    ReusableMethods.clickWithJS(us09PracticeFormPage.selectCity);
//                    action.sendKeys(us09PracticeFormPage.selectCity, "Karnal" + Keys.ENTER).build().perform();
//                    result = true;
//                    break;
//                } catch(Exception e) {
//                    System.out.println("StaleElementException");
//                }
//                attempts++;
//            }


       // action.sendKeys(us09PracticeFormPage.selectState,"Haryana"+ Keys.ENTER).build().perform();
//        ReusableMethods.clickWithJS(us09PracticeFormPage.selectCity);
//        action.sendKeys(us09PracticeFormPage.selectCity, "Karnal" + Keys.ENTER).build().perform();

        us09PracticeFormPage.firstName.sendKeys("Ahmet");
        us09PracticeFormPage.lastName.sendKeys("Murat");
        us09PracticeFormPage.userEmail.sendKeys("ahmetmurat@gmail.com");

        ReusableMethods.clickWithJS(us09PracticeFormPage.male);
        ReusableMethods.waitFor(2);
        us09PracticeFormPage.mobile.sendKeys("1234567890");


        ReusableMethods.clickWithJS(us09PracticeFormPage.dateOfBirth);
        Select month = new Select(us09PracticeFormPage.monthDropdown);
        month.selectByIndex(4);
        Select year = new Select(us09PracticeFormPage.yearDropdown);
        year.selectByVisibleText("2014");

        ReusableMethods.clickWithJS(us09PracticeFormPage.day);

        ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(us09PracticeFormPage.subjects);


        ReusableMethods.waitFor(1/2);

        ReusableMethods.clickWithJS(us09PracticeFormPage.hobbySports);

        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        String uploadFile = "C:\\Users\\abdkz\\OneDrive\\Desktop\\images.png";

        us09PracticeFormPage.chooseFile.sendKeys(uploadFile);
        //ReusableMethods.waitForClickablility(us09PracticeFormPage.currentAddress,5);
        ReusableMethods.waitForVisibility(us09PracticeFormPage.currentAddress,10);
        us09PracticeFormPage.currentAddress.sendKeys(ConfigurationReader.getProperty("textBox_currentAddress"));


        ReusableMethods.clickWithJS(us09PracticeFormPage.submit);


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