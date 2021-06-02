package com.demoqa.tests;


import com.demoqa.pages.US01_TextBox_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class US01_TextBox_Test {
    public US01_TextBox_Page us01TextBoxPage;

    @BeforeMethod
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        us01TextBoxPage = new US01_TextBox_Page();
        us01TextBoxPage.elementsCard.click();}


    @Test
    public void TC01() {
        String textBoxText = us01TextBoxPage.textBoxButton.getText();
        Assert.assertEquals(textBoxText, "Text Box");

    }

    @Test
    public void TC02() {

        us01TextBoxPage.textBoxButton.click();
        String textBoxHeader = us01TextBoxPage.textBoxHeader.getText();
        //System.out.println("textBoxHeader = " + textBoxHeader);
        String expectedTextBoxHeader = "Text Box";
        Assert.assertEquals(textBoxHeader, expectedTextBoxHeader);
    }

    @Test
    public void TC03Part1() {

        Assert.assertTrue(us01TextBoxPage.textBoxButton.isEnabled());
        us01TextBoxPage.textBoxButton.click();

        String actualUserForm = us01TextBoxPage.userForm.getText();
        String[] expectedUserForm = {"Full Name", "Email", "Current Address", "Permanent Address", "Submit"};

        //System.out.println("***************************************************");

        for (String a : expectedUserForm) {
            Assert.assertTrue(actualUserForm.contains(a));


        }

        Assert.assertTrue(us01TextBoxPage.fullName.isDisplayed()&&us01TextBoxPage.fullName.isEnabled());
        Assert.assertTrue(us01TextBoxPage.email.isDisplayed()&&us01TextBoxPage.email.isEnabled());
        Assert.assertTrue(us01TextBoxPage.currentAddress.isDisplayed()&&us01TextBoxPage.currentAddress.isEnabled());
        Assert.assertTrue(us01TextBoxPage.permanentAddress.isDisplayed()&&us01TextBoxPage.permanentAddress.isEnabled());
        Assert.assertTrue(us01TextBoxPage.submit.isDisplayed()&&us01TextBoxPage.submit.isEnabled());

    }
    @Test
    public void TC03Part2Positive() {

        us01TextBoxPage.textBoxButton.click();
        us01TextBoxPage.email.sendKeys(ConfigurationReader.getProperty("valid_email"));
        us01TextBoxPage.submit.click();
        ReusableMethods.waitFor(1);
        String emailAttribute = us01TextBoxPage.email.getAttribute("class");
        String validEmailAttribute = "mr-sm-2 form-control";
        Assert.assertEquals(validEmailAttribute, emailAttribute);

    }
    @Test
    public void TC03Part2Negative(){
        us01TextBoxPage.textBoxButton.click();

        for (int i = 1 ; i <9 ; i++) {
            us01TextBoxPage.email.sendKeys(ConfigurationReader.getProperty("invalid_email_" + i));

            us01TextBoxPage.submit.click();
            ReusableMethods.waitFor(1);
            String invalidEmailAttribute=us01TextBoxPage.email.getAttribute("class");
            Assert.assertTrue(invalidEmailAttribute.contains("error"));
            Driver.getDriver().navigate().refresh();

        }
    }

    @Test
    public void TC04(){
        us01TextBoxPage.textBoxButton.click();
        String expectedFullName=ConfigurationReader.getProperty("textBox_fullName");
        String expectedEmail=ConfigurationReader.getProperty("valid_email");
        String expectedCurrentAddress=ConfigurationReader.getProperty("textBox_currentAddress");
        String expectedPermanentAddress=ConfigurationReader.getProperty("textBox_permanentAddress");


        us01TextBoxPage.fullName.sendKeys(expectedFullName);
        us01TextBoxPage.email.sendKeys(expectedEmail);
        us01TextBoxPage.currentAddress.sendKeys(expectedCurrentAddress);
        us01TextBoxPage.permanentAddress.sendKeys(expectedPermanentAddress);

        us01TextBoxPage.submit.click();
        String submitOutputText=us01TextBoxPage.submitOutput.getText();

        ArrayList<String> expectedOutput= new ArrayList<String>();
        expectedOutput.add(expectedFullName);
        expectedOutput.add(expectedEmail);
        expectedOutput.add(expectedCurrentAddress);
        expectedOutput.add(expectedPermanentAddress);

        for (String b: expectedOutput) {
            Assert.assertTrue(submitOutputText.contains(b));
            // System.out.println("b = " + b);
        }
//        System.out.println("************************************");
//        System.out.println("expectedOutput = " + expectedOutput);
//        System.out.println("*********************************");
//        System.out.println(submitResultText);

    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
}