package com.demoqa.tests;


import com.demoqa.pages.US01_TextBox_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class US01_TextBox_Test {
    public US01_TextBox_Page us01TextBoxPage;

    @BeforeClass
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        us01TextBoxPage = new US01_TextBox_Page();
        us01TextBoxPage.elementsCard.click();}
    Actions action=new Actions(Driver.getDriver());


    @Test
    public void TC0101() {
        String textBoxText = us01TextBoxPage.textBoxButton.getText();
        Assert.assertEquals(textBoxText, "Text Box");

    }

    @Test
    public void TC0102() {


        us01TextBoxPage.textBoxButton.click();
        String textBoxHeader = us01TextBoxPage.textBoxHeader.getText();

        String expectedTextBoxHeader = "Text Box";
        Assert.assertEquals(textBoxHeader, expectedTextBoxHeader);
    }

    @Test
    public void TC0103() {

        Assert.assertTrue(us01TextBoxPage.textBoxButton.isEnabled());
        us01TextBoxPage.textBoxButton.click();

        String actualUserForm = us01TextBoxPage.userForm.getText();
        String[] expectedUserForm = {"Full Name", "Email", "Current Address", "Permanent Address", "Submit"};



        for (String a : expectedUserForm) {
            Assert.assertTrue(actualUserForm.contains(a));

        }

        Assert.assertTrue(us01TextBoxPage.fullName.isDisplayed()&&us01TextBoxPage.fullName.isEnabled());
        Assert.assertTrue(us01TextBoxPage.email.isDisplayed()&&us01TextBoxPage.email.isEnabled());
        Assert.assertTrue(us01TextBoxPage.currentAddress.isDisplayed()&&us01TextBoxPage.currentAddress.isEnabled());
        Assert.assertTrue(us01TextBoxPage.permanentAddress.isDisplayed()&&us01TextBoxPage.permanentAddress.isEnabled());
        Assert.assertTrue(us01TextBoxPage.submit.isDisplayed()&&us01TextBoxPage.submit.isEnabled());

        //ReusableMethods.waitFor(1/2);
        ReusableMethods.waitForClickablility(us01TextBoxPage.email,10);

        us01TextBoxPage.email.sendKeys(ConfigurationReader.getProperty("valid_email"));
        ReusableMethods.waitFor(1/2);
       // action.sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.clickWithJS(us01TextBoxPage.submit);
        us01TextBoxPage.submit.click();
        ReusableMethods.waitForClickablility(us01TextBoxPage.email,10);
        //ReusableMethods.waitFor(1);
        String emailAttribute = us01TextBoxPage.email.getAttribute("class");
        String validEmailAttribute = "mr-sm-2 form-control";
        Assert.assertEquals(validEmailAttribute, emailAttribute);
        ReusableMethods.waitFor(1/2);

        Driver.getDriver().navigate().refresh();


        for (int i = 1 ; i <9 ; i++) {
            ReusableMethods.clickWithJS(us01TextBoxPage.email);
            us01TextBoxPage.email.sendKeys(ConfigurationReader.getProperty("invalid_email_" + i));
            ReusableMethods.waitFor(1/2);
            action.sendKeys(Keys.PAGE_DOWN).perform();
            ReusableMethods.waitForClickablility(us01TextBoxPage.submit,10);
            //ReusableMethods.waitFor(1);
            ReusableMethods.clickWithJS(us01TextBoxPage.submit);
            //us01TextBoxPage.submit.click();
            //ReusableMethods.waitFor(1);
            String invalidEmailAttribute=us01TextBoxPage.email.getAttribute("class");
            Assert.assertTrue(invalidEmailAttribute.contains("error"));
            ReusableMethods.waitFor(1/2);
            Driver.getDriver().navigate().refresh();
            ReusableMethods.waitFor(1/2);
        }
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(1);
    }


    @Test
    public void TC0104(){
        us01TextBoxPage.textBoxButton.click();
        String expectedFullName=ConfigurationReader.getProperty("textBox_fullName");
        String expectedEmail=ConfigurationReader.getProperty("valid_email");
        String expectedCurrentAddress=ConfigurationReader.getProperty("textBox_currentAddress");
        String expectedPermanentAddress=ConfigurationReader.getProperty("textBox_permanentAddress");

        Driver.getDriver().navigate().refresh();
        us01TextBoxPage.fullName.sendKeys(expectedFullName);
        us01TextBoxPage.email.sendKeys(expectedEmail);
        us01TextBoxPage.currentAddress.sendKeys(expectedCurrentAddress);
        us01TextBoxPage.permanentAddress.sendKeys(expectedPermanentAddress);

        ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForClickablility(us01TextBoxPage.submit,10);
        //ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(us01TextBoxPage.submit);
        //us01TextBoxPage.submit.click();
        String submitOutputText=us01TextBoxPage.submitOutput.getText();

        ArrayList<String> expectedOutput= new ArrayList<String>();
        expectedOutput.add(expectedFullName);
        expectedOutput.add(expectedEmail);
        expectedOutput.add(expectedCurrentAddress);
        expectedOutput.add(expectedPermanentAddress);

        for (String b: expectedOutput) {
            Assert.assertTrue(submitOutputText.contains(b));

        }

    }

    @AfterClass
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}

//<class name="com.demoqa.tests.US023_SelectMenu_Test"/>
//                    <class name="com.demoqa.tests.US30_BookStoreMenu_Test"/>