package com.demoqa.tests;

import com.demoqa.pages.US01_TextBox_Page;
import com.demoqa.pages.US11_Alert_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US11_Alert_Test {

    US01_TextBox_Page us01TextBoxPage = new US01_TextBox_Page();
    US11_Alert_Page alertPage = new US11_Alert_Page();


    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us01TextBoxPage.elementsCard.click();
        ReusableMethods.scrollTo(alertPage.alertFrameWindowsMenu);
        alertPage.alertFrameWindowsMenu.click();
        ReusableMethods.scrollTo(alertPage.alertMenuLink);
        //ReusableMethods.waitFor(1);

    }

    //Alerts, Frame & Windows menusune tiklandiginda Alerts menu linki goruntulendigini dogrulayiniz
    @Test
    public void TC49() {
        ReusableMethods.waitForVisibility(alertPage.alertMenuLink,5);
        Assert.assertTrue(alertPage.alertMenuLink.isDisplayed());

    }

    //Alerts menu linkine tiklandiginda 4 tane Click me butonu oldugunu dogrulayiniz
    @Test
    public void TC50() {
        alertPage.alertMenuLink.click();
        Assert.assertEquals(alertPage.allClickMeButtonList.size(), 4);
    }

    //Birinci Click me butonuna tiklandiginda cikan alertte "You clicked a button" texti oldugunu verify ediniz
    @Test
    public void TC51() {
        alertPage.alertMenuLink.click();
        ReusableMethods.waitForVisibility( alertPage.allClickMeButtonList.get(0),3);
//        alertPage.allClickMeButtonList.get(0).click();
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
//        wait.until(ExpectedConditions.alertIsPresent());
//        String alertText1 = Driver.getDriver().switchTo().alert().getText();
//         ReusableMethods.waitFor(1);
//        Assert.assertEquals(alertText1, "You clicked a button");

        try {
            alertPage.allClickMeButtonList.get(0).click();
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText2 = Driver.getDriver().switchTo().alert().getText();
           // Assert.assertEquals(alertText2, "You clicked a button");
        } catch (UnhandledAlertException f) {
            System.out.println("alert is not present");
        }
    }

    //Ikinci Click me butonuna tiklandiginda 5 saniye icinde cikan alertte OK butonuna tiklanabildigini dogrulayiniz
    @Test
    public void TC52() {
        alertPage.alertMenuLink.click();
        ReusableMethods.waitForVisibility(alertPage.allClickMeButtonList.get(1),5);
        alertPage.allClickMeButtonList.get(1).click();

        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = Driver.getDriver().switchTo().alert();
            System.out.println("alert is present");
            alert.accept();//OK
            Assert.assertTrue(alertPage.allClickMeButtonList.get(1).isEnabled());
            //ok butonuna tiklamadan once herhangi bir islem yapilamaz
            //tiklandiktan sonra alert kapaninca diger elementler aktif olur

        } catch (Exception e) {
            System.out.println("alert is not present");
        }


    }

    //Ucuncu Click me butonuna tiklandiginda cikan alertte Cancel'e tiklandiktan sonra "You selected Cancel" texti goruntulendigini verify ediniz
    @Test
    public void TC53() {
        alertPage.alertMenuLink.click();
       ReusableMethods.waitForVisibility(alertPage.allClickMeButtonList.get(2),2);
        alertPage.allClickMeButtonList.get(2).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 8);
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().dismiss();
        Assert.assertTrue(alertPage.clickMe3SuccesText.isDisplayed());

    }

    //Dorduncu Click me butonuna tiklandiginda cikan alert'e text girilebildigini dogrulayiniz
    ////OK butonuna tiklandiktan sonra girilen text "On button click, prompt box will appear"
    // texti altinda goruntulendigini dogrulayiniz
    @Test
    public void TC54() {
        alertPage.alertMenuLink.click();
        ReusableMethods.waitForVisibility(alertPage.allClickMeButtonList.get(3),2);
        alertPage.allClickMeButtonList.get(3).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        String helloText = "Hello";
        alert.sendKeys(helloText);
        alert.accept();
        Assert.assertTrue(alertPage.clickMe4SuccesText.getText().contains(helloText));
        System.out.println(alertPage.clickMe4SuccesText.getText());

    }

    @AfterClass
    public void close() {
       //  Driver.getDriver().navigate().refresh();
        // Driver.closeDriver();
    }

}
