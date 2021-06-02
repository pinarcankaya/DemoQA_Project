package com.demoqa.tests;

import com.demoqa.pages.US11_Alert_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US11_Alert_Test {

    US11_Alert_Page alertPage = new US11_Alert_Page();
    Actions actions = new Actions(Driver.getDriver());


    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        alertPage.elementsCard.click();
        alertPage.elementsMenuLink.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(2);
        alertPage.alertFrameWindoswMenu.click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        ReusableMethods.waitFor(2);
    }

    //Alerts, Frame & Windows menusune tiklandiginda Alerts menu linki goruntulenmelidir
    @Test
    public void TC1101() {
        Assert.assertTrue(alertPage.alertMenuLink.isDisplayed());
    }

    //Alerts menu linkine tiklandiginda 4 tane Click me butonu olmalidir
    @Test
    public void TC1102() {
        alertPage.alertMenuLink.click();
        System.out.println(alertPage.allClickMeButton.size());
        Assert.assertEquals(alertPage.allClickMeButton.size(), 4);

    }

    //Birinci Click me butonuna tiklandiginda cikan alertte "You clicked a button" texti  olmalidir
    @Test
    public void TC1103() {
        alertPage.alertMenuLink.click();
        alertPage.allClickMeButton.get(0).click();
        String clickMeButton1 = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(clickMeButton1, "You clicked a button");
    }

    //Ikinci Click me butonuna tiklandiginda 5 saniye icinde cikan alertte OK butonuna tiklanabildigini dogrulayiniz
    @Test
    public void TC1104() {
        alertPage.alertMenuLink.click();
        alertPage.allClickMeButton.get(1).click();
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 5);
        webDriverWait.until(ExpectedConditions.alertIsPresent());

        String text = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(text, "This alert appeared after 5 seconds");

        Driver.getDriver().switchTo().alert().accept();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        alertPage.alertFrameWindoswMenu.click();
        Assert.assertTrue(alertPage.alertFrameWindoswMenu.isEnabled());
    }

    //Ucuncu Click me butonuna tiklandiginda cikan alertte Cancel'e tiklandiktan sonra "You selected Cancel" texti
    // goruntulendigini verify ediniz
    @Test
    public void TC1105() {
        alertPage.alertMenuLink.click();
        alertPage.allClickMeButton.get(2).click();
        Driver.getDriver().switchTo().alert().dismiss();
        String succesText = alertPage.alert3SuccesText.getText();
        Assert.assertEquals(succesText, "You selected Cancel");
    }

    //Dorduncu Click me butonuna tiklandiginda cikan alert'e text girilebildigini dogrulayiniz
    //OK butonuna tiklandiktan sonra girilen text "On button click, prompt box will appear" texti altinda goruntulendigini dogrulayiniz
    @Test
    public void TC1106() {
        alertPage.alertMenuLink.click();
        alertPage.allClickMeButton.get(3).click();

        String text="Hello";
        Driver.getDriver().switchTo().alert().sendKeys(text);
        Driver.getDriver().switchTo().alert().accept();
        String succesText=alertPage.alert4SuccesText.getText();
        System.out.println(succesText);
        Assert.assertEquals(succesText, "You entered "+text);
       // System.out.println(alertPage.clickMe4AllText.getText());

    }



















}
